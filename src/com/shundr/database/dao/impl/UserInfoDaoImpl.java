/**
 * 
 */
package com.shundr.database.dao.impl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

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
	public Integer updateLoginTime(final String username, final Timestamp timestamp) {
		// TODO Auto-generated method stub
		try{
			final String hql="update UserInfo set userLastLoginTime=:userlastlogintime where userName=:userName";
			int status=(Integer) this.getHibernateTemplate().execute(new HibernateCallback<Object>() {
				@Override
				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query query=session.createQuery(hql);
					query.setTimestamp("userlastlogintime", timestamp);	
					query.setString("userName", username);
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

	/**
	 * @author G.Liang
	 */
	@Override
	public boolean saveRegisterUser(final UserInfo userInfo) {
		try{
			hibernateTemplate.execute(new HibernateCallback<Object>() {
				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					session.save(userInfo);
					session.flush();
					return null;
				}
			});
			return true;
		} catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}

	/**
	 * @author G.Liang
	 */
	@Override
	public boolean getIsExistUser(String username) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
	    try {
		
	    		final String hql="from UserInfo where userName =:userName";

				Query query=session.createQuery(hql);
				query.setString("userName", username);
				List list=query.list();
				if(list.size()==0){			
				    return false;
			    }else {
			    	return true;
			    }
		
		}catch (Exception ex) {
			// TODO Auto-generated catch block
			log.error("getIsExistUser ERROR! "+ ex.getMessage());	
			return false;
		}finally{				
	        session.close();		       
	    } 
	}

	/**
	 * @author G.Liang
	 */
	@Override
	public boolean getIsExistPhone(String phone) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
	    try {
		
	    		final String hql="from UserInfo where userPhone =:userPhone";

				Query query=session.createQuery(hql);
				query.setString("userPhone", phone);
				List list=query.list();
				if(list.size()==0){			
				    return false;
			    }else {
			    	return true;
			    }
		
		}catch (Exception ex) {
			// TODO Auto-generated catch block
			log.error("getIsExistUser ERROR! "+ ex.getMessage());	
			return false;
		}finally{				
	        session.close();		       
	    } 
	}

	/**
	 * @author G.Liang
	 */
	@Override
	public Integer updateUserPsw(final String phone, final String userpsw) {
		try{
			final String hql="update UserInfo set userPsw =: userPsw where userPhone =: userPhone";
			int status=(Integer) this.getHibernateTemplate().execute(new HibernateCallback<Object>() {
				@Override
				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query query=session.createQuery(hql);
					query.setString("userPsw", userpsw);	
					query.setString("userPhone", phone);
					return query.executeUpdate();
				}
			});
				
			return status;	
		
		}catch(Exception e){
			log.error("setLoginTime ERROR!"+e.getMessage());
			return 0;
		}
	}

	
}
