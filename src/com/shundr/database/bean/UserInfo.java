package com.shundr.database.bean;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * UserInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_info", catalog = "shundr_db", uniqueConstraints = @UniqueConstraint(columnNames = "user_citizen_number"))
public class UserInfo implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String userName;
	private Integer userAges;
	@JsonIgnore
	private String userPsw;
	private String userRealName;
	private String userCitizenNumber;
	private Float userDriverAges;
	private Integer userStatus;
	private String userPhone;
	private Short isCompany;
	private Timestamp userRegesiterTime;
	private Timestamp userLastLoginTime;

	// Constructors

	/** default constructor */
	public UserInfo() {
	}

	/** full constructor */
	public UserInfo(String userName, Integer userAges, String userPsw,
			String userRealName, String userCitizenNumber,
			Float userDriverAges, Integer userStatus, String userPhone,
			Short isCompany, Timestamp userRegesiterTime,
			Timestamp userLastLoginTime) {
		this.userName = userName;
		this.userAges = userAges;
		this.userPsw = userPsw;
		this.userRealName = userRealName;
		this.userCitizenNumber = userCitizenNumber;
		this.userDriverAges = userDriverAges;
		this.userStatus = userStatus;
		this.userPhone = userPhone;
		this.isCompany = isCompany;
		this.userRegesiterTime = userRegesiterTime;
		this.userLastLoginTime = userLastLoginTime;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "user_id", unique = true, nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "user_name", length = 20)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "user_ages")
	public Integer getUserAges() {
		return this.userAges;
	}

	public void setUserAges(Integer userAges) {
		this.userAges = userAges;
	}

	@Column(name = "user_psw", length = 50)
	public String getUserPsw() {
		return this.userPsw;
	}

	public void setUserPsw(String userPsw) {
		this.userPsw = userPsw;
	}

	@Column(name = "user_real_name", length = 50)
	public String getUserRealName() {
		return this.userRealName;
	}

	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}

	@Column(name = "user_citizen_number", unique = true, length = 18)
	public String getUserCitizenNumber() {
		return this.userCitizenNumber;
	}

	public void setUserCitizenNumber(String userCitizenNumber) {
		this.userCitizenNumber = userCitizenNumber;
	}

	@Column(name = "user_driver_ages", precision = 10)
	public Float getUserDriverAges() {
		return this.userDriverAges;
	}

	public void setUserDriverAges(Float userDriverAges) {
		this.userDriverAges = userDriverAges;
	}

	@Column(name = "user_status")
	public Integer getUserStatus() {
		return this.userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	@Column(name = "user_phone", length = 20)
	public String getUserPhone() {
		return this.userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	@Column(name = "is_company")
	public Short getIsCompany() {
		return this.isCompany;
	}

	public void setIsCompany(Short isCompany) {
		this.isCompany = isCompany;
	}

	@Column(name = "user_regesiter_time", length = 19)
	public Timestamp getUserRegesiterTime() {
		return this.userRegesiterTime;
	}

	public void setUserRegesiterTime(Timestamp userRegesiterTime) {
		this.userRegesiterTime = userRegesiterTime;
	}

	@Column(name = "user_last_login_time", length = 19)
	public Timestamp getUserLastLoginTime() {
		return this.userLastLoginTime;
	}

	public void setUserLastLoginTime(Timestamp userLastLoginTime) {
		this.userLastLoginTime = userLastLoginTime;
	}

}