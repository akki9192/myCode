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
 * User principal for reporting a fault.
 *
 * @author Zoya Khan
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "users", schema = "PMMS")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate


public class SystemConfig implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name= "sso")
	private String sso;
	
	@Column(name="password")
	private String password;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="role")
	private String role;
	
	@Column(name="contactno")
	private String contactnumber;
	
	@Column(name="emailid")
	private String mailbox;
	
	@Column(name="language")
	private String language;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSso() {
		return sso;
	}
	public void setSso(String sso) {
		this.sso = sso;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}
	public String getMailbox() {
		return mailbox;
	}
	public void setMailbox(String mailbox) {
		this.mailbox = mailbox;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public SystemConfig() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SystemConfig [id=" + id + ", sso=" + sso + ", password=" + password + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", role=" + role + ", contactnumber=" + contactnumber + ", mailbox="
				+ mailbox + ", language=" + language + "]";
	}

	
}
