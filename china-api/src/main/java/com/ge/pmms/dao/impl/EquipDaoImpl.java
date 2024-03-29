package com.ge.pmms.dao.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.ge.pmms.Constants;
import com.ge.pmms.dao.BasicDao;
import com.ge.pmms.dao.EquipDao;
import com.ge.pmms.dto.CommonKeyValuePair;
import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.entity.DepartmantInfo;
import com.ge.pmms.entity.EquipmentInfo;
import com.ge.pmms.entity.EquipmentNameInfo;
import com.ge.pmms.entity.LookupMst;



@Repository
public class EquipDaoImpl extends BasicDao implements EquipDao {

	CommonKeyValuePair commomKeyValuePair = new CommonKeyValuePair();
	@SuppressWarnings("unchecked")
	@Override
	public List<EquipmentInfo> getAllEquipDetails(String equipCategory) {
		Criteria c = super.getSession().createCriteria(EquipmentInfo.class, "equipmentInfo").add(Restrictions.like("recordType","EQUIPMENT"));
		
		if((equipCategory).equals("0"))
		{

			List<EquipmentInfo> l = c.list();
			return l;
			
		}
		if (StringUtils.isNotEmpty(equipCategory)) {

			c.add(Restrictions.eq("equipCategory", equipCategory));
		}

		//--------------------------------start 19 dec--------------------------//
		List<EquipmentInfo> equipList = c.list();	
		
		Collections.sort(equipList,  Collections.reverseOrder(new Comparator<EquipmentInfo>() {
 			@Override
 		    public int compare(EquipmentInfo o1, EquipmentInfo o2) {
 				if(o1.getLastUpdatedDate()!=null && o2.getLastUpdatedDate()!= null)
 				{
 					return o1.getLastUpdatedDate().compareTo(o2.getLastUpdatedDate());
 				}
 				else {
 					return 0;
 				}
 				}

 		}));
		return equipList;
		
	}
	
	public List<EquipmentInfo> getEquipInfoOnId(String equipId) {
		Criteria c = super.getSession().createCriteria(EquipmentInfo.class, "equipmentInfo").add(Restrictions.like("recordType","EQUIPMENT"));
		
		if((equipId).equals("0"))
		{

			List<EquipmentInfo> l = c.list();
			return l;
			
		}
		if (StringUtils.isNotEmpty(equipId)) {

			c.add(Restrictions.eq("equipId", equipId));
		}

		//--------------------------------start 19 dec--------------------------//
		List<EquipmentInfo> equipList = c.list();	
		
		Collections.sort(equipList,  Collections.reverseOrder(new Comparator<EquipmentInfo>() {
 			@Override
 		    public int compare(EquipmentInfo o1, EquipmentInfo o2) {
 				if(o1.getLastUpdatedDate()!=null && o2.getLastUpdatedDate()!= null)
 				{
 					return o1.getLastUpdatedDate().compareTo(o2.getLastUpdatedDate());
 				}
 				else {
 					return 0;
 				}
 				}

 		}));
		return equipList;
		
	}
//---------------------------------------------End--------------------------------------------------------
	@SuppressWarnings("unchecked")
	@Override
	public List<DropDownEntry> getEquipType(String Type) {
		
		Criteria c = super.getSession().createCriteria(LookupMst.class, "lookupMst")

				.setProjection(Projections.projectionList()
						.add(Projections.alias(Projections.distinct(Projections.property("lookupMst.Key")), "key"))
						.add(Projections.alias(Projections.property("lookupMst.Value"), "val")))

				.setResultTransformer(Transformers.aliasToBean(DropDownEntry.class)).setCacheable(true);

		if (StringUtils.isNotEmpty(Type)) {

			c.add(Restrictions.eq("Type", Type));
		}	
		List<DropDownEntry> l = c.list();
		List<DropDownEntry> finalList = commomKeyValuePair.addDefaultSelect(l);
		Collections.reverse(finalList);
		return finalList;
	}
	


