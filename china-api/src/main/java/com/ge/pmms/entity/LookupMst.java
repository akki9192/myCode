package com.ge.pmms.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

/**
 * 
 *
 * @author Zoya Khan
 */
@Entity
@Table(name = "lookup_mst", schema = "pmms")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class LookupMst  implements Serializable{

	private static final long serialVersionUID = -6568764877783810450L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;

	@Column(name = "type")
	private String Type;
	
	@Column(name = "key")
	private String Key;
	
	
	@Column(name = "value")
	private String Value;


	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public String getType() {
		return Type;
	}


	public void setType(String type) {
		Type = type;
	}


	public String getKey() {
		return Key;
	}


	public void setKey(String key) {
		Key = key;
	}


	public String getValue() {
		return Value;
	}


	public void setValue(String value) {
		Value = value;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
