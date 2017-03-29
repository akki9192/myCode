package com.ge.pmms.service;

import java.util.List;

import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.entity.EquipmentInfo;

public interface EquipmentService {
	
	public List<EquipmentInfo> getAllEquipDetails(String equipType);
	public List<EquipmentInfo> getEquipInfoOnId(String equipId);
	public List<DropDownEntry> getEquipName(String nameId);
	public List<DropDownEntry> getDeptName();
	public String deleteEquipmentInfo(String deleteId);
	public void addEquipmentInfo(EquipmentInfo equipInfo);
	public void editEquipmentInfo(EquipmentInfo equipInfo);
	public List<DropDownEntry> getEquipType(String type);
	public List<DropDownEntry> getCategory(String type);
	public List<DropDownEntry> getPMXMC(String Type);
	public List<EquipmentInfo> getEquipDetailsForDwnld();
}
