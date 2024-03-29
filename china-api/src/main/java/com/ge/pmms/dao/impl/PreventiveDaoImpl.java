/**
 * 
 */
package com.ge.pmms.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ge.pmms.Constants;
import com.ge.pmms.dao.BasicDao;
import com.ge.pmms.dao.PreventiveDao;
import com.ge.pmms.dto.PreventiveMaintainanceDTO;
import com.ge.pmms.entity.InspectionSMRecordAndTrackLoogBook;
import com.ge.pmms.entity.User;
import com.ge.pmms.entity.ViewForPCM;
import com.ge.pmms.entity.ViewForPM;
import com.ge.pmms.entity.WorkOrderInfoDtls;
import com.ge.pmms.entity.WorkOrderMaintainance;

/**
 * @author vk838142
 *
 */

@Repository
public class PreventiveDaoImpl extends BasicDao implements PreventiveDao  {

	@Override
	public List<ViewForPM> getMaintainanceDetails(String workOrderType, String deptId, String equipType) {
		// TODO Auto-generated method stub
		Criteria c = super.getSession().createCriteria(ViewForPM.class);
		if(deptId.equals("0") && equipType.equals("0"))
		{
			c.add(Restrictions.ne("woStatus",Constants.WO_CLOSE));
			List<ViewForPM> l = c.list();
			return l;
		}		
		if (StringUtils.isNotEmpty(deptId) && !deptId.equals("0")) {
			c.add(Restrictions.eq("deptId", deptId));	
		}
		if (StringUtils.isNotEmpty(equipType) && !equipType.equals("0")) {
			c.add(Restrictions.eq("equipType", equipType));
		}
		
		c.add(Restrictions.ne("woStatus",Constants.WO_CLOSE));
		List<ViewForPM> ls = c.list();
		return ls;
	}
	
	@Override
	public List<WorkOrderInfoDtls> getScheduleMaintWoDtls(String workOrderNumber) {
		// TODO Auto-generated method stub
		Criteria c = super.getSession().createCriteria(WorkOrderInfoDtls.class, "workOrderInfoDtls");
		c.createCriteria("workOrderInfoDtls.maintainaceItem", "maintainaceItem"); // inner join by default
		c.add(Restrictions.eq("workOrderInfoDtls.faultReport.workOrderNumber", workOrderNumber));
		
		List<WorkOrderInfoDtls> ls = c.list();
		
		return ls;
	}


	@Override
	public void startPreventiveMaint(PreventiveMaintainanceDTO dto) {
		// TODO Auto-generated method stub
		boolean close=false;
		updateWoInfoMaintItem(dto,close);
		
		String hql ="INSERT INTO pmms.wo_maint_info(created_by, CREATED_DATE, REMARK,wo_id,wo_status,WO_MAINT_ID,mechanic,maint_start_date )"
				+ "VALUES ('"+dto.getCreatorSSO()+"', '"+new Date()+"', '"+ dto.getRemarks()+"' , '"+dto.getWorkOrderNumber() +"'"
				+ " ,'"+ Constants.WO_IN_PROGRESS+"' , '" + 101+"', '" +dto.getCreatorSSO() +"', '"+new Date()+"' )";	
		SQLQuery query = super.getSession().createSQLQuery(hql);
		query.executeUpdate();
	}

