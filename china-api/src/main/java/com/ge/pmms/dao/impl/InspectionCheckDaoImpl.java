package com.ge.pmms.dao.impl;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ge.pmms.Constants;
import com.ge.pmms.dao.BasicDao;
import com.ge.pmms.dao.InspectionCheckDao;
import com.ge.pmms.dto.CommonKeyValuePair;
import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.entity.EquipmentInfo;
import com.ge.pmms.entity.FaultReport;
import com.ge.pmms.entity.InspectionSMRecordAndTrackLoogBook;
import com.ge.pmms.entity.LookupMst;
import com.ge.pmms.entity.MaintainaceItem;
import com.ge.pmms.entity.MaintainanceCheckDtls;
import com.ge.pmms.entity.Maintainancecheck;
import com.ge.pmms.entity.User;
import com.ge.pmms.entity.WorkOrderMaintainance;


@Repository
public class InspectionCheckDaoImpl extends BasicDao implements InspectionCheckDao  {

	CommonKeyValuePair commomKeyValuePair = new CommonKeyValuePair();
	private static final Logger log = LoggerFactory.getLogger(InspectionCheckDaoImpl.class);

	@Override
	@SuppressWarnings("unchecked")
	public List<Maintainancecheck> getInspectionDetails(String maintType,String deptId,String equipCategory) 
	{
		Criteria c = super.getSession().createCriteria(Maintainancecheck.class, "Maintainancecheck");
		c.createAlias("Maintainancecheck.equipmentInfo", "equipmentInfo");

		
		if("0".equalsIgnoreCase(deptId.trim()) && "0".equalsIgnoreCase(equipCategory.trim()))
		{
			c.add(Restrictions.eq("maintType", maintType));
			//c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			List<Maintainancecheck> l = c.list();
			return l;
			
		}		
		if (StringUtils.isNotEmpty(deptId) && !deptId.equals("0")) {
			
			c.createAlias("equipmentInfo.deptInfo", "deptInfo");						
			c.add(Restrictions.eq("deptInfo.deptId", deptId));	
		}

		if (StringUtils.isNotEmpty(equipCategory) && !equipCategory.equals("0")) {

			c.add(Restrictions.eq("equipmentInfo.equipCategory", equipCategory));

		}
		
		
		c.add(Restrictions.eq("maintType", maintType));	
		c.add(Restrictions.ne("status",Constants.WO_CLOSE ));
		c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Maintainancecheck> l = c.list();
		return l;
		
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<MaintainanceCheckDtls> getInspectionCheckInfoDetails(String maintId) {
		
	Criteria c = super.getSession().createCriteria(MaintainanceCheckDtls.class, "MaintainanceCheckDtls");
		//c.createAlias("MaintainanceCheckDtls.maintainaceItem", "maintainaceItem"); // inner join by default	
	if (StringUtils.isNotEmpty(maintId)){
		c.add(Restrictions.eq("maintId",maintId));
	}
	else{
	return null;
	}
		List<MaintainanceCheckDtls> maintainanceCheckDtlsList = c.list();
		return maintainanceCheckDtlsList;
	
	}

	@Override
	public void startInspectionCheckDetails(Maintainancecheck maintainanceCheck, String mainArrString) {
		updateMaintainanceStatus(maintainanceCheck, mainArrString ,Constants.WO_IN_PROGRESS);
	}
	
	@Override
	public void closeMaintainanceWork(Maintainancecheck maintainanceCheck, String strMaintaincheck) 
	{
		updateMaintainanceStatus(maintainanceCheck, strMaintaincheck ,Constants.WO_CLOSE);
	}

	@Override
	public void saveMaintainanceWork(Maintainancecheck maintainanceCheck, String strMaintaincheck) 
	{
		updateMaintainanceStatus(maintainanceCheck, strMaintaincheck ,null);
	}
	
	public void updateMaintainanceStatus(Maintainancecheck maintainanceCheck, String strMaintaincheck ,String strStatus)
	{
		
		String frequency = null;
		String sso=maintainanceCheck.getSso();
	    String[] arr = strMaintaincheck.split(",");	    
	    ArrayList maintaincheckArray= convertStringArrayToArraylist(arr);	  	    
		List maintaincheckArrayList = new ArrayList<Object>();
		maintaincheckArrayList.add(maintaincheckArray);
		if(maintaincheckArrayList!=null && !maintaincheckArrayList.isEmpty() && !(maintaincheckArray.size() == 1) && !("".equals(maintaincheckArray.get(0))))
		{
		 frequency = (String)((List)maintaincheckArrayList.get(0)).get(6);
		}
		
		Criteria c = super.getSession().createCriteria(Maintainancecheck.class, "maintainanceCheck");
		c.add(Restrictions.eq("id", maintainanceCheck.getId()));
		Maintainancecheck check = (Maintainancecheck) c.uniqueResult();
		check.setLastUpdatedDt(new Date());
		check.setMaintType(Constants.INSPECTION_CHECK);
		check.setLastUpdatedBy(maintainanceCheck.getSso());
		if(null!=strStatus){
			check.setStatus(strStatus);
			
			if(strStatus.equalsIgnoreCase(Constants.WO_IN_PROGRESS))
			{
			    check.setActualStartDt(new Date());
				
			}
			else if (strStatus.equalsIgnoreCase(Constants.WO_CLOSE))
			{
				check.setActualEndDt(new Date());
			}
		}
		
		check.setMaintId(maintainanceCheck.getMaintId());
	    check.setFrequency(frequency);
	    
	    for(int i=0;i<maintaincheckArrayList.size();i++)
		{
	    	if(!("".equals(maintaincheckArray.get(0))))
			{
	    	String maintItemId=(String)((List)maintaincheckArrayList.get(i)).get(0);	    
			String scanValue=(String)((List)maintaincheckArrayList.get(i)).get(1);
			String spendTime=(String)((List)maintaincheckArrayList.get(i)).get(2);
			String maintId=(String)((List)maintaincheckArrayList.get(i)).get(3);
			Integer id=Integer.parseInt((String)((List)maintaincheckArrayList.get(i)).get(4));
			
	    	Criteria cr = super.getSession().createCriteria(MaintainanceCheckDtls.class, "maintainanceCheckDtls");
			cr.add(Restrictions.eq("id", id));
			MaintainanceCheckDtls maintainanceCheckDtls = (MaintainanceCheckDtls) cr.uniqueResult();
			maintainanceCheckDtls.setMaintItemId(maintItemId);
			maintainanceCheckDtls.setScanValue(scanValue);
			maintainanceCheckDtls.setSpendTime(spendTime);
			maintainanceCheckDtls.setMaintId(maintId);
			maintainanceCheckDtls.setId(id);
			maintainanceCheckDtls.setLastUpdatedDt(new Date());
			maintainanceCheckDtls.setLastUpdatedBy(sso);
			super.getSession().saveOrUpdate(maintainanceCheckDtls);	
			}
		   // updateMaintainanceCheckDtl(maintainanceCheckDtls);
		}
		super.getSession().saveOrUpdate(check);
	}

	private void updateMaintainanceCheckDtl(MaintainanceCheckDtls maintainanceCheckDtls) 
	{
		   MaintainaceItem item =  (MaintainaceItem) super.getSession().createCriteria(MaintainaceItem.class).add(Restrictions.eq("maintId",maintainanceCheckDtls.getMaintItemId())).uniqueResult();
		   maintainanceCheckDtls.setMaintainaceItem(item);
		   maintainanceCheckDtls.setScanValue(maintainanceCheckDtls.getScanValue());
		   maintainanceCheckDtls.setSpendTime(maintainanceCheckDtls.getSpendTime());
		   super.getSession().saveOrUpdate(maintainanceCheckDtls);	
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<DropDownEntry> getFactoryNames(String Type) 
	{
		// TODO Auto-generated method stub
		Criteria c = super.getSession().createCriteria(LookupMst.class, "lookupMst")
				.setProjection(Projections
						.projectionList().add(Projections
								.alias(Projections.distinct(Projections.property("lookupMst.Key")), "key"))
						.add(Projections.alias(Projections.property("lookupMst.Value"), "val")))
				.setResultTransformer(Transformers.aliasToBean(DropDownEntry.class)).setCacheable(true);		
		if (StringUtils.isNotEmpty(Type)) 
		{
		
			c.add(Restrictions.eq("Type", Type));
		}
		List<DropDownEntry> list = c.list();
		   List<DropDownEntry> finalList = commomKeyValuePair.addDefaultSelect(list);
			
			//List<DropDownEntry> finalList= CommonUtil.addSelect(l);
			//return finalList;
			Collections.reverse(finalList);
			return finalList;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<DropDownEntry> getEquipmentCategory(String Type) {
		
		Criteria c = super.getSession().createCriteria(LookupMst.class, "lookupMst")

				.setProjection(Projections
						.projectionList().add(Projections
								.alias(Projections.distinct(Projections.property("lookupMst.Key")), "key"))
						.add(Projections.alias(Projections.property("lookupMst.Value"), "val")))

				.setResultTransformer(Transformers.aliasToBean(DropDownEntry.class)).setCacheable(true);
		if (StringUtils.isNotEmpty(Type)) {
			
			c.add(Restrictions.eq("Type", Type));
		}
		
		List<DropDownEntry> l = c.list();
		List<DropDownEntry> finalList = commomKeyValuePair.addDefaultSelect(l);
		
		//List<DropDownEntry> finalList= CommonUtil.addSelect(l);
		//return finalList;
		Collections.reverse(finalList);
		return finalList;		
	}
	public static ArrayList<String> convertStringArrayToArraylist(String[] strArr){
	    ArrayList<String> stringList = new ArrayList<String>();
	    for (String s : strArr) {
	        stringList.add(s);
	    }
	    return stringList;
	}


	@Override
	public String validateMantainenceSSO(String data) {
		
		
		/*String response = "";
		String hql ="select count(*) from pmms.sys_param where itemname = '维修团队名单列表' and itemvalue = '"+data+"' ";
		SQLQuery query = super.getSession().createSQLQuery(hql);
		List listResult = query.list();
		int ssoPresent =((BigInteger) listResult.get(0)).intValue();	
		if(ssoPresent < 1)
			response ="FAIL";				
		else
			response ="SUCCESS";
		
	    return response;

	}*/
		
		String response = "";
		User user = (User) super.getSession().createCriteria(User.class).add(Restrictions.eq("sso", data)).uniqueResult();
		
		if(user == null)
			response+="Fail sso,";
	    				
	    if(response.indexOf("Fail") == -1)
	    	response="SUCCESS";
	    return response;
	}
	
	
}
