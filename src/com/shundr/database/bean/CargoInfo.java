package com.shundr.database.bean;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CargoInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cargo_info", catalog = "shundr_db")
public class CargoInfo implements java.io.Serializable {

	// Fields

	private Integer cargoId;
	private Integer userId;
	private String cargoCategory;
	private Double cargoWeight;
	private Double cargoVolume;
	private String cargoSrcPlace;
	private String cargoDstPlace;
	private String cargoTurckType;
	private String cargoOwnerName;
	private String cargoOwnerPhone;
	private Float cargoPriceMin;
	private Float cargoPriceMax;
	private String cargoUnitName;
	private Float cargoUnitPrice;
	private String cargoDescription;
	private Timestamp cargoInsertTime;
	private Timestamp cargoEndTime;
	private Integer cargoStatus;

	// Constructors

	/** default constructor */
	public CargoInfo() {
	}

	/** full constructor */
	public CargoInfo(Integer userId, String cargoCategory, Double cargoWeight,
			Double cargoVolume, String cargoSrcPlace, String cargoDstPlace,
			String cargoTurckType, String cargoOwnerName,
			String cargoOwnerPhone, Float cargoPriceMin, Float cargoPriceMax,
			String cargoUnitName, Float cargoUnitPrice,
			String cargoDescription, Timestamp cargoInsertTime,
			Timestamp cargoEndTime, Integer cargoStatus) {
		this.userId = userId;
		this.cargoCategory = cargoCategory;
		this.cargoWeight = cargoWeight;
		this.cargoVolume = cargoVolume;
		this.cargoSrcPlace = cargoSrcPlace;
		this.cargoDstPlace = cargoDstPlace;
		this.cargoTurckType = cargoTurckType;
		this.cargoOwnerName = cargoOwnerName;
		this.cargoOwnerPhone = cargoOwnerPhone;
		this.cargoPriceMin = cargoPriceMin;
		this.cargoPriceMax = cargoPriceMax;
		this.cargoUnitName = cargoUnitName;
		this.cargoUnitPrice = cargoUnitPrice;
		this.cargoDescription = cargoDescription;
		this.cargoInsertTime = cargoInsertTime;
		this.cargoEndTime = cargoEndTime;
		this.cargoStatus = cargoStatus;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "cargo_id", unique = true, nullable = false)
	public Integer getCargoId() {
		return this.cargoId;
	}

	public void setCargoId(Integer cargoId) {
		this.cargoId = cargoId;
	}

	@Column(name = "user_id")
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "cargo_category", length = 50)
	public String getCargoCategory() {
		return this.cargoCategory;
	}

	public void setCargoCategory(String cargoCategory) {
		this.cargoCategory = cargoCategory;
	}

	@Column(name = "cargo_weight", precision = 10, scale = 3)
	public Double getCargoWeight() {
		return this.cargoWeight;
	}

	public void setCargoWeight(Double cargoWeight) {
		this.cargoWeight = cargoWeight;
	}

	@Column(name = "cargo_volume", precision = 10, scale = 3)
	public Double getCargoVolume() {
		return this.cargoVolume;
	}

	public void setCargoVolume(Double cargoVolume) {
		this.cargoVolume = cargoVolume;
	}

	@Column(name = "cargo_src_place")
	public String getCargoSrcPlace() {
		return this.cargoSrcPlace;
	}

	public void setCargoSrcPlace(String cargoSrcPlace) {
		this.cargoSrcPlace = cargoSrcPlace;
	}

	@Column(name = "cargo_dst_place")
	public String getCargoDstPlace() {
		return this.cargoDstPlace;
	}

	public void setCargoDstPlace(String cargoDstPlace) {
		this.cargoDstPlace = cargoDstPlace;
	}

	@Column(name = "cargo_turck_type")
	public String getCargoTurckType() {
		return this.cargoTurckType;
	}

	public void setCargoTurckType(String cargoTurckType) {
		this.cargoTurckType = cargoTurckType;
	}

	@Column(name = "cargo_owner_name")
	public String getCargoOwnerName() {
		return this.cargoOwnerName;
	}

	public void setCargoOwnerName(String cargoOwnerName) {
		this.cargoOwnerName = cargoOwnerName;
	}

	@Column(name = "cargo_owner_phone", length = 32)
	public String getCargoOwnerPhone() {
		return this.cargoOwnerPhone;
	}

	public void setCargoOwnerPhone(String cargoOwnerPhone) {
		this.cargoOwnerPhone = cargoOwnerPhone;
	}

	@Column(name = "cargo_price_min", precision = 10, scale = 3)
	public Float getCargoPriceMin() {
		return this.cargoPriceMin;
	}

	public void setCargoPriceMin(Float cargoPriceMin) {
		this.cargoPriceMin = cargoPriceMin;
	}

	@Column(name = "cargo_price_max", precision = 10, scale = 3)
	public Float getCargoPriceMax() {
		return this.cargoPriceMax;
	}

	public void setCargoPriceMax(Float cargoPriceMax) {
		this.cargoPriceMax = cargoPriceMax;
	}

	@Column(name = "cargo_unit_name", length = 10)
	public String getCargoUnitName() {
		return this.cargoUnitName;
	}

	public void setCargoUnitName(String cargoUnitName) {
		this.cargoUnitName = cargoUnitName;
	}

	@Column(name = "cargo_unit_price", precision = 10, scale = 3)
	public Float getCargoUnitPrice() {
		return this.cargoUnitPrice;
	}

	public void setCargoUnitPrice(Float cargoUnitPrice) {
		this.cargoUnitPrice = cargoUnitPrice;
	}

	@Column(name = "cargo_description", length = 500)
	public String getCargoDescription() {
		return this.cargoDescription;
	}

	public void setCargoDescription(String cargoDescription) {
		this.cargoDescription = cargoDescription;
	}

	@Column(name = "cargo_insert_time", length = 19)
	public Timestamp getCargoInsertTime() {
		return this.cargoInsertTime;
	}

	public void setCargoInsertTime(Timestamp cargoInsertTime) {
		this.cargoInsertTime = cargoInsertTime;
	}

	@Column(name = "cargo_end_time", length = 19)
	public Timestamp getCargoEndTime() {
		return this.cargoEndTime;
	}

	public void setCargoEndTime(Timestamp cargoEndTime) {
		this.cargoEndTime = cargoEndTime;
	}

	@Column(name = "cargo_status")
	public Integer getCargoStatus() {
		return this.cargoStatus;
	}

	public void setCargoStatus(Integer cargoStatus) {
		this.cargoStatus = cargoStatus;
	}

}