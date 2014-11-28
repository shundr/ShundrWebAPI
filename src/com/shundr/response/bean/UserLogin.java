
/**
* @project Twitter
* @author Dayong.Shen
* @package com.ithing.database.bean
* @file XmlUserLogin.java
* 
* @date 2014-4-1-下午9:24:32
* @Copyright 2014 ISI Team of NUDT-版权所有
* 
*/
 
package com.shundr.response.bean;


import java.sql.Timestamp;

import com.shundr.database.bean.UserInfo;



/**
 * @project Twitter
 * @author Dayong.Shen
 * @class XmlUserLogin
 * 
 * @date 2014-4-1-下午9:24:32
 * @Copyright 2014 ISI Team of NUDT-版权所有
 * @Version 1.0.0
 */

public class UserLogin {
	
	
	private UserInfo user=null;	

	private String accessToken;
	
	
	private Timestamp lastActiveTime;
	
	public UserInfo getUser() {
		return user;
	}

	public String getAccessToken() {
		return accessToken;
	}

	

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	
	 /**
	 * lastActiveTime
	 *
	 * @return  the lastActiveTime
	 * @since   1.0.0
	 */
	
	public Timestamp getLastActiveTime() {
		return lastActiveTime;
	}

	
	 /**
	 * @param lastActiveTime the lastActiveTime to set
	 */
	 
	public void setLastActiveTime(Timestamp lastActiveTime) {
		this.lastActiveTime = lastActiveTime;
	}

	

}
