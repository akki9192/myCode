package com.ge.pmms.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ge.pmms.dao.BasicDao;
import com.ge.pmms.dao.EquipFacilityViewDao;
import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.entity.EquipmentInfo;
import com.ge.pmms.entity.LookupMst;

@Repository
public class EquipFacilityViewDaoImpl extends BasicDao implements EquipFacilityViewDao{
	
	private static final Logger log = LoggerFactory.getLogger(EquipFacilityViewDaoImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<DropDownEntry> getAllEquipmentTypess(String Type) {
		
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
	public List<EquipmentInfo> getAllEquipmentDetailss(String equipType) {
		Criteria c = super.getSession()
				.createCriteria(EquipmentInfo.class, "equipmentInfo");
		
		
		if (StringUtils.isNotEmpty(equipType)) {
            if(equipType=="Production equipment")
            {
            	equipType="1";
            }
			
			c.add(Restrictions.eq("equipmentInfo.equipType", equipType));
		}
		List<EquipmentInfo> ls = c.list();
		return ls;

	}
	
	@Override
	public List<EquipmentInfo> getAllFacilityDetailss() {
		
		Criteria c = super.getSession().createCriteria(EquipmentInfo.class, "equipInfo");
		
		
		List<EquipmentInfo> lis =c.list();
        return lis;
	}
	

}
