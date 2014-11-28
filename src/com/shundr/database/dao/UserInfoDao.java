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

	Integer updateLoginTime(Timestamp timestamp);

	UserInfo getUserInfoByUserPhone(String userphone);
}