	@Override
	public void closePreventiveMaint(PreventiveMaintainanceDTO dto) {
		// TODO Auto-generated method stub
		boolean close=true;
		String shutdownflag = "";
		updateWoInfoMaintItem(dto, close);
		
		String hql = "UPDATE pmms.wo_maint_info SET REMARK ='" + dto.getRemarks() + "'," + " wo_status = '"
				+ Constants.WO_CLOSE + "',maint_end_date = '" + new Date() + "', " + "last_updated_date = '"
				+ new Date() + "' , last_updated_by = '" + dto.getUpdaterSSO() + "' WHERE wo_id = '" + dto.getWorkOrderNumber()
				+ "'";

		SQLQuery query = super.getSession().createSQLQuery(hql);
		query.executeUpdate();
		
	}


	
	@Override
	public void StartPrevMaintainanceQM(PreventiveMaintainanceDTO dto) {
		
		/*
		Criteria c = super.getSession().createCriteria(WorkOrderMaintainance.class, "workOrderMaintainance");
		c.add(Restrictions.eq("id", dto.getIdPMTab2()));
		
		WorkOrderMaintainance workOrderMaintainance = (WorkOrderMaintainance) c.uniqueResult();
		
		workOrderMaintainance.getFaultReport().setUpdaterSSO(dto.getUpdaterSSO());
		workOrderMaintainance.getFaultReport().setShutdownFlag(dto.getShutdownFlag());
		workOrderMaintainance.getFaultReport().setWordOrderStatus(Constants.WO_IN_PROGRESS);
		workOrderMaintainance.getFaultReport().setLastUpdatedDate(new Date());
		workOrderMaintainance.setRemarks(dto.getRemarks());
		workOrderMaintainance.setLastUpdatedDates(new Date());
		workOrderMaintainance.getFaultReport().setMaintStartDate(new Date());
		
		saveOrUpdate(workOrderMaintainance.getFaultReport());
		saveOrUpdate(workOrderMaintainance);*/
		String shutdownflag ="";
		if(("".equals(dto.getShutdownFlag())) || (dto.getShutdownFlag() == null))
		{
			shutdownflag = "N";
		}else{
			shutdownflag = "Y";
		}
		
		String hqlUpdate = "UPDATE pmms.wo_info SET fault_description ='" + dto.getRemarks() + "'," + " wo_status = '"
				+ Constants.WO_IN_PROGRESS + "',shutdown_flag = '"+shutdownflag + "',maint_start_dt = '" + new Date() + "',"
				+ " last_updated_by = '" + dto.getUpdaterSSO() + "' WHERE wo_id = '" + dto.getWorkOrderNumber()+ "'";

		SQLQuery queryUpdate = super.getSession().createSQLQuery(hqlUpdate);
		queryUpdate.executeUpdate();
		
		String hql = "UPDATE pmms.wo_maint_info SET REMARK ='" + dto.getRemarks() + "'," + " wo_status = '"
					+ Constants.WO_IN_PROGRESS + "',maint_end_date = '" + new Date() + "', " + "last_updated_date = '"
					+ new Date() + "' , last_updated_by = '" + dto.getUpdaterSSO() + "' WHERE id = '" + dto.getIdPMTab2()+ "'";

			SQLQuery query = super.getSession().createSQLQuery(hql);
			int i =query.executeUpdate();
		if(i<=0)
		{
			String hqlInsert ="INSERT INTO pmms.wo_maint_info(created_by, CREATED_DATE, REMARK,wo_id,wo_status,WO_MAINT_ID,mechanic,maint_start_date )"
					+ "VALUES ('"+dto.getCreatorSSO()+"', '"+new Date()+"', '"+ dto.getRemarks()+"' , '"+dto.getWorkOrderNumber() +"'"
					+ " ,'"+ Constants.WO_IN_PROGRESS+"' , '" + 101+"', '" +dto.getCreatorSSO() +"', '"+new Date()+"' )";	
			SQLQuery queryInsert = super.getSession().createSQLQuery(hqlInsert);
			queryInsert.executeUpdate();
		}
		
		
	}

	@Override
	public void closePreventiveMaintainanceQM(PreventiveMaintainanceDTO bean) {
		/*Criteria c = super.getSession().createCriteria(WorkOrderMaintainance.class, "workOrderMaintainance");
		c.add(Restrictions.eq("id", bean.getIdPMTab2()));
		
		WorkOrderMaintainance workOrderMaintainance = (WorkOrderMaintainance) c.uniqueResult();
		
		workOrderMaintainance.getFaultReport().setUpdaterSSO(bean.getUpdaterSSO());
		workOrderMaintainance.getFaultReport().setShutdownFlag(bean.getShutdownFlag());
		workOrderMaintainance.getFaultReport().setWordOrderStatus(Constants.WO_CLOSE);
		workOrderMaintainance.getFaultReport().setLastUpdatedDate(new Date());
		workOrderMaintainance.setRemarks(bean.getRemarks());
		workOrderMaintainance.setLastUpdatedDates(new Date());
		workOrderMaintainance.getFaultReport().setMaintEndDate(new Date());
		saveOrUpdate(workOrderMaintainance.getFaultReport());
		saveOrUpdate(workOrderMaintainance);*/
		String shutdownflag ="";
		if(("".equals(bean.getShutdownFlag())) || (bean.getShutdownFlag() == null))
		{
			shutdownflag = "N";
		}else{
			shutdownflag = "Y";
		}
		
		
		String hqlUpdate = "UPDATE pmms.wo_info SET fault_description ='" + bean.getRemarks() + "'," + " wo_status = '"
				+ Constants.WO_CLOSE + "',shutdown_flag = '"+shutdownflag + "',maint_start_dt = '" + new Date() + "',"
				+ " last_updated_by = '" + bean.getUpdaterSSO() + "' WHERE wo_id = '" + bean.getWorkOrderNumber()+ "'";

		SQLQuery queryUpdate = super.getSession().createSQLQuery(hqlUpdate);
		queryUpdate.executeUpdate();
		
		
	
			String hql = "UPDATE pmms.wo_maint_info SET REMARK ='" + bean.getRemarks() + "'," + " wo_status = '"
					+ Constants.WO_CLOSE + "',maint_end_date = '" + new Date() + "', " + "last_updated_date = '"
					+ new Date() + "' , last_updated_by = '" + bean.getUpdaterSSO() + "' WHERE wo_id = '" + bean.getWorkOrderNumber()+ "'";

			SQLQuery query = super.getSession().createSQLQuery(hql);
			int i = query.executeUpdate();
		
			if(i<=0)
			{
		String hqlInsert ="INSERT INTO pmms.wo_maint_info(created_by, CREATED_DATE, REMARK,wo_id,wo_status,WO_MAINT_ID,mechanic,maint_start_date )"
				+ "VALUES ('"+bean.getCreatorSSO()+"', '"+new Date()+"', '"+ bean.getRemarks()+"' , '"+bean.getWorkOrderNumber() +"'"
				+ " ,'"+ Constants.WO_CLOSE+"' , '" + 101+"', '" +bean.getCreatorSSO() +"', '"+new Date()+"' )";	
		SQLQuery queryInsert = super.getSession().createSQLQuery(hqlInsert);
		queryInsert.executeUpdate();
			}
		
	}
	
	

