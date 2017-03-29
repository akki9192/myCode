package com.ge.pmms.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ge.pmms.dao.EquipDao;
import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.entity.EquipmentInfo;
import com.ge.pmms.service.EquipmentService;


@Service("euipService")
@Transactional
public class EquipmentServiceImpl implements EquipmentService, Serializable {

	private static final long serialVersionUID = 8660080660984105245L;

	private static final Logger log = LoggerFactory.getLogger(EquipmentServiceImpl.class);

	@Autowired
	private EquipDao equipdao;

	@Override
	public List<EquipmentInfo> getAllEquipDetails(String equipType) {

		return equipdao.getAllEquipDetails(equipType);
	}
	//to be removed
	@Override
	public List<EquipmentInfo> getEquipInfoOnId(String equipId) {
		
		List<EquipmentInfo> lst=null;
		if(equipId !=null && isNumeric(equipId)) {
				lst=equipdao.getEquipInfoOnId(equipId);
		} else {
			//set error 
		}
		return lst;
//		return equipdao.getEquipInfoOnId(equipId);
	}
	
	/**
	 * Checks if is numeric.
	 *
	 * @param strInput the str input
	 * @return true, if is numeric
	 */
	public static boolean isNumeric(String strInput) {
		char inputChar;
		boolean valid = true;
		if (strInput == null) {
			return valid;//assuming null string is valid.
		} else {
			int strInputLength = strInput.length();
			for (int index = 0; index < strInputLength; index++) {
				inputChar = strInput.charAt(index);
				if ((inputChar >= 48 && inputChar <= 57)) {
					continue;
				} else {
					valid = false;
					return valid;
				}
			}
			return valid;
		}
	}

	@Override
	public List<DropDownEntry> getEquipType(String Type) {

		return equipdao.getEquipType(Type);
	}

	@Override
	public List<DropDownEntry> getEquipName(String nameId) {
		return equipdao.getEquipName(nameId);
	}

	@Override
	public List<DropDownEntry>getDeptName() {

		return equipdao.getDeptName();
	}

	

	@Override
	public void addEquipmentInfo(EquipmentInfo equipInfo) {
	
		System.out.println("Inside addEquipmentInfo method in service imp" +equipInfo.getEquipType());
		equipdao.addEquipmentInfo(equipInfo);
	}

	@Override
	public void editEquipmentInfo(EquipmentInfo equipInfo) {
		equipdao.editEquipmentInfo(equipInfo);
		
		
	}

	@Override
	public List<DropDownEntry> getCategory(String Type) {
	 return	equipdao.getCategory(Type);
		
	}

	@Override
	public String deleteEquipmentInfo(String deleteId) {
		
		return equipdao.deleteEquipmentInfo(deleteId);
	}

	@Override
	public List<DropDownEntry> getPMXMC(String Type) {
		
		return equipdao.getPMXMC(Type);
	}

	@Override
	public List<EquipmentInfo> getEquipDetailsForDwnld() {
		
		return equipdao.getEquipDetailsForDwnld() ;
	}


}