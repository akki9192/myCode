package com.ge.pmms.dao;

import java.util.List;

import com.ge.pmms.entity.IndirectMaterial;

public interface IndirectMaterialDao {

	List<IndirectMaterial> getIndirectMaterial();

	void SaveIndirectMaterial(IndirectMaterial indirect);

	public String deleteIndirectMaterial(String deleteId);

	List<IndirectMaterial> searchMaterialWithParameters(String data);
	
	List<IndirectMaterial> searchIndirectWithMultipleData(String searchMultipleData);

}