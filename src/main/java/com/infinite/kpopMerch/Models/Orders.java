package com.infinite.kpopMerch.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {
	@Id
	@Column(name = "order_id")
	private String orderId;

	@Column(name = "order_date")
	private String orderDate;
	@Column(name = "customer_name")
	private String customerName;
	@Column(name = "customer_phone")
	private String customerPhone;
	@Column(name = "customer_pin")
	private String customerPin;
	@Column(name = "cutomer_city")
	private String cutomerCity;
	@Column(name = "customer_address")
	private String customerAddress;
	@Column(name = "cutsomer_state")
	private String customerState;
	@Column(name = "customer_add_type")
	private String customerAddType;
	@Column(name = "userid")
	private String userId;
	@Column(name = "album_id")
	private String albumId;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerPin() {
		return customerPin;
	}

	public void setCustomerPin(String customerPin) {
		this.customerPin = customerPin;
	}

	public String getCutomerCity() {
		return cutomerCity;
	}

	public void setCutomerCity(String cutomerCity) {
		this.cutomerCity = cutomerCity;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerState() {
		return customerState;
	}

	public void setCustomerState(String customerState) {
		this.customerState = customerState;
	}

	public String getCustomerAddType() {
		return customerAddType;
	}

	public void setCustomerAddType(String customerAddType) {
		this.customerAddType = customerAddType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAlbumId() {
		return albumId;
	}

	public void setAlbumId(String albumId) {
		this.albumId = albumId;
	}

}
