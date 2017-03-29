package com.ge.pmms.dto;


public class ChartInfoParam {
	private String equipId;
	
	private String startDate;
	
	private String endDate;
	
	private String sparePartId;
	
	private String year;
	
	private String month;
	
	private String wo_status;

	public ChartInfoParam(){
		
	}
	
	public ChartInfoParam(String equipId,String startDate, String endDate){
		this.equipId = equipId;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	
	/**
	 * @return the sparePartId
	 */
	public String getSparePartId() {
		return sparePartId;
	}

	
	/**
	 * @param sparePartId the sparePartId to set
	 */
	public void setSparePartId(String sparePartId) {
		this.sparePartId = sparePartId;
	}

	
	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}

	
	/**
	 * @param year the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}

	
	public String getEquipId() {
		return equipId;
	}

	
	public void setEquipId(String equipId) {
		this.equipId = equipId;
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

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getWo_status() {
		return wo_status;
	}

	public void setWo_status(String wo_status) {
		this.wo_status = wo_status;
	}
	
	
}
