package com.ge.pmms.service;

import java.util.List;

import com.ge.pmms.entity.IndirectMaterial;
import com.ge.pmms.entity.sparePart;

public interface IndirectMaterialService {

	List<IndirectMaterial> getIndirectMaterial();

	void SaveIndirectMaterial(IndirectMaterial indirect);
	
	public String deleteIndirectMaterial(String deleteId);

	//List<IndirectMaterial> searchIndirectWithParameters(String searchData);
	
	List<IndirectMaterial> searchMaterialWithParameters(String data);

	List<IndirectMaterial> searchIndirectWithMultipleData(String searchMultipleData);
	}