package com.ge.pmms.dao.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.ge.pmms.Constants;
import com.ge.pmms.Tools;
import com.ge.pmms.dao.BasicDao;
import com.ge.pmms.dao.sparePartDao;
import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.entity.FaultReport;
import com.ge.pmms.entity.LookupMst;
import com.ge.pmms.entity.SafetyStockInfo;
import com.ge.pmms.entity.SpareTransInfo;
import com.ge.pmms.entity.sparePart;
@Repository

public class sparePartDaoImpl extends BasicDao implements sparePartDao {
	
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(sparePartDaoImpl.class);
	
	/**********************************displaying data for safety stock tab***********************************/
	
	@SuppressWarnings("unchecked")
	@Override
	public List<sparePart> getSpareParts( String sparePartCategory) {
		
		
		Date currentDate = Tools.getToday();
		Date lastDate = Tools.getLastDate(currentDate);
		Date lastTwoYrDate = Tools.getLastTwoYrDate(lastDate);
		List<SafetyStockInfo> stdList = getSTDPreparedData(lastTwoYrDate,lastDate);
		Map<String, Double> stdMap = calculateSTD(stdList);
		Map<String, Double> lMap = getLeadTime(lastTwoYrDate, lastDate);
		List<String> spIdList = getSPIds();
		//Calculating safety stock
		List<SafetyStockInfo> ssList = calculateSafetyStock(spIdList,stdMap, lMap);
		updateSS(ssList);
		List<sparePart> ls = null;
		for(SafetyStockInfo ssInfo : ssList){
			Criteria c = super.getSession().createCriteria(sparePart.class, "sparePart");
			c.add(Restrictions.ne("sparePart.sparePartNo", ssInfo.getDeviceId()));
			c.add(Restrictions.ne("sparePart.sparePartCategory", sparePartCategory));
			ls= c.list();
			
		}
		
		return ls;
		}
	
	
	/*********************************delete functionality*********************************/
	
	@Override
	public String removeSparePart(String deleteId) {
		// TODO Auto-generated method stub
		Session session=this.getSession();
		String[] ids = deleteId.split(",");
		for(String id : ids){
			sparePart spare = (sparePart) session.load(sparePart.class, new Integer(id));
			if(null != spare){
				session.delete(spare);
			}
		}	
		return "SUCCESS";
	}
	
	/********************************Add functionality******************************************/

	@Override
	public void addSparePart(sparePart spare) {
		super.getSession().saveOrUpdate(spare);
		
	}
	
	/*********************************************kj*************************************************/

	@SuppressWarnings("unchecked")
	@Override
	public List<sparePart> getSearchedData() {
		
		return super.getSession().createCriteria(sparePart.class).list();
	}
	
	/*********************************************for safety stock******************************************/

	@Override
	public List<sparePart> getSafetyStock() {
		@SuppressWarnings("unused")
		sparePart spare= new sparePart();
	
		
		return null;
	}

	/************************************search for spare part not used (EQ & FAC)**********************************/
	
