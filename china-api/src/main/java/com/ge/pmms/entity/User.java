package com.ge.pmms.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@Table(name = "USERS", schema = "PMMS")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class User implements Serializable {

    private static final long serialVersionUID = 2356099827274624508L;

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "sso")
    private String sso;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "lastname")
    private String lastName;
    
    @Transient
    private String fullName;

	@Column(name = "firstname")
    private String firstName;
    
    @Column(name = "role")
    private String role;
    
    @Column(name = "emailid")
    private String emailId;
    
    @Column(name = "contactno")
    private String contactNo;
    
    @Column(name = "language")
    private String language;
    
    /**
     * Dummy constructor.
     */
    public User() {
        // dummy
    }
    
    public User(Integer id, String sso, String password,String firstName,String lastName,String role,String emailId,String contactNo,String language) {
		super();
		this.id = id;
		this.sso=sso;
		this.password=password;
		this.firstName=firstName;
		this.lastName=lastName;
		this.role=role;
		this.emailId=emailId;
		this.contactNo=contactNo;
		this.language=language;
	}

    @Override
    public boolean equals(Object target) {
        if (target == null || !(target instanceof User)) {
            return false;
        }
        return this.id == ((User) target).id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getLastName() {
		return lastName;
	}

	public void setLastname(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstname(String firstName) {
		this.firstName = firstName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailid(String emailId) {
		this.emailId = emailId;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactno(String contactNo) {
		this.contactNo = contactNo;
	}
    
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

    
    public String getFullName() {
		return getFirstName() + " " + getLastName();
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
}
