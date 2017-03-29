package com.ge.pmms.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ge.pmms.dao.IndirectMaterialDao;
import com.ge.pmms.entity.IndirectMaterial;
import com.ge.pmms.service.IndirectMaterialService;




@Service("IndirectMaterialService")

@Transactional
public class IndirectMaterialServiceImpl implements IndirectMaterialService{
	
	
	@Autowired
	private IndirectMaterialDao indirectDao;
	
	
	@Override
	public List<IndirectMaterial> getIndirectMaterial() {
		
		return indirectDao.getIndirectMaterial();
	}


	@Override
	public void SaveIndirectMaterial(IndirectMaterial indirect) {
		
		indirectDao.SaveIndirectMaterial(indirect);
		
	}


	@Override
	public String deleteIndirectMaterial(String deleteId) {
		
		return indirectDao.deleteIndirectMaterial(deleteId);
	}

/*
	@Override
	public List<IndirectMaterial> searchIndirectWithParameters(String searchData) {
		
		return indirectDao.searchMaterialWithParameters(searchData);
	}
*/

	@Override
	public List<IndirectMaterial> searchMaterialWithParameters(String data) {
		return indirectDao.searchMaterialWithParameters(data);
	}


	@Override
	public List<IndirectMaterial> searchIndirectWithMultipleData(String searchMultipleData) {
		// TODO Auto-generated method stub
		return indirectDao.searchIndirectWithMultipleData(searchMultipleData);
	}


	

}