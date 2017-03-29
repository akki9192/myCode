package com.ge.pmms.dao;

import java.util.List;

import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.entity.EquipmentInfo;

public interface EquipDao {

	public List<DropDownEntry> getEquipType(String Type);
	public List<DropDownEntry> getEquipName(String nameId);
	public List<DropDownEntry> getDeptName();
	String deleteEquipmentInfo(String deleteId);
	public void addEquipmentInfo(EquipmentInfo equipInfo);
	public void editEquipmentInfo(EquipmentInfo equipInfo);
	public List<DropDownEntry> getCategory(String type);
	public List<EquipmentInfo> getAllEquipDetails(String equipType);
	public List<DropDownEntry> getPMXMC(String Type);
	public List<EquipmentInfo> getEquipDetailsForDwnld();
	public List<EquipmentInfo> getEquipInfoOnId(String equipId);
}
