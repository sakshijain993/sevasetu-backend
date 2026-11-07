package com.sevasetu.organization_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Organization {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String name;
	private String type;
	private String description;
	private String address;
	private String city;
	private String state;
	private Integer pincode;
	private String contactNumber;
	private String createdAt;
	private String updatedAt;
	
	@PrePersist
	protected void onCreate() {
		String now = java.time.LocalDateTime.now().toString();
		this.createdAt = now;
		this.updatedAt = now;
	}
	
	@PreUpdate
	protected void onupdate() {
		this.updatedAt = java.time.LocalDateTime.now().toString();
		
	}
	
	
	public Long getId() {
		return id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public Organization() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Organization(@NotBlank String name, String type, String description, String address, String city,
			String state, Integer pincode, String contactNumber, String createdAt, String updatedAt) {
		super();
		this.name = name;
		this.type = type;
		this.description = description;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.contactNumber = contactNumber;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	

}
