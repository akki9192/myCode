package com.ge.pmms.dto;

import java.io.Serializable;

public class DropDownEntry implements Serializable {
	
	private static final long serialVersionUID = 8056611778173649394L;

	private int id;
	private String key;
	private String val;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getVal() {
		return val;
	}
	public void setVal(String val) {
		this.val = val;
	}
	
	public DropDownEntry() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DropDownEntry(int id, String key, String val) {
		super();
		this.id = id;
		this.key = key;
		this.val = val;
	}
	@Override
	public String toString() {
		return "DropDownEntry [id=" + id + ", key=" + key + ", val=" + val + ", getId()=" + getId() + ", getKey()="
				+ getKey() + ", getVal()=" + getVal() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	
	
}
