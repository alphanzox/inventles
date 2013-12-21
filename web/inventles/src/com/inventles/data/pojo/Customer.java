package com.inventles.data.pojo;

// Generated Dec 21, 2013 2:31:29 AM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Customer generated by hbm2java
 */
@Entity
@Table(name = "customer", catalog = "inventles")
public class Customer implements java.io.Serializable {

	private int customerId;
	private BusinessEntity businessEntity;
	private String firstName;
	private String lastName;
	private String cell;
	private String address;
	private String address2;
	private String city;
	private String zip;
	private String country;
	private String phone;
	private String email;
	private Set<CustomerOrder> customerOrders = new HashSet<CustomerOrder>(0);

	public Customer() {
	}

	public Customer(int customerId, BusinessEntity businessEntity,
			String firstName, String lastName, String cell) {
		this.customerId = customerId;
		this.businessEntity = businessEntity;
		this.firstName = firstName;
		this.lastName = lastName;
		this.cell = cell;
	}

	public Customer(int customerId, BusinessEntity businessEntity,
			String firstName, String lastName, String cell, String address,
			String address2, String city, String zip, String country,
			String phone, String email, Set<CustomerOrder> customerOrders) {
		this.customerId = customerId;
		this.businessEntity = businessEntity;
		this.firstName = firstName;
		this.lastName = lastName;
		this.cell = cell;
		this.address = address;
		this.address2 = address2;
		this.city = city;
		this.zip = zip;
		this.country = country;
		this.phone = phone;
		this.email = email;
		this.customerOrders = customerOrders;
	}

	@Id
	@Column(name = "customer_id", unique = true, nullable = false)
	public int getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "entity_code", nullable = false)
	public BusinessEntity getBusinessEntity() {
		return this.businessEntity;
	}

	public void setBusinessEntity(BusinessEntity businessEntity) {
		this.businessEntity = businessEntity;
	}

	@Column(name = "first_name", nullable = false, length = 45)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name", nullable = false, length = 45)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "cell", nullable = false, length = 45)
	public String getCell() {
		return this.cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	@Column(name = "address", length = 45)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "address_2", length = 45)
	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	@Column(name = "city", length = 45)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "zip", length = 45)
	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Column(name = "country", length = 45)
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "phone", length = 45)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "email", length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
	public Set<CustomerOrder> getCustomerOrders() {
		return this.customerOrders;
	}

	public void setCustomerOrders(Set<CustomerOrder> customerOrders) {
		this.customerOrders = customerOrders;
	}

}
