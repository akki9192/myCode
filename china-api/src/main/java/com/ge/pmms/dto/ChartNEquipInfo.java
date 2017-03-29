package com.ge.pmms.dto;

import java.io.Serializable;

public class ChartNEquipInfo implements Serializable{

	private static final long serialVersionUID = -3627951270005732779L;


private String NoEquip;
private String startDate;
private String endDate;



public String getNoEquip() {
	return NoEquip;
}
public void setNoEquip(String noEquip) {
	NoEquip = noEquip;
}
public String getStartDate() {
	return startDate;
}
public void setStartDate(String startDate) {
	this.startDate = startDate;
}
public String getEndDate() {
	return endDate;
}
public void setEndDate(String endDate) {
	this.endDate = endDate;
}
@Override
public String toString() {
	return "ChartNEquipInfo [NoEquip=" + NoEquip + ", startDate=" + startDate + ", endDate=" + endDate + "]";
}

public ChartNEquipInfo(String noEquip, String startDate, String endDate) {
	super();
	NoEquip = noEquip;
	this.startDate = startDate;
	this.endDate = endDate;
}
public ChartNEquipInfo() {
	super();

}


}