	@Override
	public void pausePreventiveQM(PreventiveMaintainanceDTO preventiveMaintainaceBean) {
		// TODO Auto-generated method stub
		/*Criteria c = super.getSession().createCriteria(WorkOrderMaintainance.class, "workOrderMaintainance");
		c.createAlias("workOrderMaintainance.faultReport", "faultReport");
		c.add(Restrictions.eq("faultReport.workOrderType","EQ"));
		c.add(Restrictions.eq("id", preventiveMaintainaceBean.getIdPMTab2()));
		WorkOrderMaintainance workOrderMaintainance = (WorkOrderMaintainance) c.uniqueResult();
		
		workOrderMaintainance.getFaultReport().setUpdaterSSO(preventiveMaintainaceBean.getUpdaterSSO());
		workOrderMaintainance.getFaultReport().setShutdownFlag(preventiveMaintainaceBean.getShutdownFlag());
		workOrderMaintainance.getFaultReport().setWordOrderStatus(Constants.WO_PAUSE);
		workOrderMaintainance.getFaultReport().setLastUpdatedDate(new Date());
		workOrderMaintainance.setLastUpdatedBy(preventiveMaintainaceBean.getUpdaterSSO());
		workOrderMaintainance.setRemarks(preventiveMaintainaceBean.getRemarks());
		workOrderMaintainance.setLastUpdatedDates(new Date());
		
		saveOrUpdate(workOrderMaintainance.getFaultReport());
		saveOrUpdate(workOrderMaintainance);*/
		
		String shutdownflag ="";
		if(("".equals(preventiveMaintainaceBean.getShutdownFlag())) || (preventiveMaintainaceBean.getShutdownFlag() == null))
		{
			shutdownflag = "N";
		}else{
			shutdownflag = "Y";
		}
		
		String hqlUpdate = "UPDATE pmms.wo_info SET fault_description ='" + preventiveMaintainaceBean.getRemarks() + "'," + " wo_status = '"
				+ preventiveMaintainaceBean.getPcmStatus()+ "',shutdown_flag = '"+shutdownflag + "',maint_start_dt = '" + new Date() + "',"
				+ " last_updated_by = '" + preventiveMaintainaceBean.getUpdaterSSO() + "' WHERE wo_id = '" + preventiveMaintainaceBean.getWorkOrderNumber()+ "'";

		SQLQuery queryUpdate = super.getSession().createSQLQuery(hqlUpdate);
		queryUpdate.executeUpdate();
		
		
	
			String hql = "UPDATE pmms.wo_maint_info SET REMARK ='" + preventiveMaintainaceBean.getRemarks() + "'," + " wo_status = '"
					+ preventiveMaintainaceBean.getPcmStatus() + "',maint_end_date = '" + new Date() + "', " + "last_updated_date = '"
					+ new Date() + "' , last_updated_by = '" + preventiveMaintainaceBean.getUpdaterSSO() + "' WHERE wo_id = '" + preventiveMaintainaceBean.getWorkOrderNumber()+ "'";

			SQLQuery query = super.getSession().createSQLQuery(hql);
			int i = query.executeUpdate();
		
			if(i<=0)
			{
		String hqlInsert ="INSERT INTO pmms.wo_maint_info(created_by, CREATED_DATE, REMARK,wo_id,wo_status,WO_MAINT_ID,mechanic,maint_start_date )"
				+ "VALUES ('"+preventiveMaintainaceBean.getCreatorSSO()+"', '"+new Date()+"', '"+ preventiveMaintainaceBean.getRemarks()+"' , '"+preventiveMaintainaceBean.getWorkOrderNumber() +"'"
				+ " ,'"+ preventiveMaintainaceBean.getPcmStatus()+"' , '" + 101+"', '" +preventiveMaintainaceBean.getCreatorSSO() +"', '"+new Date()+"' )";	
		SQLQuery queryInsert = super.getSession().createSQLQuery(hqlInsert);
		queryInsert.executeUpdate();
			}
		
	}

