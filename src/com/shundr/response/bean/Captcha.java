/**
 * 
 */
package com.shundr.response.bean;

import java.sql.Timestamp;

/**
 * @author G.Liang
 *
 */
public class Captcha {
	private String captchaStr;
	private Timestamp firstGetCaptchaTime;
	public String getCaptchaStr() {
		return captchaStr;
	}
	public void setCaptchaStr(String captchaStr) {
		this.captchaStr = captchaStr;
	}
	public Timestamp getFirstGetCaptchaTime() {
		return firstGetCaptchaTime;
	}
	public void setFirstGetCaptchaTime(Timestamp firstGetCaptchaTime) {
		this.firstGetCaptchaTime = firstGetCaptchaTime;
	}
	
	
	
	
	
	

}
