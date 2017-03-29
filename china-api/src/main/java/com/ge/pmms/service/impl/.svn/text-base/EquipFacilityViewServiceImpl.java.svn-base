package com.ge.pmms.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ge.pmms.dao.EquipFacilityViewDao;
import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.entity.EquipmentInfo;
import com.ge.pmms.service.EquipFacilityViewService;

@Service("viewService")
@Transactional
public class EquipFacilityViewServiceImpl implements EquipFacilityViewService, Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Autowired
	private EquipFacilityViewDao equipFacilityViewDao;

	@Override
	public List<DropDownEntry> getAllEquipmentTypess(String Type) {
	
		return equipFacilityViewDao.getAllEquipmentTypess(Type);
	}

	@Override
	public List<EquipmentInfo> getAllEquipmentDetailss(String equipType) {
		
		return equipFacilityViewDao.getAllEquipmentDetailss(equipType);
	}

	@Override
	public List<EquipmentInfo> getAllFacilityDetailss() {
		
		return equipFacilityViewDao.getAllFacilityDetailss();
	}
	

}