	@Override
	public List<sparePart> searchSparePartWithDates(String data) {
		JSONObject dateData = new JSONObject(data);
		String fromDateStr = dateData.getString("fromDate");
		String toDateStr = dateData.getString("toDate");
		Date fromDate = new Date();
		Date toDate = new Date();
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			fromDate = df.parse(fromDateStr);
			toDate = df.parse(toDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		@SuppressWarnings("unchecked")
		List<sparePart> sapre = (List<sparePart>)super.getSession().createCriteria(sparePart.class)
				.add(Restrictions.between("createdDate", fromDate,toDate)).list();
		return sapre;
	}
	
	/*****************************************search for equipment spare part stock (1st tab)*************************************************/
	
	@SuppressWarnings("unchecked")
	@Override
	public List<sparePart> searchWithParameters(String data) {
		
		JSONObject spareData = new JSONObject(data);
		
		String spareName= spareData.getString("name");
		String manufacturerName = spareData.getString("source");
		String model=String.valueOf(spareData.getInt("sparePartNo"));
		//Integer model = spareData.getInt("sparePartNo");
		
		Criteria c= super.getSession().createCriteria(sparePart.class);
		c.add(Restrictions.eq("name", spareName));
		c.add(Restrictions.eq("source", manufacturerName));
		c.add(Restrictions.eq("sparePartNo",model ));
		
		List<sparePart> spare=c.list();	
		return spare;
	}

	/*****************************************************drpdown search*****************************************************************/
	
	@SuppressWarnings("unchecked")
	@Override
	public List<sparePart> searchWithDropdown(String dropdownData) {
		
		JSONObject facilityDropdownData = new JSONObject(dropdownData);
		
			String facilityName= facilityDropdownData.getString("dropdown");
			
			Criteria c= super.getSession().createCriteria(LookupMst.class);
			c.add(Restrictions.eq("dropdown", facilityName));
			
			List<sparePart> spare=c.list();	
		return spare;
	}
	
	/*****************************************************search for 3rd tab transaction storage(EQ & FAC)*****************************************************************/
	
	@SuppressWarnings("unchecked")
	@Override
	public List<sparePart> searchWithDatesAndFields(String facilityData) {
		
		
		JSONObject dateData = new JSONObject(facilityData);
		String fromDateStr = dateData.getString("fromDate");
		String toDateStr = dateData.getString("toDate");
		String model=String.valueOf(dateData.getInt("modelNo"));
		String createdSSo=String.valueOf(dateData.getInt("sso"));
		String library= dateData.getString("library");
				
		Date fromDate = new Date();
		Date toDate = new Date();
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			fromDate = df.parse(fromDateStr);
			toDate = df.parse(toDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
 
		Criteria c= super.getSession().createCriteria(sparePart.class, "sparePart");
		
				c.add(Restrictions.between("sparePart.createdDate", fromDate,toDate)).list();
				c.add(Restrictions.eq("sparePart.sparePartNo", model));
				c.add(Restrictions.eq("sparePart.createdBy", createdSSo));
				c.add(Restrictions.eq("sparePart.suggestedLibrary", library));
				
				
  			List<sparePart> spare=c.list();	
				
		return spare;
	}

	/*******************************************************search for equipment view tab*****************************************************************************/
	
	@SuppressWarnings("unchecked")
	@Override
	public List<sparePart> equipmentSearch(String equipmentData) {
		
		JSONObject equipData = new JSONObject(equipmentData);
		
		String model=String.valueOf(equipData.getInt("modelNo"));
		String equimnentName= equipData.getString("equipmentName");
		String equipManufacturer= equipData.getString("equipManufacturer");
		
		Criteria c= super.getSession().createCriteria(sparePart.class, "sparePart");
		c.add(Restrictions.eq("sparePart.sparePartNo", model));
		c.add(Restrictions.eq("sparePart.name", equimnentName));
		c.add(Restrictions.eq("sparePart.source", equipManufacturer));

		List<sparePart> spare=c.list();			
		return spare;
	}

	/*******************************************************search for facility view tab*****************************************************************************/
	
	@SuppressWarnings("unchecked")
	@Override
	public List<sparePart> facilitySearch(String facData) {
		JSONObject facilityData = new JSONObject(facData);
		
		String model=String.valueOf(facilityData.getInt("modelNo"));
		String facilityType= facilityData.getString("facilityType");
		
		Criteria c= super.getSession().createCriteria(sparePart.class, "sparePart");
		c.add(Restrictions.eq("sparePart.sparePartNo", model));
		c.add(Restrictions.eq("sparePart.type", facilityType));
		List<sparePart> spare=c.list();	
		//System.out.println("c---->" + spare);
		return spare;
	}
	
	/*******************************************************calculating tha safety stock*****************************************************************************/
	
	public List<SafetyStockInfo> getSTDPreparedData(Date startDate, Date endDate)
		 {
		
		String strStartDate = Tools.formatDate(startDate);
		String strEndDate = Tools.formatDate(endDate);
		List<SafetyStockInfo> sslist = null;
		
		
		String hql ="select amont_id,count(amont_id),sum((monthAmount-avgAmount) * (monthAmount-avgAmount)) sums,"
				+ " avgAmount from (select SPARE_PART_ID amont_id,sum(amount) monthAmount from pmms.SPARE_PART_TRANS_INFO"
				+ " where trans_type='2' and CAST(created_dt AS date) between '"+ strStartDate +"' and '"+ strEndDate+"'"
				+ " group by SPARE_PART_ID)a,(select SPARE_PART_ID total_id,sum(amount)/24.0 avgAmount  from pmms.SPARE_PART_TRANS_INFO "
				+ "where trans_type='2' and CAST(created_dt AS date) between '"+ strStartDate +"' and '"+ strEndDate+"'"
				+ " group by SPARE_PART_ID) b where a.amont_id = b.total_id group by amont_id,avgAmount order by amont_id";
		
		SQLQuery query = super.getSession().createSQLQuery(hql);
		
		List<?> list = query.list();
		if(!CollectionUtils.isEmpty(list)){
			sslist = new ArrayList<SafetyStockInfo>();
			SafetyStockInfo ssInfo = null;
			String sparePartId = "";
			Iterator<?> ite = list.iterator();
			while(ite.hasNext()){
				Object[] obj = (Object[]) ite.next();
				ssInfo = new SafetyStockInfo();
				sparePartId = Tools.isNull(obj[0], "");
				ssInfo.setDeviceId(sparePartId);
				ssInfo.setNum(Integer.parseInt(obj[1].toString()));
				ssInfo.setSums(Double.parseDouble(obj[2].toString()));
				ssInfo.setAvgAmount(Double.parseDouble(obj[3].toString()));
				sslist.add(ssInfo);
			}
		}
		return sslist;
	}
	
	/**************************************************calculation of standard variance for tab 2 of equipment and facility********************************************/
	
	public  Map<String, Double> calculateSTD(List<SafetyStockInfo> list){
		Map<String, Double> stdMap = new HashMap<String, Double>();       //k is the number of spare parts, v is the corresponding STD
		if(!CollectionUtils.isEmpty(list)){
			SafetyStockInfo ssInfo = null;
			String sparePartId = "";
			int num = 0;
			double sums = 0;
			double avgAmount = 0;
			Double STD = null;
			Iterator<SafetyStockInfo> itor = list.iterator();
			while(itor.hasNext()){
				ssInfo = itor.next();
				sparePartId = ssInfo.getDeviceId();
				num = ssInfo.getNum();
				sums = ssInfo.getSums();
				avgAmount = ssInfo.getAvgAmount();
				for(int i=0;i<24-num;i++){
					sums += avgAmount*avgAmount;
				}
				STD = Math.sqrt(sums/24);
				stdMap.put(sparePartId, STD);
			}
		}
		return stdMap;
	}
	
	/***************************************************calculation of lead time*********************************************************************/
	
	public Map<String, Double> getLeadTime(Date startDate, Date endDate) {
		String strStartDate = Tools.formatDate(startDate);
		String strEndDate = Tools.formatDate(endDate);
		Map<String, Double> map = new HashMap<String, Double>();;
		String hql="select spare_part_id,avg(LEAD_TIME) avgLeadTime from pmms.SPARE_PART_TRANS_INFO"
				+ " where CAST(created_dt AS date) between '"+strStartDate+"' and  '"+strEndDate+"' and trans_type='1' group by SPARE_PART_ID";
		
		SQLQuery query = super.getSession().createSQLQuery(hql);
		List<?> list = query.list();
		
		if(!CollectionUtils.isEmpty(list)){
			Iterator<?> itor = list.iterator();
			while(itor.hasNext()){
				Object[] obj = (Object[]) itor.next(); 
				map.put(obj[0].toString(), Double.parseDouble(obj[1].toString()));
			}
		}		
		return map;
	}
	
	/********************************************************method of gettion spare part ID*************************************************************************/
	
	public List<String> getSPIds() {
		List<String> spIdlist = new ArrayList<String>();
		String hql = "select SPARE_PART_ID from pmms.SPARE_PART_INFO";
		SQLQuery query = super.getSession().createSQLQuery(hql);
		List<?> list = query.list();
		if(!CollectionUtils.isEmpty(list)){
			Iterator<?> itor = list.iterator();
			Object obj = null;
			while(itor.hasNext()){
				obj = itor.next();
				spIdlist.add(obj.toString());
			}
		}
		return spIdlist;
	}
	
	/******************************************************calculation of safety stock with params******************************************************/
	
	public List<SafetyStockInfo> calculateSafetyStock(List<String> spIdList, Map<String, Double> stdMap,Map<String, Double> lMap){
		List<SafetyStockInfo> sslist = new ArrayList<SafetyStockInfo>();
		if(!CollectionUtils.isEmpty(spIdList)){
			String key = "";
			Double STD = null;
			Double L = null;
			Double safetyStock = 0.0;
			SafetyStockInfo ssInfo = null;
			for(String string : spIdList){
				key = string;
				if(!CollectionUtils.isEmpty(stdMap)){
					STD = stdMap.get(key);	
				}
				if(!CollectionUtils.isEmpty(lMap)){
					L = lMap.get(key);
				}
				if(Tools.isNull(STD)&&Tools.isNull(L)){
						continue;
						}else if(!Tools.isNull(STD)&&!Tools.isNull(L)){
							ssInfo = new SafetyStockInfo();
							safetyStock = Constants.Z*Math.sqrt(L)*STD;
							ssInfo.setDeviceId(key);
							ssInfo.setSafetyStock(safetyStock);
							sslist.add(ssInfo);	
						}else if(!Tools.isNull(STD)&&Tools.isNull(L)){
							L = 1.0;  //默认值
							ssInfo = new SafetyStockInfo();
							safetyStock = Constants.Z*Math.sqrt(L)*STD;
							ssInfo.setDeviceId(key);
							ssInfo.setSafetyStock(safetyStock);
							sslist.add(ssInfo);	
						}else{
							STD = 1.0;  //默认值
							ssInfo = new SafetyStockInfo();
							safetyStock = Constants.Z*Math.sqrt(L)*STD;
							ssInfo.setDeviceId(key);
							ssInfo.setSafetyStock(safetyStock);
							sslist.add(ssInfo);	
						}
					}	
			}

		return sslist;	
	}
	
	/********************************************************************updation of safety stock************************************************************************/
	
	public void updateSS(List<SafetyStockInfo> ssList) {
		String sql = "";
		if(!CollectionUtils.isEmpty(ssList)){
			sql = "update pmms.SPARE_PART_INFO set SYS_SAFETY_STOCK=:safetyStock where SPARE_PART_ID=:sparePartId";
			Query query = getSession().createSQLQuery(sql);
			for(SafetyStockInfo ssInfo : ssList){
				query.setParameter("safetyStock", ssInfo.getSafetyStock());
				query.setParameter("sparePartId", ssInfo.getDeviceId());
				query.executeUpdate();
			}
		}
	}

	/********************************************************************Add of scan IN tab 3 (EQ & FAC)************************************************************************/
	
	@Override
	public void addScanIn(SpareTransInfo transInfo) {
	
		sparePart part = (sparePart) super.getSession().createCriteria(sparePart.class)
									.add(Restrictions.eq("sparePartNo", transInfo.getSparePartNo2())).uniqueResult();
		
				transInfo.setSparepart(part);
				transInfo.setTransType("I");
				transInfo.setCreatedBy("5026");
				transInfo.setUpdatedBy("2356");
				
		super.getSession().saveOrUpdate(transInfo);
		
	}
	
	/********************************************************************dropdown method for sacn out tab 3 (EQ & FAC)************************************************************************/
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DropDownEntry> getTicketType(String Type) {
		
		Criteria c = super.getSession().createCriteria(LookupMst.class, "lookupMst")
				.setProjection(Projections.projectionList()
						.add(Projections.alias(Projections.distinct(Projections.property("lookupMst.Key")), "key"))
						.add(Projections.alias(Projections.property("lookupMst.Value"), "val")))
				.setResultTransformer(Transformers.aliasToBean(DropDownEntry.class)).setCacheable(true);
		if (StringUtils.isNotEmpty(Type)) {
			c.add(Restrictions.eq("Type", Type));
		}	
		List<DropDownEntry> l = c.list();
		return l;
	}
	
	/********************************************************************fetching data from fault reoprt scan out inner popup(EQ & FAC)************************************************************************/

	@SuppressWarnings("unchecked")
	@Override
	public List<FaultReport> getWorkOrderDetails() {
		
			Criteria c = super.getSession().createCriteria(FaultReport.class, "faultReport");
		
		List<FaultReport> ls = c.list();
		//System.out.println("--------------->" + ls);
		return ls;
		}
	
	/********************************************************************search functionality for inner popup of tab-3 (FAC & EQ)************************************************************************/

	@SuppressWarnings("unchecked")
	@Override
	public List<FaultReport> searchWithDatesScanOut(String dataScanOut) 
	{
		Criteria c = super.getSession().createCriteria(FaultReport.class, "faultReport");
		c.createAlias("faultReport.equipmentInfo", "equipmentInfo");
		c.createAlias("equipmentInfo.deptInfo","deptInfo");
		JSONObject dateData = new JSONObject(dataScanOut);
		System.out.println("Data are:"+dateData.toString());
		
		
	 String fromDateStr = dateData.getString("fromDate");
		String toDateStr = dateData.getString("toDate");
		String equipType= dateData.getString("equipType");
		String deptType = dateData.getString("deptType");
		String ticketType= dateData.getString("TicketType");
		
		
		Date fromDate = new Date();
		Date toDate = new Date();
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			fromDate = df.parse(fromDateStr);
			toDate = df.parse(toDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//Criteria cri= super.getSession().createCriteria(FaultReport.class, "fault");
		
		c.add(Restrictions.between("faultReport.createdDate", fromDate,toDate)).list();
		c.add(Restrictions.eq("faultReport.workOrderType", ticketType));
		c.add(Restrictions.eq("equipmentInfo.equipType", equipType));
		
		c.add(Restrictions.eq("deptInfo.deptName", deptType));
		
		List<FaultReport> faultR=c.list();	
		
				return faultR;
		}

	/********************************************************************data fetching for equipment spare part************************************************************************/
	@SuppressWarnings("unchecked")
	@Override
	public List<sparePart> getSparePartDataEquipment() {
		Criteria c = super.getSession().createCriteria(sparePart.class, "sparePart");
		c.add(Restrictions.eq("sparePart.sparePartCategory", "EQ"));
		List<sparePart> spare=c.list();	
		
		return spare;
	}
	
	/********************************************************************data fetching for facility spare part************************************************************************/
	@SuppressWarnings("unchecked")
	@Override
	public List<sparePart> getSparePartDataFacility() {
		Criteria c = super.getSession().createCriteria(sparePart.class, "sparePart");
		c.add(Restrictions.eq("sparePart.sparePartCategory", "FAC"));
		List<sparePart> spare=c.list();	
		
		return spare;
	}

	/********************************************************************adding scan out of tab 3 (EQ & FAC)************************************************************************/
	@Override
	public void AddScanOut(SpareTransInfo info) {
		sparePart part = (sparePart) super.getSession().createCriteria(sparePart.class)
				.add(Restrictions.eq("sparePartNo", info.getSparePartNo2())).uniqueResult();
		
		
		info.setSparepart(part);
		info.setTransType("O");
		info.setCreatedBy("5026");
		info.setUpdatedBy("2356");

		super.getSession().saveOrUpdate(info);
	}
	}



