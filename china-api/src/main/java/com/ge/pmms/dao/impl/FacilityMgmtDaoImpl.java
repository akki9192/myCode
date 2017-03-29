package com.ge.pmms.dao.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ge.pmms.Constants;
import com.ge.pmms.dao.BasicDao;
import com.ge.pmms.dao.FacilityMgmtDao;
import com.ge.pmms.dto.CommonKeyValuePair;
import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.entity.DepartmantInfo;
import com.ge.pmms.entity.EquipmentInfo;
import com.ge.pmms.entity.EquipmentNameInfo;
import com.ge.pmms.entity.LookupMst;
import com.ge.pmms.entity.Maintainancecheck;
import com.ge.pmms.entity.Role;
import com.ge.pmms.entity.User;

@Repository
public class FacilityMgmtDaoImpl extends BasicDao implements FacilityMgmtDao{

	private static final Logger log = LoggerFactory.getLogger(FacilityMgmtDaoImpl.class);
	CommonKeyValuePair commomKeyValuePair = new CommonKeyValuePair();
	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> removeFacility(List<Integer> ids) {
		
		Session session=this.getSession();
		
		for(int id : ids){
		}
	
		return ids;
		}
/*@SuppressWarnings("unchecked")
	@Override
	public List<EquipmentInfo> getAllEquipDetails(String equipType) {
		Criteria c = super.getSession().createCriteria(EquipmentInfo.class, "equipmentInfo");
		if(!equipType.isEmpty()){
			c.add(Restrictions.eq("equipmentInfo.equipType",equipType));
		}
		
		List<EquipmentInfo> ls = c.list();
		return ls;
		}*/
	@SuppressWarnings("unchecked")
	@Override
	public List<EquipmentInfo> getFacilityDet(String equipCategory) {
		
		Criteria c = super.getSession().createCriteria(EquipmentInfo.class, "equipmentInfo")
				.add(Restrictions.eq("equipmentInfo.recordType",Constants.FACILITY));
		if (StringUtils.isNotEmpty(equipCategory)) {
			c.add(Restrictions.eq("equipCategory", equipCategory));			
			
		} 
		
		List<EquipmentInfo> ls = c.list();
		return ls;
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public void addFacilityInf(EquipmentInfo equipmentInfo) {
		try{
		EquipmentNameInfo equipmentNameInfo = (EquipmentNameInfo) super.getSession().createCriteria(EquipmentNameInfo.class)
				.add(Restrictions.eq("equipNameId",equipmentInfo.getEquipMainId2())).uniqueResult();
		
		equipmentInfo.setEquipNameInfo(equipmentNameInfo);
		
		
		DepartmantInfo departmentinfo = (DepartmantInfo) super.getSession().createCriteria(DepartmantInfo.class)
				.add(Restrictions.eq("deptId",equipmentInfo.getDeptId2())).uniqueResult();
		equipmentInfo.setDeptInfo(departmentinfo);
		}
		catch(Exception e)
		{
			System.out.println("Exception caught:"+e);
			System.out.println("Exception caught details:"+e.getMessage());
			System.out.println("Exception caught details are:"+e.getCause());
		}
		
		equipmentInfo.setCreatedBy(equipmentInfo.getTechnicalDescription());
		equipmentInfo.setLastUpdatedBy(equipmentInfo.getTechnicalDescription());		
		equipmentInfo.setRecordType(Constants.FACILITY);
	
		
		super.getSession().saveOrUpdate(equipmentInfo);

		
	}
		
	

	@SuppressWarnings("unchecked")
	@Override
	public List<DropDownEntry> getFacilityCategories(String type) {
		
		
		 List<DropDownEntry> faciltiyCategory = null;
		 List<DropDownEntry> finalList =null;

		 if (StringUtils.isNotEmpty(type)) {
			 
			 Criteria criteria = super.getSession().createCriteria(EquipmentInfo.class)
					 .add(Restrictions.like("recordType","FACILITY"))
					 .setProjection(Projections.projectionList()
								.add(Projections.alias(Projections.distinct(Projections.property(type)), "key"))
								.add(Projections.alias(Projections.property(type), "val")))
						.setResultTransformer(Transformers.aliasToBean(DropDownEntry.class)).setCacheable(true);

//			 criteria.setProjection(Projections.property(type));
			 faciltiyCategory= criteria.list();
			 finalList = commomKeyValuePair.addDefaultSelect(faciltiyCategory);
				Collections.reverse(finalList);
				
	   }
		 return finalList;
		 
	}


	@SuppressWarnings("unchecked")
	@Override
	public void editFacilityInf(EquipmentInfo equipmentInfo) {
		
		super.getSession().saveOrUpdate(equipmentInfo);
		
	}

	@SuppressWarnings("unchecked")
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

	@SuppressWarnings("unchecked")
	@Override
	public List<DropDownEntry> getfacilityNames(String equipType) {
		List<DropDownEntry> finalList =null;
		System.out.println("2");
		
		Criteria c = super.getSession().createCriteria(EquipmentNameInfo.class, "equipNameInfo")
				.add(Restrictions.eq("equipNameInfo.equipType","设施"));
			
		c.setProjection(Projections
				.projectionList().add(Projections
						.alias(Projections.distinct(Projections.property("equipNameInfo.equipNameId")), "key"))
				.add(Projections.alias(Projections.property("equipNameInfo.deviceName"), "val")))

				.setResultTransformer(Transformers.aliasToBean(DropDownEntry.class)).setCacheable(true);
		
		List<DropDownEntry> ls = c.list();
		finalList = commomKeyValuePair.addDefaultSelect(ls);
		Collections.reverse(finalList);
		
		return ls;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DropDownEntry> getDeptNames(String Type) {
		List<DropDownEntry> finalList =null;
		Criteria c = super.getSession().createCriteria(LookupMst.class, "lookupMst")

				.setProjection(Projections.projectionList()
						.add(Projections.alias(Projections.distinct(Projections.property("lookupMst.Key")), "key"))
						.add(Projections.alias(Projections.property("lookupMst.Value"), "val")))

				.setResultTransformer(Transformers.aliasToBean(DropDownEntry.class)).setCacheable(true);

		if (StringUtils.isNotEmpty(Type)) {

			c.add(Restrictions.eq("Type", Type));
		}	
		List<DropDownEntry> l = c.list();
		List<DropDownEntry> ls = c.list();
		finalList = commomKeyValuePair.addDefaultSelect(ls);
		Collections.reverse(finalList);
		
		return l;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EquipmentInfo> getFacilityDownload() {
		Criteria c = super.getSession().createCriteria(EquipmentInfo.class, "equipmentInfo").add(Restrictions.like("recordType","FACILITY"));
		List<EquipmentInfo> ls = c.list();
		return ls;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EquipmentInfo> getFacilityDtls(String facilityCategory) {
		Criteria c = super.getSession().createCriteria(EquipmentInfo.class, "equipmentInfo").add(Restrictions.like("recordType","FACILITY"));
		
		if((facilityCategory).equals("0"))
		{

			List<EquipmentInfo> l = c.list();
			return l;
			
		}
		if (StringUtils.isNotEmpty(facilityCategory)) {

			c.add(Restrictions.eq("facilityCategory", facilityCategory));
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

	
	}



