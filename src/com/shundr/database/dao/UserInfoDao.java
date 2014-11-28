/**
 * 
 */
package com.shundr.database.dao;

import java.sql.Timestamp;

import com.shundr.database.bean.UserInfo;



/**
 * @author Snailer
 *
 */
public interface UserInfoDao {
	UserInfo getUserInfoByUserName(String username);

	Integer updateLoginTime(String username, Timestamp timestamp);

	UserInfo getUserInfoByUserPhone(String userphone);
	
	/**
	 * @author G.Liang
	 */
	boolean saveRegisterUser(UserInfo userInfo);
	/**
	 * @author G.Liang
	 */
	boolean getIsExistUser(String username);
	/**
	 * @author G.Liang
	 */
	boolean getIsExistPhone(String phone);
	/**
	 * @author G.Liang
	 */
	Integer updateUserPsw(String phone, String userpsw);
}