	public static ArrayList<String> convertStringArrayToArraylist(String[] strArr){
	    ArrayList<String> stringList = new ArrayList<String>();
	    for (String s : strArr) {
	        stringList.add(s);
	    }
	    return stringList;
	} 
	
	public void updateWoInfoMaintItem(PreventiveMaintainanceDTO dto,boolean close) {
		// TODO Auto-generated method stub
		String status,shutdownflag=null;
		String UpdaterSSO= dto.getUpdaterSSO();
		String remarks=dto.getRemarks();
		String arrString = dto.getPrivString();
		String[] arr = arrString.split(",");
		ArrayList preventArray= convertStringArrayToArraylist(arr);
        List preventiveArrayList = new ArrayList<Object>();
        preventiveArrayList.add(preventArray);
        if(("".equals(dto.getShutdownFlag())) || (dto.getShutdownFlag() == null))
		{
			shutdownflag = "N";
		}else{
			shutdownflag = "Y";
		}
        if(close){
        	status=Constants.WO_CLOSE;
        }else {
        	status=Constants.WO_IN_PROGRESS;
        }
        
        for(int i=0;i<preventiveArrayList.size();i++)
		{
        	Criteria criteria = super.getSession().createCriteria(WorkOrderInfoDtls.class, "workOrderInfoDtls");
        	criteria.add(Restrictions.eq("id", Integer.parseInt((String) ((List) preventiveArrayList.get(i)).get(2))));
        	WorkOrderInfoDtls infoDtls =  (WorkOrderInfoDtls) criteria.uniqueResult();
			String scanValue = (String) ((List) preventiveArrayList.get(i)).get(0);
			String spendTime = (String) ((List) preventiveArrayList.get(i)).get(1);
			
			infoDtls.getMaintainaceItem().setLastUpdatedDt(new Date());
			infoDtls.getMaintainaceItem().setLastUpdatedBy(UpdaterSSO);
			infoDtls.getMaintainaceItem().setRemark(remarks);
			infoDtls.getFaultReport().setUpdaterSSO(dto.getUpdaterSSO());
			infoDtls.getFaultReport().setShutdownFlag(shutdownflag);
			infoDtls.getFaultReport().setWordOrderStatus(status);
			infoDtls.getFaultReport().setLastUpdatedDate(new Date());
			infoDtls.getFaultReport().setMaintStartDate(new Date());
			infoDtls.setScanValue(scanValue);
			infoDtls.setSpendTime(spendTime);
			infoDtls.setCheckDate(new Date());
			infoDtls.setLastUpdatedDt(new Date());
			infoDtls.setLastUpdatedBy(UpdaterSSO);
			saveOrUpdate(infoDtls);
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String validateDailyWorkOrder(String updaterSSO){
			String response = "";
			String hql = "select itemvalue from pmms.sys_param where itemname = '" + Constants.DAILY_WO_PCM_QM_FLAG + "'";
			SQLQuery query = super.getSession().createSQLQuery(hql);
			
			List count = query.list();
			if(null != count && !count.get(0).toString().equalsIgnoreCase(Constants.TRUE))
			{
			
				InspectionSMRecordAndTrackLoogBook book = (InspectionSMRecordAndTrackLoogBook) super.getSession().createCriteria(InspectionSMRecordAndTrackLoogBook.class)
	                .add(Restrictions.eq("empSso", updaterSSO)).uniqueResult();						
			
				
				if(book == null)
					response = "FAIL";
	        	else
	        		response = "SUCCESS";
			}
			else
				response = "SUCCESS";
	    
			return response;
		}

	@Override
	public List<ViewForPCM> getScheduleMaintWoPCM(String workOrderType, String deptId, String equipType) {
		// TODO Auto-generated method stub
		Criteria c = super.getSession().createCriteria(ViewForPCM.class);
		c.add(Restrictions.ne("woStatus",Constants.WO_CLOSE));
		if(deptId.equals("0") && equipType.equals("0"))
		{
			c.add(Restrictions.ne("woStatus",Constants.WO_CLOSE));
			List<ViewForPCM> l = c.list();
			return l;
		}		
		if (StringUtils.isNotEmpty(deptId) && !deptId.equals("0")) {
			c.add(Restrictions.eq("deptId", deptId));	
		}

		if (StringUtils.isNotEmpty(equipType) && !equipType.equals("0")) {
			c.add(Restrictions.eq("equipType", equipType));
		}
		List<ViewForPCM> ls = c.list();
		return ls;
	}
	
	
	
}
