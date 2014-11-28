package com.shundr.database.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * UserTruckRelation entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_truck_relation", catalog = "shundr_db", uniqueConstraints = @UniqueConstraint(columnNames = {
		"user_id", "truck_id" }))
public class UserTruckRelation implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userId;
	private Integer truckId;

	// Constructors

	/** default constructor */
	public UserTruckRelation() {
	}

	/** full constructor */
	public UserTruckRelation(Integer userId, Integer truckId) {
		this.userId = userId;
		this.truckId = truckId;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "user_id", nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "truck_id", nullable = false)
	public Integer getTruckId() {
		return this.truckId;
	}

	public void setTruckId(Integer truckId) {
		this.truckId = truckId;
	}

}