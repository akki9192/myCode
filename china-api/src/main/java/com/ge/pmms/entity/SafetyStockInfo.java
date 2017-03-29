package com.ge.pmms.entity;

public class SafetyStockInfo {

	private String deviceId;    
	private int num ;           
	private double sums;        
	private double avgAmount;    
	private double safetyStock;  
	public String getDeviceId() {
		return deviceId;
	}
	
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
	public double getSums() {
		return sums;
	}
	
	public void setSums(double sums) {
		this.sums = sums;
	}
	
	public double getAvgAmount() {
		return avgAmount;
	}
	
	public void setAvgAmount(double avgAmount) {
		this.avgAmount = avgAmount;
	}

	
	public double getSafetyStock() {
		return safetyStock;
	}

	public void setSafetyStock(double safetyStock) {
		this.safetyStock = safetyStock;
	}

	public SafetyStockInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SafetyStockInfo(String deviceId, int num, double sums, double avgAmount, double safetyStock) {
		super();
		this.deviceId = deviceId;
		this.num = num;
		this.sums = sums;
		this.avgAmount = avgAmount;
		this.safetyStock = safetyStock;
	}

	@Override
	public String toString() {
		return "SafetyStockInfo [deviceId=" + deviceId + ", num=" + num + ", sums=" + sums + ", avgAmount=" + avgAmount
				+ ", safetyStock=" + safetyStock + ", getDeviceId()=" + getDeviceId() + ", getNum()=" + getNum()
				+ ", getSums()=" + getSums() + ", getAvgAmount()=" + getAvgAmount() + ", getSafetyStock()="
				+ getSafetyStock() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