	@SuppressWarnings("unchecked")
	@Override
	public List<DropDownEntry> getEquipName(String nameId) {
		
		System.out.println("2");
		
			Criteria c = super.getSession().createCriteria(EquipmentNameInfo.class, "equipNameInfo")
					.add(Restrictions.eq("equipNameInfo.equipType",nameId));;
					System.out.println("3");
			c.setProjection(Projections
					.projectionList().add(Projections
							.alias(Projections.distinct(Projections.property("equipNameInfo.equipNameId")), "key"))
					.add(Projections.alias(Projections.property("equipNameInfo.deviceName"), "val")))

					.setResultTransformer(Transformers.aliasToBean(DropDownEntry.class)).setCacheable(true);
			System.out.println("4");
			List<DropDownEntry> ls = c.list();
			System.out.println("5");
			return ls;
		}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<DropDownEntry> getDeptName() {
		
		Criteria c = super.getSession().createCriteria(DepartmantInfo.class, "departmantInfo")

				.setProjection(Projections.projectionList()
						.add(Projections.alias(Projections.distinct(Projections.property("departmantInfo.deptId")), "key"))
						.add(Projections.alias(Projections.property("departmantInfo.deptName"), "val")))

				.setResultTransformer(Transformers.aliasToBean(DropDownEntry.class)).setCacheable(true);

		/*if (StringUtils.isNotEmpty(Type)) {

			c.add(Restrictions.eq("Type", Type));
		}*/	
		List<DropDownEntry> l = c.list();
		return l;
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DropDownEntry> getCategory(String Type) {
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
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DropDownEntry> getPMXMC(String Type) {
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



	@Override
	public String deleteEquipmentInfo(String deleteId) {
		
		Session session=this.getSession();
		String[] ids = deleteId.split(",");
		for(String id : ids){
			EquipmentInfo equipInfo = (EquipmentInfo) session.load(EquipmentInfo.class, new Integer(id));
			if(null != equipInfo){
				session.delete(equipInfo);
			}
		}	
		return "SUCCESS";
	}

	@Override
	public void addEquipmentInfo(EquipmentInfo equipInfo) {
	
		System.out.println("Inside addEquipmentInfo method:"+ equipInfo.getEquipType());
		try{
		EquipmentNameInfo equipmentNameInfo = (EquipmentNameInfo) super.getSession().createCriteria(EquipmentNameInfo.class)
				.add(Restrictions.eq("equipNameId",equipInfo.getEquipMainId2())).uniqueResult();
		
		equipInfo.setEquipNameInfo(equipmentNameInfo);
		
		System.out.println("Inside addEquipmentInfo method value of deptid:"+ equipInfo.getDeptId2());
	
		DepartmantInfo	departmentinfo = (DepartmantInfo) super.getSession().createCriteria(DepartmantInfo.class)
				.add(Restrictions.eq("deptId",equipInfo.getDeptId2())).uniqueResult();
			equipInfo.setDeptInfo(departmentinfo);
		}
		catch(Exception e)
		{
			System.out.println("Exception caught:"+e);
			System.out.println("Exception caught details:"+e.getMessage());
			System.out.println("Exception caught details are:"+e.getCause());
		}


		if(StringUtils.isNotEmpty(equipInfo.getInuse()))
		{
			equipInfo.setInuse("Y");
		}
		else
		{
			equipInfo.setInuse("N");
		}
		

		/*if(StringUtils.isNotEmpty(equipInfo.getImpFlag()))
		{
			equipInfo.setImpFlag("Y");
		}
		else
		{
			equipInfo.setImpFlag("N");
		}*/
		equipInfo.setCreatedBy("123");
		equipInfo.setLastUpdatedBy("123");
		equipInfo.setRecordType(Constants.EQUIPMENT);
		
		super.getSession().saveOrUpdate(equipInfo);
		
	}

	@Override
	public void editEquipmentInfo(EquipmentInfo equipInfo) {
		super.getSession().saveOrUpdate(equipInfo);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EquipmentInfo> getEquipDetailsForDwnld() {
			Criteria c = super.getSession().createCriteria(EquipmentInfo.class, "equipmentInfo").add(Restrictions.like("recordType","EQUIPMENT"));	
			List<EquipmentInfo> ls = c.list();
			return ls;

	}

	
}