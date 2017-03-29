package com.ge.pmms.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import com.ge.pmms.dao.BasicDao;
import com.ge.pmms.dao.IndirectMaterialDao;
import com.ge.pmms.entity.IndirectMaterial;
import com.ge.pmms.entity.sparePart;



@Repository
public class IndirectMaterialDaoImpl extends BasicDao implements IndirectMaterialDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<IndirectMaterial> getIndirectMaterial() {
	
	 return super.getSession().createCriteria(IndirectMaterial.class).list();
	}

	
	@Override
	public void SaveIndirectMaterial(IndirectMaterial indirect) {
		super.getSession().saveOrUpdate(indirect);
		
	}

	@Override
	public String deleteIndirectMaterial(String deleteId) {
		
		Session session=this.getSession();
		String[] ids = deleteId.split(",");
		for(String id : ids){
			IndirectMaterial indirectMaterial = (IndirectMaterial) session.load(IndirectMaterial.class, new Integer(id));
			if(null != indirectMaterial){
				session.delete(indirectMaterial);
			}
		}	
		return "SUCCESS";
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<IndirectMaterial> searchMaterialWithParameters(String data) {
		JSONObject materialData = new JSONObject(data);
		
		
		String manufacturer = materialData.getString("source");
		String Name=materialData.getString("name");
		
		
		Criteria c= super.getSession().createCriteria(sparePart.class);
		
		c.add(Restrictions.eq("source", manufacturer));
		c.add(Restrictions.eq("name",Name ));
		
		List<IndirectMaterial> indiret=c.list();	
		return indiret;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IndirectMaterial> searchIndirectWithMultipleData(String searchMultipleData) {
		
		JSONObject multipleData = new JSONObject(searchMultipleData);
		
		String materialName= multipleData.getString("idmName");
		String materialManufacturer = multipleData.getString("source");
		String model=String.valueOf(multipleData.getInt("idmId"));
		
		Criteria criteria =super.getSession().createCriteria(IndirectMaterial.class);
		criteria.add(Restrictions.eq("idmName", materialName));
		criteria.add(Restrictions.eq("source", materialManufacturer));
		criteria.add(Restrictions.eq("idmId", model));
		
		List<IndirectMaterial> indiret=criteria.list();	
		return indiret;
		
		
	}

}
