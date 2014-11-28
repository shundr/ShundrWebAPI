package com.shundr.database.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * CompanyInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "company_info", catalog = "shundr_db", uniqueConstraints = @UniqueConstraint(columnNames = "company_business_license"))
public class CompanyInfo implements java.io.Serializable {

	// Fields

	private Integer companyId;
	private Integer userId;
	private String companyName;
	private String companyBusinessLicense;
	private String companyBusinessImagePath;
	private String companyManager;
	private String companyTel;
	private String companyPhone;

	// Constructors

	/** default constructor */
	public CompanyInfo() {
	}

	/** full constructor */
	public CompanyInfo(Integer userId, String companyName,
			String companyBusinessLicense, String companyBusinessImagePath,
			String companyManager, String companyTel, String companyPhone) {
		this.userId = userId;
		this.companyName = companyName;
		this.companyBusinessLicense = companyBusinessLicense;
		this.companyBusinessImagePath = companyBusinessImagePath;
		this.companyManager = companyManager;
		this.companyTel = companyTel;
		this.companyPhone = companyPhone;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "company_id", unique = true, nullable = false)
	public Integer getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	@Column(name = "user_id")
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "company_name", length = 500)
	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Column(name = "company_business_license", unique = true)
	public String getCompanyBusinessLicense() {
		return this.companyBusinessLicense;
	}

	public void setCompanyBusinessLicense(String companyBusinessLicense) {
		this.companyBusinessLicense = companyBusinessLicense;
	}

	@Column(name = "company_business_image_path", length = 500)
	public String getCompanyBusinessImagePath() {
		return this.companyBusinessImagePath;
	}

	public void setCompanyBusinessImagePath(String companyBusinessImagePath) {
		this.companyBusinessImagePath = companyBusinessImagePath;
	}

	@Column(name = "company_manager", length = 32)
	public String getCompanyManager() {
		return this.companyManager;
	}

	public void setCompanyManager(String companyManager) {
		this.companyManager = companyManager;
	}

	@Column(name = "company_tel")
	public String getCompanyTel() {
		return this.companyTel;
	}

	public void setCompanyTel(String companyTel) {
		this.companyTel = companyTel;
	}

	@Column(name = "company_phone")
	public String getCompanyPhone() {
		return this.companyPhone;
	}

	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}

}