package com.ge.pmms.dao.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ge.pmms.Constants;
import com.ge.pmms.dao.BasicDao;
import com.ge.pmms.dao.MaintainanceDao;
import com.ge.pmms.entity.EquipmentInfo;
import com.ge.pmms.entity.FaultReport;
import com.ge.pmms.entity.MaintainaceItem;
import com.ge.pmms.entity.MaintainanceCheckDtls;
import com.ge.pmms.entity.Maintainancecheck;


@Repository
public class MaintainanceDaoImpl extends BasicDao implements MaintainanceDao  {

	private static final Logger log = LoggerFactory.getLogger(MaintainanceDaoImpl.class);
	
@Override
	public List<Maintainancecheck> getMaintainanceDetails(String maintType,String deptId, String equipCategory) {
		// TODO Auto-generated method stub
		
		Criteria c = super.getSession().createCriteria(Maintainancecheck.class, "Maintainancecheck");
		c.createAlias("Maintainancecheck.equipmentInfo", "equipmentInfo"); // inner join by default	
		
		if(deptId.equals("0")&& maintType.equals("0") && equipCategory.equals("0"))
		{
			c.add(Restrictions.eq("maintType", maintType));
			c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
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
		c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Maintainancecheck> l =c.list();
		return l;
	}

@Override
public List<MaintainanceCheckDtls> getMaintainanceinfo() {
	// TODO Auto-generated method stub
	Criteria c = super.getSession().createCriteria(MaintainanceCheckDtls.class, "MaintainanceCheckDtls");
	c.createAlias("MaintainanceCheckDtls.maintainaceItem", "maintainaceItem"); // inner join by default	
	List<MaintainanceCheckDtls> ls = c.list();
	return ls;
}



public void updateMaintainanceCheckDtl(MaintainanceCheckDtls checkDtls)
{
	MaintainaceItem item =  (MaintainaceItem) super.getSession().createCriteria(MaintainaceItem.class)
	.add(Restrictions.eq("maintId",checkDtls.getMaintItemId())).uniqueResult();
	checkDtls.setMaintainaceItem(item);
	checkDtls.setScanValue(checkDtls.getScanValue());
	checkDtls.setSpendTime(checkDtls.getSpendTime());
	super.getSession().saveOrUpdate(checkDtls);
	}

@Override
public List<MaintainanceCheckDtls> getMaintainanceinfo(String maintId) {
	// TODO Auto-generated method stub
	Criteria c = super.getSession().createCriteria(MaintainanceCheckDtls.class, "MaintainanceCheckDtls");
	c.createAlias("MaintainanceCheckDtls.maintainaceItem", "maintainaceItem"); // inner join by default	
	c.add(Restrictions.eq("MaintainanceCheckDtls.maintId",maintId));
	List<MaintainanceCheckDtls> ls = c.list();
	return ls;
	}

@Override
public void startMaintainance(Maintainancecheck maintainanceCheck, String mainArrString) {
	// TODO Auto-generated method stub
	updateMaintainanceStatus(maintainanceCheck, mainArrString ,Constants.WO_IN_PROGRESS);
	
}

@Override
public void closeMaintainanceWork(Maintainancecheck maintaianance, String mainArrString) {
	// TODO Auto-generated method stub
	updateMaintainanceStatus(maintaianance, mainArrString ,Constants.WO_CLOSE);
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
    ArrayList maintaincheckArray= InspectionCheckDaoImpl.convertStringArrayToArraylist(arr);	  	    
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



}
