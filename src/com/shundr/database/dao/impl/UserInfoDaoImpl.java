/**
 * 
 */
package com.shundr.database.dao.impl;

import java.sql.SQLException;
import java.sql.Timestamp;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.shundr.database.bean.UserInfo;
import com.shundr.database.dao.UserInfoDao;

/**
 * @author Snailer
 *
 */
@Repository
public class UserInfoDaoImpl implements UserInfoDao {
	private static final Logger log = LoggerFactory
			.getLogger(UserInfoDaoImpl.class);
	
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	@Override
	public UserInfo getUserInfoByUserName(final String username) {
		// TODO Auto-generated method stub
		try{
			final String hql="from UserInfo where userName=:username";
			UserInfo user=(UserInfo) this.getHibernateTemplate().execute(new HibernateCallback<Object>() {
				@Override
				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query query=session.createQuery(hql);
					query.setString("username", username);					
					return query.uniqueResult();
				}
			});
				
				return user;
		
		}catch(Exception e){
			log.error("getUserInfoByUserName ERROR!"+e.getMessage());
			return null;
		}
	}

	@Override
	public Integer updateLoginTime(final Timestamp timestamp) {
		// TODO Auto-generated method stub
		try{
			final String hql="update UserInfo set userLastLoginTime=:userlastlogintime";
			int status=(Integer) this.getHibernateTemplate().execute(new HibernateCallback<Object>() {
				@Override
				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query query=session.createQuery(hql);
					query.setTimestamp("userlastlogintime", timestamp);					
					return query.executeUpdate();
				}
			});
				
			return status;	
		
		}catch(Exception e){
			log.error("setLoginTime ERROR!"+e.getMessage());
			return 0;
		}
	}

	@Override
	public UserInfo getUserInfoByUserPhone(final String userphone) {
		// TODO Auto-generated method stub
		try{
			final String hql="from UserInfo where userPhone=:userphone";
			UserInfo user=(UserInfo) this.getHibernateTemplate().execute(new HibernateCallback<Object>() {
				@Override
				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query query=session.createQuery(hql);
					query.setString("userphone", userphone);					
					return query.uniqueResult();
				}
			});
				
				return user;
		
		}catch(Exception e){
			log.error("getUserInfoByUserPhone ERROR!"+e.getMessage());
			return null;
		}
	}
	
	
}
