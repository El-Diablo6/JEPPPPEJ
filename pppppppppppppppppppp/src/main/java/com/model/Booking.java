package com.model;

public class Booking {

	private String recipientName;
	private String recipienAddress;
	private String recipientPin;
	private String recipientMobile;

	private String parcelWeight;
	private String parcelContentsDescription;
	private String parcelDeliveryType;
	private String parcelPackingPreference;
	private String parcelPickupTime;
	private String parcelDropoffTime;
	private String parcelStatus;

	private String serviceCost;
	private String paymentTime;

	private String bookingID;

	private String name;
	private String address;
	private String userId;

	public Booking(String recipienAddress, String parcelStatus, String serviceCost, String paymentTime,
			String bookingID, String userId, String recipientName) {
		super();
		this.recipienAddress = recipienAddress;
		this.parcelStatus = parcelStatus;
		this.serviceCost = serviceCost;
		this.paymentTime = paymentTime;
		this.bookingID = bookingID;
		this.userId = userId;
		this.recipientName = recipientName;
	}

	private String mobile;
	private String role;

	public Booking(String recipientName, String recipienAddress, String recipientPin, String recipientMobile,
			String parcelWeight, String parcelContentsDescription, String parcelDeliveryType,
			String parcelPackingPreference, String parcelPickupTime, String parcelDropoffTime, String serviceCost,
			String name, String address, String mobile) {
		super();
		this.recipientName = recipientName;
		this.recipienAddress = recipienAddress;
		this.recipientPin = recipientPin;
		this.recipientMobile = recipientMobile;
		this.parcelWeight = parcelWeight;
		this.parcelContentsDescription = parcelContentsDescription;
		this.parcelDeliveryType = parcelDeliveryType;
		this.parcelPackingPreference = parcelPackingPreference;
		this.parcelPickupTime = parcelPickupTime;
		this.parcelDropoffTime = parcelDropoffTime;
		this.serviceCost = serviceCost;
		this.name = name;
		this.address = address;
		this.mobile = mobile;
	}
	

	public Booking(String recipientName, String recipienAddress, String recipientPin, String recipientMobile,
			String parcelWeight, String parcelContentsDescription, String parcelDeliveryType,
			String parcelPackingPreference, String parcelPickupTime, String parcelDropoffTime, String parcelStatus,
			String serviceCost, String paymentTime, String bookingID, String name, String address, String userId,
			String mobile, String role) {
		super();
		this.recipientName = recipientName;
		this.recipienAddress = recipienAddress;
		this.recipientPin = recipientPin;
		this.recipientMobile = recipientMobile;
		this.parcelWeight = parcelWeight;
		this.parcelContentsDescription = parcelContentsDescription;
		this.parcelDeliveryType = parcelDeliveryType;
		this.parcelPackingPreference = parcelPackingPreference;
		this.parcelPickupTime = parcelPickupTime;
		this.parcelDropoffTime = parcelDropoffTime;
		this.parcelStatus = parcelStatus;
		this.serviceCost = serviceCost;
		this.paymentTime = paymentTime;
		this.bookingID = bookingID;
		this.name = name;
		this.address = address;
		this.userId = userId;
		this.mobile = mobile;
		this.role = role;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public String getRecipienAddress() {
		return recipienAddress;
	}

	public void setRecipienAddress(String recipienAddress) {
		this.recipienAddress = recipienAddress;
	}

	public String getRecipientPin() {
		return recipientPin;
	}

	public void setRecipientPin(String recipientPin) {
		this.recipientPin = recipientPin;
	}

	public String getRecipientMobile() {
		return recipientMobile;
	}

	public void setRecipientMobile(String recipientMobile) {
		this.recipientMobile = recipientMobile;
	}

	public String getParcelWeight() {
		return parcelWeight;
	}

	public void setParcelWeight(String parcelWeight) {
		this.parcelWeight = parcelWeight;
	}

	public String getParcelContentsDescription() {
		return parcelContentsDescription;
	}

	public void setParcelContentsDescription(String parcelContentsDescription) {
		this.parcelContentsDescription = parcelContentsDescription;
	}

	public String getParcelDeliveryType() {
		return parcelDeliveryType;
	}

	public void setParcelDeliveryType(String parcelDeliveryType) {
		this.parcelDeliveryType = parcelDeliveryType;
	}

	public String getParcelPackingPreference() {
		return parcelPackingPreference;
	}

	public void setParcelPackingPreference(String parcelPackingPreference) {
		this.parcelPackingPreference = parcelPackingPreference;
	}

	public String getParcelPickupTime() {
		return parcelPickupTime;
	}

	public void setParcelPickupTime(String parcelPickupTime) {
		this.parcelPickupTime = parcelPickupTime;
	}

	public String getParcelDropoffTime() {
		return parcelDropoffTime;
	}

	public void setParcelDropoffTime(String parcelDropoffTime) {
		this.parcelDropoffTime = parcelDropoffTime;
	}

	public String getParcelStatus() {
		return parcelStatus;
	}

	public void setParcelStatus(String parcelStatus) {
		this.parcelStatus = parcelStatus;
	}

	public String getServiceCost() {
		return serviceCost;
	}

	public void setServiceCost(String serviceCost) {
		this.serviceCost = serviceCost;
	}

	public String getPaymentTime() {
		return paymentTime;
	}

	public void setPaymentTime(String paymentTime) {
		this.paymentTime = paymentTime;
	}

	public String getBookingID() {
		return bookingID;
	}

	public void setBookingID(String bookingID) {
		this.bookingID = bookingID;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
