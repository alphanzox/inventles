package com.inventles.data.pojo;

// Generated Dec 21, 2013 2:31:29 AM by Hibernate Tools 4.0.0

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Order generated by hbm2java
 */
@Entity
@Table(name = "order", catalog = "inventles")
public class Order implements java.io.Serializable {

	private int orderId;
	private BusinessEntity businessEntity;
	private String orderNumber;
	private Date date;
	private Set<CustomerOrder> customerOrders = new HashSet<CustomerOrder>(0);
	private Set<OrderItem> orderItems = new HashSet<OrderItem>(0);
	private Set<EmployeeOrder> employeeOrders = new HashSet<EmployeeOrder>(0);

	public Order() {
	}

	public Order(int orderId, BusinessEntity businessEntity,
			String orderNumber, Date date) {
		this.orderId = orderId;
		this.businessEntity = businessEntity;
		this.orderNumber = orderNumber;
		this.date = date;
	}

	public Order(int orderId, BusinessEntity businessEntity,
			String orderNumber, Date date, Set<CustomerOrder> customerOrders,
			Set<OrderItem> orderItems, Set<EmployeeOrder> employeeOrders) {
		this.orderId = orderId;
		this.businessEntity = businessEntity;
		this.orderNumber = orderNumber;
		this.date = date;
		this.customerOrders = customerOrders;
		this.orderItems = orderItems;
		this.employeeOrders = employeeOrders;
	}

	@Id
	@Column(name = "order_id", unique = true, nullable = false)
	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "entity_code", nullable = false)
	public BusinessEntity getBusinessEntity() {
		return this.businessEntity;
	}

	public void setBusinessEntity(BusinessEntity businessEntity) {
		this.businessEntity = businessEntity;
	}

	@Column(name = "order_number", nullable = false, length = 45)
	public String getOrderNumber() {
		return this.orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date", nullable = false, length = 19)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
	public Set<CustomerOrder> getCustomerOrders() {
		return this.customerOrders;
	}

	public void setCustomerOrders(Set<CustomerOrder> customerOrders) {
		this.customerOrders = customerOrders;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
	public Set<OrderItem> getOrderItems() {
		return this.orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
	public Set<EmployeeOrder> getEmployeeOrders() {
		return this.employeeOrders;
	}

	public void setEmployeeOrders(Set<EmployeeOrder> employeeOrders) {
		this.employeeOrders = employeeOrders;
	}

}