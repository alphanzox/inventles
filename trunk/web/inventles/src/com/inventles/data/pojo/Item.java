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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Item generated by hbm2java
 */
@Entity
@Table(name = "item", catalog = "inventles")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Item implements java.io.Serializable {

	private int itemId;
	private BusinessEntity businessEntity;
	private String name;
	private String type;
	private String sku;
	private String maker;
	private Set<OrderItem> orderItems = new HashSet<OrderItem>(0);
	private Set<ItemTransaction> itemTransactions = new HashSet<ItemTransaction>(
			0);

	public Item() {
	}

	public Item(int itemId, BusinessEntity businessEntity, String name,
			String type, String sku) {
		this.itemId = itemId;
		this.businessEntity = businessEntity;
		this.name = name;
		this.type = type;
		this.sku = sku;
	}

	public Item(int itemId, BusinessEntity businessEntity, String name,
			String type, String sku, String maker, Set<OrderItem> orderItems,
			Set<ItemTransaction> itemTransactions) {
		this.itemId = itemId;
		this.businessEntity = businessEntity;
		this.name = name;
		this.type = type;
		this.sku = sku;
		this.maker = maker;
		this.orderItems = orderItems;
		this.itemTransactions = itemTransactions;
	}

	@Id
	@Column(name = "item_id", unique = true, nullable = false)
	public int getItemId() {
		return this.itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "entity_code", nullable = false)
	public BusinessEntity getBusinessEntity() {
		return this.businessEntity;
	}

	public void setBusinessEntity(BusinessEntity businessEntity) {
		this.businessEntity = businessEntity;
	}

	@Column(name = "name", nullable = false, length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "type", nullable = false, length = 45)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "sku", nullable = false, length = 45)
	public String getSku() {
		return this.sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	@Column(name = "maker", length = 45)
	public String getMaker() {
		return this.maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
	public Set<OrderItem> getOrderItems() {
		return this.orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
	public Set<ItemTransaction> getItemTransactions() {
		return this.itemTransactions;
	}

	public void setItemTransactions(Set<ItemTransaction> itemTransactions) {
		this.itemTransactions = itemTransactions;
	}

}
