package com.shundr.database.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * TruckInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "truck_info", catalog = "shundr_db", uniqueConstraints = @UniqueConstraint(columnNames = "truck_plate_number"))
public class TruckInfo implements java.io.Serializable {

	// Fields

	private Integer truckId;
	private String truckType;
	private Float truckLength;
	private Float truckCapacity;
	private String truckPlateNumber;
	private String truckLicense;
	private Integer truckStatus;
	private String truckCurrentLocation;
	private String truckForwardLocation1;
	private String truckForwardLocation2;
	private String truckForwardLocation3;
	private String truckForwardLocation4;

	// Constructors

	/** default constructor */
	public TruckInfo() {
	}

	/** full constructor */
	public TruckInfo(String truckType, Float truckLength, Float truckCapacity,
			String truckPlateNumber, String truckLicense, Integer truckStatus,
			String truckCurrentLocation, String truckForwardLocation1,
			String truckForwardLocation2, String truckForwardLocation3,
			String truckForwardLocation4) {
		this.truckType = truckType;
		this.truckLength = truckLength;
		this.truckCapacity = truckCapacity;
		this.truckPlateNumber = truckPlateNumber;
		this.truckLicense = truckLicense;
		this.truckStatus = truckStatus;
		this.truckCurrentLocation = truckCurrentLocation;
		this.truckForwardLocation1 = truckForwardLocation1;
		this.truckForwardLocation2 = truckForwardLocation2;
		this.truckForwardLocation3 = truckForwardLocation3;
		this.truckForwardLocation4 = truckForwardLocation4;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "truck_id", unique = true, nullable = false)
	public Integer getTruckId() {
		return this.truckId;
	}

	public void setTruckId(Integer truckId) {
		this.truckId = truckId;
	}

	@Column(name = "truck_type", length = 11)
	public String getTruckType() {
		return this.truckType;
	}

	public void setTruckType(String truckType) {
		this.truckType = truckType;
	}

	@Column(name = "truck_length", precision = 10)
	public Float getTruckLength() {
		return this.truckLength;
	}

	public void setTruckLength(Float truckLength) {
		this.truckLength = truckLength;
	}

	@Column(name = "truck_capacity", precision = 10)
	public Float getTruckCapacity() {
		return this.truckCapacity;
	}

	public void setTruckCapacity(Float truckCapacity) {
		this.truckCapacity = truckCapacity;
	}

	@Column(name = "truck_plate_number", unique = true, length = 50)
	public String getTruckPlateNumber() {
		return this.truckPlateNumber;
	}

	public void setTruckPlateNumber(String truckPlateNumber) {
		this.truckPlateNumber = truckPlateNumber;
	}

	@Column(name = "truck_license")
	public String getTruckLicense() {
		return this.truckLicense;
	}

	public void setTruckLicense(String truckLicense) {
		this.truckLicense = truckLicense;
	}

	@Column(name = "truck_status")
	public Integer getTruckStatus() {
		return this.truckStatus;
	}

	public void setTruckStatus(Integer truckStatus) {
		this.truckStatus = truckStatus;
	}

	@Column(name = "truck_current_location", length = 500)
	public String getTruckCurrentLocation() {
		return this.truckCurrentLocation;
	}

	public void setTruckCurrentLocation(String truckCurrentLocation) {
		this.truckCurrentLocation = truckCurrentLocation;
	}

	@Column(name = "truck_forward_location1")
	public String getTruckForwardLocation1() {
		return this.truckForwardLocation1;
	}

	public void setTruckForwardLocation1(String truckForwardLocation1) {
		this.truckForwardLocation1 = truckForwardLocation1;
	}

	@Column(name = "truck_forward_location2")
	public String getTruckForwardLocation2() {
		return this.truckForwardLocation2;
	}

	public void setTruckForwardLocation2(String truckForwardLocation2) {
		this.truckForwardLocation2 = truckForwardLocation2;
	}

	@Column(name = "truck_forward_location3")
	public String getTruckForwardLocation3() {
		return this.truckForwardLocation3;
	}

	public void setTruckForwardLocation3(String truckForwardLocation3) {
		this.truckForwardLocation3 = truckForwardLocation3;
	}

	@Column(name = "truck_forward_location4")
	public String getTruckForwardLocation4() {
		return this.truckForwardLocation4;
	}

	public void setTruckForwardLocation4(String truckForwardLocation4) {
		this.truckForwardLocation4 = truckForwardLocation4;
	}

}