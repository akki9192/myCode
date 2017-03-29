package com.ge.pmms.dao.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.ge.pmms.Constants;
import com.ge.pmms.Tools;
import com.ge.pmms.dao.BasicDao;
import com.ge.pmms.dao.ChartDao;
import com.ge.pmms.dto.ChartInfo;
import com.ge.pmms.dto.ChartInfoParam;
import com.ge.pmms.entity.EquipInfoMin;
import com.ge.pmms.entity.EquipmentInfo;
import com.ge.pmms.entity.sparePart;
import com.ge.pmms.exception.PmmsException;


@Repository("chartDaoImpl")
public class ChartDaoImpl extends BasicDao implements ChartDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(ChartDaoImpl.class);
	
	//根保养养年份，查询此年份的PM完成率
		public List<ChartInfo> findPMWONumber(String fromYear,String toYear,String woStatus)throws PmmsException{
			
			StringBuilder hql = new StringBuilder();
			
			hql.append( "select equip.dept_id,dept.dept_name,wo.plan_start_month,count(*) from pmms.equip_info equip,pmms.wo_info wo,pmms.dept_info dept ");
			hql.append( "where  equip.equip_id=wo.equip_id and dept.dept_id=equip.dept_id and ");
			hql.append( " wo.plan_id is not null and ");
			hql.append( " wo.plan_start_month >= :fromYear and wo.plan_start_month <= :toYear ");
			
			if(!StringUtils.isEmpty(woStatus)){
				hql.append( " and wo.wo_status=:woStatus ");
			}
			hql.append( " group by equip.dept_id, dept.dept_name,wo.plan_start_month ");
			hql.append( " order by equip.dept_id ");
			Query query = getSession().createSQLQuery(hql.toString());
			try {
				query.setParameter("fromYear", Tools.parseToDate(fromYear, Constants.DATE_PATTEN));
				query.setParameter("toYear", Tools.parseToDate(toYear, Constants.DATE_PATTEN));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			if(!StringUtils.isEmpty(woStatus)){
				query.setParameter("woStatus", woStatus);
			}
			
			List<?> listResult = query.list();
			
			List<ChartInfo> list = new ArrayList<ChartInfo>();
			ChartInfo chartInfo;
			if(!CollectionUtils.isEmpty(listResult)){
				Iterator<?> ite = listResult.iterator();
				while(ite.hasNext()){
					Object[] obj = (Object[])ite.next();
					chartInfo = new ChartInfo();
					chartInfo.setDeptId(obj[0].toString());
					chartInfo.setDeptNm(obj[1].toString());
					chartInfo.setMaintMonth(String.valueOf(((Date)obj[2]).getMonth()+1));
					chartInfo.setCount(Tools.isNull(obj[3])?0.0:Double.parseDouble(String.valueOf(obj[3])));
					list.add(chartInfo);
				}
			}
			return list;
		}
		
		//根据设备编号、年份和计划工单完成状态，查询单个设备的年度计划工单数量。
		public List<ChartInfo> findSinglePMWONumber(String equipId,String fromYear,String toYear,String woStatus)throws PmmsException{
			StringBuilder hql = new StringBuilder();
			hql.append( "select count(wo.plan_start_month) num,date_part('month',wo.plan_start_month) maintMonth from pmms.wo_info wo");
			hql.append( " where wo.plan_id is not null and ");
			hql.append( " wo.plan_start_month >= :fromYear and wo.plan_start_month <= :toYear and ");
			hql.append( " wo.equip_id=:equipId ");
			
			if(!StringUtils.isEmpty(woStatus)){
				hql.append( " and wo.wo_status=:woStatus ");
			}
			hql.append( " group by wo.plan_start_month ");
			Query query = getSession().createSQLQuery(hql.toString());
			query.setParameter("equipId", equipId);
			
			try {
				query.setParameter("fromYear", Tools.parseToDate(fromYear, Constants.DATE_PATTEN));
				query.setParameter("toYear", Tools.parseToDate(toYear, Constants.DATE_PATTEN));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			if(!StringUtils.isEmpty(woStatus)){
				query.setParameter("woStatus", woStatus);
			}
			
			List<?> listResult = query.list();
			
			List<ChartInfo> list = new ArrayList<ChartInfo>();
			ChartInfo chartInfo;
			if(!CollectionUtils.isEmpty(listResult)){
				Iterator<?> ite = listResult.iterator();
				while(ite.hasNext()){
					Object[] obj = (Object[])ite.next();
					chartInfo = new ChartInfo();
					chartInfo.setCount(Tools.isNull(obj[0])?0.0:Double.parseDouble(String.valueOf(obj[0])));
					chartInfo.setMaintMonth(String.valueOf(((Double)obj[1]).intValue()));
					list.add(chartInfo);
				}
			}
			return list;
		}
		
		//按年分组，查询五大部门的计划工单数量。
		public List<ChartInfo> findPMWONumberByYear(String fromYear,String toYear,String woStatus)throws PmmsException{
			StringBuilder hql = new StringBuilder();
			hql.append( "select equip.dept_id,dept.dept_name ,date_part('year',wo.plan_start_month) planYear,count(*) num from pmms.equip_info equip,pmms.wo_info wo,pmms.dept_info dept");
			hql.append( " where  equip.equip_id=wo.equip_id and dept.dept_id=equip.dept_id and ");
			hql.append( " wo.plan_id is not null and ");
			hql.append( " wo.plan_start_month >= :fromYear and wo.plan_start_month <= :toYear ");
			
			if(!StringUtils.isEmpty(woStatus)){
				hql.append( " and wo.wo_status=:woStatus ");
			}
			hql.append( " group by equip.dept_id, dept.dept_name,date_part('year',wo.plan_start_month) ");
			hql.append( " order by equip.dept_id  ");
			Query query = getSession().createSQLQuery(hql.toString());
			
			try {
				query.setParameter("fromYear", Tools.parseToDate(fromYear, Constants.DATE_PATTEN));
				query.setParameter("toYear", Tools.parseToDate(toYear, Constants.DATE_PATTEN));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			
			if(!StringUtils.isEmpty(woStatus)){
				query.setParameter("woStatus", woStatus);
			}
			List<?> listResult = query.list();
			
			List<ChartInfo> list = new ArrayList<ChartInfo>();
			ChartInfo chartInfo;
			if(!CollectionUtils.isEmpty(listResult)){
				Iterator<?> ite = listResult.iterator();
				while(ite.hasNext()){
					Object[] obj = (Object[])ite.next();
					System.out.println("================"+obj[2].toString());
					chartInfo = new ChartInfo();
					chartInfo.setDeptId(obj[0].toString());
					chartInfo.setDeptNm(obj[1].toString());
					chartInfo.setMaintMonth(String.valueOf(((Double)obj[2]).intValue()));
					chartInfo.setCount(Tools.isNull(obj[3])?0.0:Double.parseDouble(String.valueOf(obj[3])));
					list.add(chartInfo);
				}
			}
			return list;
		}
		
		//查询某一年的故障维修工单
		public List<ChartInfo> findMaintRecordByYear(String miantStartDate,String miantEndDate)throws PmmsException{
			StringBuilder hql = new StringBuilder();
			hql.append( "select dept.dept_id,dept.dept_name dept_name,equip.equip_id,wo_maint.maint_start_date,wo_maint.maint_end_date");
			hql.append( " from pmms.wo_maint_info wo_maint,pmms.wo_info wo,pmms.equip_info equip,pmms.dept_info dept  ");
			hql.append( " where wo_maint.wo_id = wo.wo_id and wo.equip_id = equip.equip_id and dept.dept_id = equip.dept_id and  ");
			hql.append( " wo_maint.maint_start_date<:miantEndDate and wo_maint.maint_end_date>:miantStartDate ");
			hql.append( " union all ");
			hql.append( "select dept.dept_id,dept.dept_name,equip.equip_id,wo_maint.maint_start_date,wo_maint.maint_end_date");
			hql.append( " from pmms.wo_maint_info wo_maint,pmms.wo_info wo,pmms.equip_info equip,pmms.dept_info dept  ");
			hql.append( " where wo_maint.wo_id = wo.wo_id and wo.equip_id = equip.equip_id and dept.dept_id = equip.dept_id and  ");
			hql.append( " wo_maint.maint_start_date<:miantEndDate and wo_maint.maint_end_date is null ");
			
			Query query = getSession().createSQLQuery(hql.toString());
			try {
				query.setParameter("miantStartDate", Tools.parseToDate(miantStartDate, Constants.DATE_PATTEN));
				query.setParameter("miantEndDate", Tools.parseToDate(miantEndDate, Constants.DATE_PATTEN));
			} catch (ParseException e) {
				LOGGER.error("faied to parse date!", e);
				throw new PmmsException(e,"faied to parse date!");
			}
			
			List<?> listResult = query.list();
			
			List<ChartInfo> list = new ArrayList<ChartInfo>();
			ChartInfo chartInfo;
			if(!CollectionUtils.isEmpty(listResult)){
				Iterator<?> ite = listResult.iterator();
				while(ite.hasNext()){
					Object[] obj = (Object[])ite.next();
					chartInfo = new ChartInfo();
					chartInfo.setDeptId(obj[0].toString());
					chartInfo.setDeptNm(obj[1].toString());
					chartInfo.setEquipId(obj[2].toString());
					chartInfo.setMaintStartDate((Date)obj[3]);
					chartInfo.setMaintEndDate(Tools.isNull(obj[4])?(new Date()):(Date)obj[4]);//维修结束时间为null,则是当前系统时间
					
					list.add(chartInfo);
				}
			}
			return list;
		}
		
		//查询单个设备的MTTR
		public List<ChartInfo> findSingleMaintRecordByYear(String equipId,String miantStartDate,String miantEndDate)throws PmmsException{
			StringBuilder hql = new StringBuilder();
			hql.append( "select equip.equip_id,wo_maint.maint_start_date,wo_maint.maint_end_date");
			hql.append( " from pmms.wo_maint_info wo_maint,pmms.wo_info wo,pmms.equip_info equip  ");
			hql.append( " where wo_maint.wo_id = wo.wo_id and wo.equip_id = equip.equip_id and  ");
			hql.append( " wo_maint.maint_start_date<:miantEndDate and wo_maint.maint_end_date>:miantStartDate ");
			hql.append( " and wo.equip_id =:equipId ");
			hql.append( " union all ");
			hql.append( "select equip.equip_id,wo_maint.maint_start_date,wo_maint.maint_end_date");
			hql.append( " from pmms.wo_maint_info wo_maint,pmms.wo_info wo,pmms.equip_info equip  ");
			hql.append( " where wo_maint.wo_id = wo.wo_id and wo.equip_id = equip.equip_id and  ");
			hql.append( " wo_maint.maint_start_date<:miantEndDate and wo_maint.maint_end_date is null ");
			hql.append( " and wo.equip_id =:equipId ");
			
			Query query = getSession().createSQLQuery(hql.toString());
			query.setParameter("equipId", equipId);
			try {
				query.setParameter("miantStartDate", Tools.parseToDate(miantStartDate, Constants.DATE_PATTEN));
				query.setParameter("miantEndDate", Tools.parseToDate(miantEndDate, Constants.DATE_PATTEN));
			} catch (ParseException e) {
				LOGGER.error("faied to parse date!", e);
				throw new PmmsException(e,"faied to parse date!");
			}
			
			List<?> listResult = query.list();
			
			List<ChartInfo> list = new ArrayList<ChartInfo>();
			ChartInfo chartInfo;
			if(!CollectionUtils.isEmpty(listResult)){
				Iterator<?> ite = listResult.iterator();
				while(ite.hasNext()){
					Object[] obj = (Object[])ite.next();
					chartInfo = new ChartInfo();
					chartInfo.setEquipId(obj[0].toString());
					chartInfo.setMaintStartDate((Date)obj[1]);
					chartInfo.setMaintEndDate(Tools.isNull(obj[2])?(new Date()):(Date)obj[2]);
					
					list.add(chartInfo);
				}
			}
			return list;
		}
		
		//按部门，查询近5年的MTTR
		public List<ChartInfo> findMaintRecordForYears(String fromYear)throws PmmsException{
			StringBuilder hql = new StringBuilder();
			hql.append( "select dept.dept_id,dept.dept_name,equip.equip_id,wo_maint.maint_start_date,wo_maint.maint_end_date");
			hql.append( " from pmms.wo_maint_info wo_maint,pmms.wo_info wo,pmms.equip_info equip,pmms.dept_info dept ");
			hql.append( " where wo_maint.wo_id = wo.wo_id and wo.equip_id = equip.equip_id and dept.dept_id = equip.dept_id and ");
			hql.append( " wo_maint.maint_end_date > :fromYear ");
			hql.append( " union all ");
			hql.append( "select dept.dept_id,dept.dept_name,equip.equip_id,wo_maint.maint_start_date,wo_maint.maint_end_date");
			hql.append( " from pmms.wo_maint_info wo_maint,pmms.wo_info wo,pmms.equip_info equip,pmms.dept_info dept ");
			hql.append( " where wo_maint.wo_id = wo.wo_id and wo.equip_id = equip.equip_id and dept.dept_id = equip.dept_id and ");
			hql.append( " wo_maint.maint_end_date is null ");
			
			Query query = getSession().createSQLQuery(hql.toString());
			//query.setParameter("fromYear", Double.parseDouble(fromYear));
			try {
				query.setParameter("fromYear", Tools.parseToDate(fromYear, Constants.DATE_PATTEN_SEC));
			} catch (ParseException e) {
				LOGGER.error("faied to parse date!", e);
				throw new PmmsException(e,"faied to parse date!");
			}
			
//			query.setParameter("toYear", toYear);
			List<?> listResult = query.list();
			
			List<ChartInfo> list = new ArrayList<ChartInfo>();
			ChartInfo chartInfo;
			if(!CollectionUtils.isEmpty(listResult)){
				Iterator<?> ite = listResult.iterator();
				while(ite.hasNext()){
					Object[] obj = (Object[])ite.next();
					chartInfo = new ChartInfo();
					chartInfo.setDeptId(obj[0].toString());
					chartInfo.setDeptNm(obj[1].toString());
					chartInfo.setEquipId(obj[2].toString());
					chartInfo.setMaintStartDate((Date)obj[3]);
					chartInfo.setMaintEndDate(Tools.isNull(obj[4])?(new Date()):(Date)obj[4]);
					
					list.add(chartInfo);
				}
			}
			return list;
		}
		
		public List<ChartInfo> getSpNumBySpId(ChartInfoParam  chartPara){
			StringBuilder sql = new StringBuilder();
			sql.append("select trans.SPARE_PART_ID,SPARE_PART_NAME,sum(amount) as total,date_part('month', CREATE_MONTH) as month");
			sql.append(" from pmms.spare_part_trans_info trans,pmms.spare_part_info info ");
			sql.append(" where trans.SPARE_PART_ID=:spId and TRANS_TYPE='2' and date_part('year', CREATE_MONTH)=:currYear and trans.SPARE_PART_ID=info.SPARE_PART_ID ");
			if(!Tools.isEmpty(chartPara.getMonth())){
				sql.append(" and date_part('month', CREATE_MONTH)=:p_month ");
			}
			
			sql.append(" group by trans.SPARE_PART_ID,CREATE_MONTH,SPARE_PART_NAME order by CREATE_MONTH");
			Query query = getSession().createSQLQuery(sql.toString());
			query.setParameter("spId", chartPara.getSparePartId());
			//Calendar a=Calendar.getInstance();
			query.setParameter("currYear",Double.parseDouble(chartPara.getYear()));
			
			if(!Tools.isEmpty(chartPara.getMonth())){
				query.setParameter("p_month", Double.parseDouble(chartPara.getMonth()));
			}
			
			List<?> rsList = query.list();
			List<ChartInfo> list = new ArrayList<ChartInfo>();
			ChartInfo chartInfo;
			if(!CollectionUtils.isEmpty(rsList)){
				Iterator<?> ite = rsList.iterator();
				while(ite.hasNext()){
					Object[] obj = (Object[])ite.next();
					chartInfo = new ChartInfo();
					chartInfo.setSparePartId(String.valueOf(obj[0]));
					chartInfo.setSparePartName(String.valueOf(obj[1]));
					chartInfo.setCount(Tools.isNull(obj[2])?0.0:Double.parseDouble(String.valueOf(obj[2])));
					chartInfo.setMaintMonth(String.valueOf(((Double)obj[3]).intValue()));
					list.add(chartInfo);
				}
			}
			return list;
		}
		
		public List<ChartInfo> getSpNumBydept(ChartInfoParam  chartPara){
			StringBuilder sql = new StringBuilder();
			sql.append("select date_part('month', CREATE_MONTH) as month,d.DEPT_ID,d.dept_name,sum(a.amount) as total ");
			sql.append("from pmms.spare_part_trans_info a,pmms.wo_info b,pmms.equip_info c,pmms.dept_info d ");
			sql.append("where a.TRANS_TYPE='2' and a.WO_ID=b.WO_ID and b.EQUIP_ID=c.EQUIP_ID and c.DEPT_ID=d.DEPT_ID and date_part('year', CREATE_MONTH)=:currYear ");
			
			if(!Tools.isEmpty(chartPara.getMonth())){
				sql.append(" and date_part('month', CREATE_MONTH)=:p_month ");
			}
			
			sql.append("group by d.DEPT_ID,d.dept_name,a.CREATE_MONTH ");
			Query query = getSession().createSQLQuery(sql.toString());
			query.setParameter("currYear", Double.parseDouble(chartPara.getYear()));
			
			if(!Tools.isEmpty(chartPara.getMonth())){
				query.setParameter("p_month", Double.parseDouble(chartPara.getMonth()));
			}
			
			List<?> rsList = query.list();
			List<ChartInfo> list = new ArrayList<ChartInfo>();
			ChartInfo chartInfo;
			if(!CollectionUtils.isEmpty(rsList)){
				Iterator<?> ite = rsList.iterator();
				while(ite.hasNext()){
					Object[] obj = (Object[])ite.next();
					chartInfo = new ChartInfo();
					chartInfo.setMaintMonth(String.valueOf(((Double)obj[0]).intValue()));
					chartInfo.setDeptId(String.valueOf(obj[1]));
					chartInfo.setDeptNm(String.valueOf(obj[2]));
					chartInfo.setCount(Tools.isNull(obj[3])?0.0:Double.parseDouble(String.valueOf(obj[3])));
					list.add(chartInfo);
				}
			}
			return list;
		}
		
		public List<ChartInfo> getTotalSpNumByMonth(ChartInfoParam  chartPara){
			StringBuilder sql = new StringBuilder();
			sql.append("select date_part('month', CREATE_MONTH) as month,sum(a.amount) as total ");
			sql.append(" from pmms.spare_part_trans_info a,pmms.wo_info b,pmms.equip_info c,pmms.dept_info d ");
			sql.append(" where a.TRANS_TYPE='2' and a.WO_ID=b.WO_ID and b.EQUIP_ID=c.EQUIP_ID and c.DEPT_ID=d.DEPT_ID and date_part('year', CREATE_MONTH)=:year ");
			
			if(!Tools.isEmpty(chartPara.getMonth())){
				sql.append(" and date_part('month', CREATE_MONTH)=:p_month ");
			}
			
			sql.append(" group by a.CREATE_MONTH  ");
			Query query = getSession().createSQLQuery(sql.toString());
		//	Calendar a=Calendar.getInstance();
			query.setParameter("year", Double.parseDouble(chartPara.getYear()));
			
			if(!Tools.isEmpty(chartPara.getMonth())){
				query.setParameter("p_month", Double.parseDouble(chartPara.getMonth()));
			}
			
			List<?> rsList = query.list();
			List<ChartInfo> list = new ArrayList<ChartInfo>();
			ChartInfo chartInfo;
			if(!CollectionUtils.isEmpty(rsList)){
				Iterator<?> ite = rsList.iterator();
				while(ite.hasNext()){
					Object[] obj = (Object[])ite.next();
					chartInfo = new ChartInfo();
					chartInfo.setMaintMonth(String.valueOf(((Double)obj[0]).intValue()));
					chartInfo.setCount(Tools.isNull(obj[1])?0.0:Double.parseDouble(String.valueOf(obj[1])));
					chartInfo.setDeptNm(Constants.DEPT_AVG_NM);
					list.add(chartInfo);
				}
			}
			return list;
		}
		
		public List<ChartInfo> getSpNumByYear(){
			StringBuilder sql = new StringBuilder();
			sql.append("select  DEPT_ID,dept_name,tmp_year,sum(total) as total from ");
			sql.append("(select a.CREATE_MONTH,date_part('month', CREATE_MONTH) as month,date_part('year', CREATE_MONTH) as tmp_year,d.DEPT_ID,d.dept_name,sum(a.amount) as total ");
			sql.append(" from pmms.spare_part_trans_info a,pmms.wo_info b,pmms.equip_info c,pmms.dept_info d  ");
			sql.append(" where a.TRANS_TYPE='2' and a.WO_ID=b.WO_ID and b.EQUIP_ID=c.EQUIP_ID and c.DEPT_ID=d.DEPT_ID ");
			sql.append(" group by d.DEPT_ID,d.dept_name,a.CREATE_MONTH) as temp  ");
			sql.append(" group by DEPT_ID,dept_name,tmp_year ");
			Query query = getSession().createSQLQuery(sql.toString());
			List<?> rsList = query.list();
			List<ChartInfo> list = new ArrayList<ChartInfo>();
			ChartInfo chartInfo;
			if(!CollectionUtils.isEmpty(rsList)){
				Iterator<?> ite = rsList.iterator();
				while(ite.hasNext()){
					Object[] obj = (Object[])ite.next();
					chartInfo = new ChartInfo();
					chartInfo.setMaintMonth(String.valueOf(((Double)obj[2]).intValue()));
					chartInfo.setDeptId(String.valueOf(obj[0]));
					chartInfo.setDeptNm(String.valueOf(obj[1]));
					chartInfo.setCount(Tools.isNull(obj[3])?0.0:Double.parseDouble(String.valueOf(obj[3])));
					list.add(chartInfo);
				}
			}
			return list;
		}
		
		public List<ChartInfo> getTotalSpNumForYear(){
			StringBuilder sql = new StringBuilder();
			sql.append("select  tmp_year,sum(total) as total from ");
			sql.append("(select a.CREATE_MONTH,date_part('month', CREATE_MONTH) as month,date_part('year', CREATE_MONTH) as tmp_year,d.DEPT_ID,d.dept_name,sum(a.amount) as total ");
			sql.append(" from pmms.spare_part_trans_info a,pmms.wo_info b,pmms.equip_info c,pmms.dept_info d  ");
			sql.append(" where a.TRANS_TYPE='2' and a.WO_ID=b.WO_ID and b.EQUIP_ID=c.EQUIP_ID and c.DEPT_ID=d.DEPT_ID  ");
			sql.append(" group by d.DEPT_ID,d.dept_name,a.CREATE_MONTH) as temp  ");
			sql.append(" group by tmp_year ");
			Query query = getSession().createSQLQuery(sql.toString());
			List<?> rsList = query.list();
			List<ChartInfo> list = new ArrayList<ChartInfo>();
			ChartInfo chartInfo;
			if(!CollectionUtils.isEmpty(rsList)){
				Iterator<?> ite = rsList.iterator();
				while(ite.hasNext()){
					Object[] obj = (Object[])ite.next();
					chartInfo = new ChartInfo();
					chartInfo.setMaintMonth(String.valueOf(((Double)obj[0]).intValue()));
					chartInfo.setCount(Tools.isNull(obj[1])?0.0:Double.parseDouble(String.valueOf(obj[1])));
					chartInfo.setDeptNm(Constants.DEPT_AVG_NM);
					list.add(chartInfo);
				}
			}
			return list;
		}
		
		public List<ChartInfo> getSpFeeBySpId(ChartInfoParam  chartPara){
			StringBuilder sql = new StringBuilder();
			//sql.append("select SPARE_PART_ID,info.SPARE_PART_NAME,CREATE_MONTH,date_part('month', CREATE_MONTH) month,sum(totalFee) from  ");
			sql.append("select trans.SPARE_PART_ID,SPARE_PART_NAME,CREATE_MONTH,date_part('month', CREATE_MONTH) as month , sum(amount * trans.price) totalFe ");
			sql.append(" from pmms.spare_part_trans_info trans ,pmms.spare_part_info info ");
			sql.append(" where  trans.SPARE_PART_ID=info.SPARE_PART_ID and trans.SPARE_PART_ID=:spId and TRANS_TYPE='2' and date_part('year', CREATE_MONTH)=:currYear ");
			
			if(!Tools.isEmpty(chartPara.getMonth())){
				sql.append(" and date_part('month', CREATE_MONTH)=:p_month ");
			}
			
			sql.append(" group by trans.SPARE_PART_ID,SPARE_PART_NAME,CREATE_MONTH ");
			Query query = getSession().createSQLQuery(sql.toString());
			query.setParameter("spId", chartPara.getSparePartId());
			//Calendar a=Calendar.getInstance();
			query.setParameter("currYear", Double.parseDouble(chartPara.getYear()));
			
			if(!Tools.isEmpty(chartPara.getMonth())){
				query.setParameter("p_month", Double.parseDouble(chartPara.getMonth()));
			}
			
			List<?> rsList = query.list();
			List<ChartInfo> list = new ArrayList<ChartInfo>();
			ChartInfo chartInfo;
			if(!CollectionUtils.isEmpty(rsList)){
				Iterator<?> ite = rsList.iterator();
				while(ite.hasNext()){
					Object[] obj = (Object[])ite.next();
					chartInfo = new ChartInfo();
					chartInfo.setSparePartId(String.valueOf(obj[0]));
					chartInfo.setSparePartName(String.valueOf(obj[1]));
					chartInfo.setCount(Tools.isNull(obj[4])?0.0:Double.parseDouble(String.valueOf(obj[4])));
					chartInfo.setMaintMonth(String.valueOf(obj[3]));
					list.add(chartInfo);
				}
			}
			return list;
		}
		
		public List<ChartInfo> getSpFeeByDept(ChartInfoParam  chartPara){   
			StringBuilder sql = new StringBuilder();
			sql.append("select  date_part('month', CREATE_MONTH) as month,d.DEPT_ID,d.dept_name,sum(amount*price) toFee  ");
			//sql.append("(select  a.SPARE_PART_ID ,a.CREATE_MONTH,date_part('month', CREATE_MONTH) as month,d.DEPT_ID,d.dept_name,a.amount,a.price,sum(amount*price) toFee ");
			sql.append(" from pmms.spare_part_trans_info a,pmms.wo_info b,pmms.equip_info c,pmms.dept_info d ");
			sql.append(" where a.TRANS_TYPE='2' and a.WO_ID=b.WO_ID and b.EQUIP_ID=c.EQUIP_ID and c.DEPT_ID=d.DEPT_ID and date_part('year', CREATE_MONTH)=:currYear ");
			
			if(!Tools.isEmpty(chartPara.getMonth())){
				sql.append(" and date_part('month', CREATE_MONTH)=:p_month");
			}
			
			sql.append(" group by d.DEPT_ID,d.dept_name,CREATE_MONTH ");
			Query query = getSession().createSQLQuery(sql.toString());
			//Calendar a=Calendar.getInstance();
			query.setParameter("currYear", Double.parseDouble(chartPara.getYear()));
			
			if(!Tools.isEmpty(chartPara.getMonth())){
				query.setParameter("p_month", Double.parseDouble(chartPara.getMonth()));
			}
			List<?> rsList = query.list();
			List<ChartInfo> list = new ArrayList<ChartInfo>();
			ChartInfo chartInfo;
			if(!CollectionUtils.isEmpty(rsList)){
				Iterator<?> ite = rsList.iterator();
				while(ite.hasNext()){
					Object[] obj = (Object[])ite.next();
					chartInfo = new ChartInfo();
					chartInfo.setMaintMonth(String.valueOf(((Double)obj[0]).intValue()));
					chartInfo.setDeptId(String.valueOf(obj[1]));
					chartInfo.setDeptNm(String.valueOf(obj[2]));
					chartInfo.setCount(Tools.isNull(obj[3])?0.0:Double.parseDouble(String.valueOf(obj[3])));
					list.add(chartInfo);
				}
			}
			return list;
		}
		
		public List<ChartInfo> getTotalSpFeeForMonth(ChartInfoParam  chartPara){
			StringBuilder sql = new StringBuilder();
			sql.append("select date_part('month', CREATE_MONTH) as month, sum(amount*price) totalFee ");
			//.append("(select  a.SPARE_PART_ID ,a.CREATE_MONTH,DATEPART(month, CREATE_MONTH) month,d.DEPT_ID,d.dept_name,a.amount,a.price,amount*price toFee ");
			sql.append(" from pmms.spare_part_trans_info a,pmms.wo_info b,pmms.equip_info c,pmms.dept_info d  ");
			sql.append(" where a.TRANS_TYPE='2' and a.WO_ID=b.WO_ID and b.EQUIP_ID=c.EQUIP_ID and c.DEPT_ID=d.DEPT_ID and date_part('year', CREATE_MONTH)=:year ");
			
			if(!Tools.isEmpty(chartPara.getMonth())){
				sql.append(" and date_part('month', CREATE_MONTH)=:p_month");
			}
			
			
			sql.append(" group by d.DEPT_ID,d.dept_name,CREATE_MONTH ");
			Query query = getSession().createSQLQuery(sql.toString());
			//Calendar a=Calendar.getInstance();
			query.setParameter("year", Double.parseDouble(chartPara.getYear())); 
			
			if(!Tools.isEmpty(chartPara.getMonth())){
				query.setParameter("p_month", Double.parseDouble(chartPara.getMonth()));
			}
			
			List<?> rsList = query.list();
			List<ChartInfo> list = new ArrayList<ChartInfo>();
			ChartInfo chartInfo;
			if(!CollectionUtils.isEmpty(rsList)){
				Iterator<?> ite = rsList.iterator();
				while(ite.hasNext()){
					Object[] obj = (Object[])ite.next();
					chartInfo = new ChartInfo();
					chartInfo.setMaintMonth(String.valueOf(((Double)obj[0]).intValue()));
					chartInfo.setCount(Tools.isNull(obj[1])?0.0:Double.parseDouble(String.valueOf(obj[1])));
					chartInfo.setDeptNm(Constants.DEPT_AVG_NM);
					list.add(chartInfo);
				}
			}
			return list;
		}
		
		public List<ChartInfo> getSpFeeByYear(){
			StringBuilder sql = new StringBuilder();
			sql.append("select date_part('year', CREATE_MONTH) as year,d.DEPT_ID,d.dept_name,sum(a.amount*a.price) totalFee ");
			//sql.append("(select DATEPART(year, CREATE_MONTH) year,DATEPART(month, CREATE_MONTH) month,d.DEPT_ID,d.dept_name,a.amount,a.price,a.amount*a.price fee ");
			sql.append("from pmms.spare_part_trans_info a,pmms.wo_info b,pmms.equip_info c,pmms.dept_info d  ");
			sql.append("where a.TRANS_TYPE='2' and a.WO_ID=b.WO_ID and b.EQUIP_ID=c.EQUIP_ID and c.DEPT_ID=d.DEPT_ID ");
			sql.append("group by d.DEPT_ID,d.dept_name,year  ");
			Query query = getSession().createSQLQuery(sql.toString());
			List<?> rsList = query.list();
			List<ChartInfo> list = new ArrayList<ChartInfo>();
			ChartInfo chartInfo;
			if(!CollectionUtils.isEmpty(rsList)){
				Iterator<?> ite = rsList.iterator();
				while(ite.hasNext()){
					Object[] obj = (Object[])ite.next();
					chartInfo = new ChartInfo();
					chartInfo.setMaintMonth(String.valueOf(((Double)obj[0]).intValue()));
					chartInfo.setDeptId(String.valueOf(obj[1]));
					chartInfo.setDeptNm(String.valueOf(obj[2]));
					chartInfo.setCount(Tools.isNull(obj[3])?0.0:Double.parseDouble(String.valueOf(obj[3])));
					list.add(chartInfo);
				}
			}
			return list;
		}
		
		public List<ChartInfo> getTotalSpFeeForYear(){
			StringBuilder sql = new StringBuilder();
			sql.append("select date_part('year', CREATE_MONTH) as year,sum(a.amount*a.price) totalFee ");
			//sql.append("(select DATEPART(year, CREATE_MONTH) year,DATEPART(month, CREATE_MONTH) month,d.DEPT_ID,d.dept_name,a.amount,a.price,a.amount*a.price fee ");
			sql.append(" from pmms.spare_part_trans_info a,pmms.wo_info b,pmms.equip_info c,pmms.dept_info d    ");
			sql.append(" where a.TRANS_TYPE='2' and a.WO_ID=b.WO_ID and b.EQUIP_ID=c.EQUIP_ID and c.DEPT_ID=d.DEPT_ID  ");
			sql.append(" group by year ");
			Query query = getSession().createSQLQuery(sql.toString());
			List<?> rsList = query.list();
			List<ChartInfo> list = new ArrayList<ChartInfo>();
			ChartInfo chartInfo;
			if(!CollectionUtils.isEmpty(rsList)){
				Iterator<?> ite = rsList.iterator();
				while(ite.hasNext()){
					Object[] obj = (Object[])ite.next();
					chartInfo = new ChartInfo();
					chartInfo.setMaintMonth(String.valueOf(((Double)obj[0]).intValue()));
					chartInfo.setDeptNm(Constants.DEPT_AVG_NM);
					chartInfo.setCount(Tools.isNull(obj[1])?0.0:Double.parseDouble(String.valueOf(obj[1])));
					list.add(chartInfo);
				}
			}
			return list;
		}
		
		public Map<String,String> getEquipCntByDept(){
			StringBuilder sql = new StringBuilder();
			sql.append("select d.dept_name,count(*) cnt ");
			sql.append("from pmms.equip_info c,pmms.dept_info d  ");
			sql.append("where c.DEPT_ID=d.DEPT_ID ");
			sql.append("group by d.dept_name ");
			Query query = getSession().createSQLQuery(sql.toString());
			List<?> rsList = query.list();
			
			Map<String,String> map = new HashMap<String, String>();
			if(!CollectionUtils.isEmpty(rsList)){
				Iterator<?> ite = rsList.iterator();
				while(ite.hasNext()){
					Object[] obj = (Object[])ite.next();
					map.put(String.valueOf(obj[0]), String.valueOf(obj[1]));
				}
			}
			return map;
		}
		
		
		
		public Map<String,List<Map<String,String>>> getlstWorkorder(ChartInfoParam param){
			StringBuilder sql = new StringBuilder();
			sql.append("select d.DEPT_ID,d.dept_name,b.equip_id ,a.maint_start_date,a.maint_end_date,b.shutdown_flag,a.created_date ");
			sql.append("from pmms.wo_maint_info a,pmms.wo_info b,pmms.equip_info c,pmms.dept_info d  ");
			sql.append("where a.WO_ID=b.WO_ID and b.EQUIP_ID=c.EQUIP_ID and c.DEPT_ID=d.DEPT_ID and a.maint_end_date is not null");
			if(!StringUtils.isEmpty(param.getEquipId())){
				sql.append(" and b.equip_id=:equipId");
			}
			
			if(!StringUtils.isEmpty(param.getStartDate()) && !StringUtils.isEmpty(param.getEndDate())){
				sql.append(" and a.maint_start_date >= :startDt  and a.maint_start_date <= :endDt ");
			}
			sql.append(" order by d.DEPT_ID,b.equip_id ,a.maint_start_date ");
			Map<String,List<Map<String,String>>> map = new HashMap<String, List<Map<String,String>>>();
			Map<String,List<Map<String,String>>> retMap = new LinkedHashMap<String, List<Map<String,String>>>();
			
			try{
				Query query = getSession().createSQLQuery(sql.toString());
				if(!StringUtils.isEmpty(param.getEquipId())){
					query.setParameter("equipId", param.getEquipId());
				}
				
				if(!StringUtils.isEmpty(param.getStartDate()) && !StringUtils.isEmpty(param.getEndDate())){
					
					try {
						query.setParameter("startDt", Tools.parseToDate(param.getStartDate(), Constants.DATE_PATTEN));
						query.setParameter("endDt", Tools.parseToDate(param.getEndDate(), Constants.DATE_PATTEN));
					} catch (ParseException e) {
						LOGGER.error("faied to parse date!", e);
						throw new PmmsException(e,"faied to parse date!");
					}
					
				}
				
				//query.setParameter("spId", spId); 
				List<?> rsList = query.list();
				if(!CollectionUtils.isEmpty(rsList)){
					Iterator<?> ite = rsList.iterator();
					Map<String,String> row = null;
					String deptId = "";
					String deptName = "";
					List<Map<String,String>> list = null;
					while(ite.hasNext()){
						Object[] obj = (Object[])ite.next();
						deptId = String.valueOf(obj[0]);
						deptName = String.valueOf(obj[1]);
						row = new HashMap<String,String>();			
						row.put("DEPT_ID", deptId);
						row.put("dept_name", deptName);
						row.put("equip_id", String.valueOf(obj[2]));
						row.put("maint_start_date", String.valueOf(obj[3]));
						row.put("maint_end_date", String.valueOf(obj[4]));
						row.put("shutdown_flag", String.valueOf(obj[5]));
						row.put("created_date", String.valueOf(obj[6]));
						if(map.containsKey(deptName)){
							list = map.get(deptName);
							list.add(row);
						}else{
							list = new ArrayList<Map<String,String>>();
							map.put(deptName, list);
							list.add(row);
						}
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			
			//System.out.println("map 1 :"+map);
			if(Tools.isEmpty(param.getEquipId())){
			  List<String> deptList = getDeptNames();
		    if(!CollectionUtils.isEmpty(deptList)){
		      Iterator<String> itor = deptList.iterator();
		      while (itor.hasNext()){
		        String deptName = itor.next();
		        if(map.containsKey(deptName)){
		          retMap.put(deptName, map.get(deptName));
		        }else{
		          retMap.put(deptName, null);
		        }
		      }
		    }
		    
			}else{
			  String deptName = getDeptNmByEqId(param.getEquipId());
				if(CollectionUtils.isEmpty(map)){
					if(!StringUtils.isEmpty(deptName)){
					  retMap.put(deptName, null);
					}
				}else{
				  retMap.put(deptName, map.get(deptName));
				}
			}
			//System.out.println("map 2 :"+map);
			
			
			
			return retMap;
		}
		
		public List<String> getDeptNames(){
			List<String> deptList = null;
			String sql = "select DEPT_NAME from pmms.dept_info";
			SQLQuery query = getSession().createSQLQuery(sql);
			List<?> list = query.list();
			deptList = (List<String>) list;
			return deptList;
		}
		
		
		public String getDeptNmByEqId(String equipId){
			String sql = "select DEPT_NAME from pmms.dept_info a,pmms.equip_info b where a.dept_id = b.dept_id and  equip_id=:equipId order by a.dept_id";
			SQLQuery query = getSession().createSQLQuery(sql);
			query.setParameter("equipId", equipId);
			List<?> list = query.list();
			if(!CollectionUtils.isEmpty(list)){
				return list.get(0).toString();
			}else{
				return "";
			}
			
		}
		
		
		
	public List<ChartInfo> findINSWOs(ChartInfoParam param)
			throws PmmsException {
		StringBuilder hql = new StringBuilder();

		hql.append("select equip.dept_id,dept.dept_name,wo.planned_start_dt,count(*) ");
		hql.append(" from pmms.equip_info equip,pmms.ins_maint_check wo,pmms.dept_info dept ");
		hql.append("where  equip.equip_id=wo.equip_id and dept.dept_id=equip.dept_id and ");
		hql.append(" wo.maint_id is not null and ");
		hql.append(" wo.planned_start_dt >= :fromYear and wo.planned_start_dt <= :toYear ");

		if (!StringUtils.isEmpty(param.getWo_status())) {
			hql.append(" and wo.check_status=:woStatus ");
		}
		hql.append(" group by equip.dept_id, dept.dept_name,wo.planned_start_dt ");
		hql.append(" order by equip.dept_id ");
		Query query = getSession().createSQLQuery(hql.toString());
		try {
			query.setParameter("fromYear", Tools.parseToDate(param.getStartDate(), Constants.DATE_PATTEN));
			query.setParameter("toYear", Tools.parseToDate(param.getEndDate(),Constants.DATE_PATTEN));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (!StringUtils.isEmpty(param.getWo_status())) {
			query.setParameter("woStatus", param.getWo_status());
		}

		List<?> listResult = query.list();

		List<ChartInfo> list = new ArrayList<ChartInfo>();
		ChartInfo chartInfo;
		if (!CollectionUtils.isEmpty(listResult)) {
			Iterator<?> ite = listResult.iterator();
			while (ite.hasNext()) {
				Object[] obj = (Object[]) ite.next();
				chartInfo = new ChartInfo();
				chartInfo.setDeptId(obj[0].toString());
				chartInfo.setDeptNm(obj[1].toString());
				chartInfo.setMaintMonth(String.valueOf(((Date) obj[2])
						.getMonth() + 1));
				chartInfo.setCount(Tools.isNull(obj[3]) ? 0.0 : Double
						.parseDouble(String.valueOf(obj[3])));
				list.add(chartInfo);
			}
		}
		return list;
	}

	// 按年分组，查询五大部门的计划工单数量。
	public List<ChartInfo> findINSWONumberByYear(ChartInfoParam param) throws PmmsException {
		StringBuilder hql = new StringBuilder();
		hql.append("select equip.dept_id,dept.dept_name ,date_part('year',wo.planned_start_dt) planYear,count(*) num ");
		hql.append(" from pmms.equip_info equip,pmms.ins_maint_check wo,pmms.dept_info dept");
		hql.append(" where  equip.equip_id=wo.equip_id and dept.dept_id=equip.dept_id and ");
		hql.append(" wo.maint_id is not null and ");
		hql.append(" wo.planned_start_dt >= :fromYear and wo.planned_start_dt <= :toYear ");

		if (!StringUtils.isEmpty(param.getWo_status())) {
			hql.append(" and wo.check_status=:woStatus ");
		}
		hql.append(" group by equip.dept_id, dept.dept_name,date_part('year',wo.planned_start_dt) ");
		hql.append(" order by equip.dept_id  ");
		Query query = getSession().createSQLQuery(hql.toString());

		try {
			query.setParameter("fromYear", Tools.parseToDate(param.getStartDate(), Constants.DATE_PATTEN));
			query.setParameter("toYear", Tools.parseToDate(param.getEndDate(),Constants.DATE_PATTEN));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (!StringUtils.isEmpty(param.getWo_status())) {
			query.setParameter("woStatus", param.getWo_status());
		}
		List<?> listResult = query.list();

		List<ChartInfo> list = new ArrayList<ChartInfo>();
		ChartInfo chartInfo;
		if (!CollectionUtils.isEmpty(listResult)) {
			Iterator<?> ite = listResult.iterator();
			while (ite.hasNext()) {
				Object[] obj = (Object[]) ite.next();
				chartInfo = new ChartInfo();
				chartInfo.setDeptId(obj[0].toString());
				chartInfo.setDeptNm(obj[1].toString());
				chartInfo.setMaintMonth(String.valueOf(((Double) obj[2]).intValue()));
				chartInfo.setCount(Tools.isNull(obj[3]) ? 0.0 : Double.parseDouble(String.valueOf(obj[3])));
				list.add(chartInfo);
			}
		}
		return list;
	}

	// 根据设备编号、年份和计划工单完成状态，查询单个设备的年度计划工单数量。
	public List<ChartInfo> findSingleINSWO(ChartInfoParam param) throws PmmsException {
		StringBuilder hql = new StringBuilder();
		hql.append("select count(wo.planned_start_dt) num,date_part('month',wo.planned_start_dt) maintMonth from pmms.ins_maint_check wo");
		hql.append(" where wo.maint_id is not null and ");
		hql.append(" wo.planned_start_dt >= :fromYear and wo.planned_start_dt <= :toYear and ");
		hql.append(" wo.equip_id=:equipId ");

		if (!StringUtils.isEmpty(param.getWo_status())) {
			hql.append(" and wo.check_status=:woStatus ");
		}
		hql.append(" group by wo.planned_start_dt ");
		Query query = getSession().createSQLQuery(hql.toString());
		query.setParameter("equipId", param.getEquipId());

		try {
			query.setParameter("fromYear", Tools.parseToDate(param.getStartDate(), Constants.DATE_PATTEN));
			query.setParameter("toYear", Tools.parseToDate(param.getEndDate(),Constants.DATE_PATTEN));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (!StringUtils.isEmpty(param.getWo_status())) {
			query.setParameter("woStatus", param.getWo_status());
		}

		List<?> listResult = query.list();

		List<ChartInfo> list = new ArrayList<ChartInfo>();
		ChartInfo chartInfo;
		if (!CollectionUtils.isEmpty(listResult)) {
			Iterator<?> ite = listResult.iterator();
			while (ite.hasNext()) {
				Object[] obj = (Object[]) ite.next();
				chartInfo = new ChartInfo();
				chartInfo.setCount(Tools.isNull(obj[0]) ? 0.0 : Double.parseDouble(String.valueOf(obj[0])));
				chartInfo.setMaintMonth(String.valueOf(((Double) obj[1]).intValue()));
				list.add(chartInfo);
			}
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<sparePart> getSparePartDetails() {
		Criteria c = super.getSession().createCriteria(sparePart.class, "spare_part_info");
		List<sparePart> ls = c.list();
		return ls;
		}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EquipInfoMin> getEquipInfoDetails() {
		Criteria c = super.getSession().createCriteria(EquipInfoMin.class, "EQUIP_INFO");
		List<EquipInfoMin> ls = c.list();
		return ls;
		}
}
