/**
 * 
 */
package com.shundr.database.dao.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.shundr.database.bean.CargoInfo;
import com.shundr.database.bean.UserInfo;
import com.shundr.database.dao.CargoInfoDao;
import com.shundr.response.bean.CargoInfoList;

/**
 * @author Snailer
 *
 */
@Repository
public class CargoInfoDaoImpl implements CargoInfoDao {
	private static final Logger log = LoggerFactory
			.getLogger(CargoInfoDaoImpl.class);
	
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	/* (non-Javadoc)
	 * @see com.shundr.database.dao.CargoInfoDao#searchCargoListbyPlace(java.lang.String, java.lang.String)
	 */
	@Override
	public List<CargoInfo> searchCargoListbyPlace(String cargoSrcPlace,
			String cargoDstPlace) {
		// TODO Auto-generated method stub
		 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String where="cargoEndTime >'"+sdf.format(new Date())+"' and cargoStatus=0 ";
		if(cargoSrcPlace!=null&&cargoSrcPlace.length()>0){
			where += "and cargoSrcPlace like '"+cargoSrcPlace+"' ";
		}
		if(cargoDstPlace!=null&&cargoDstPlace.length()>0){
		
			where += "and cargoDstPlace like '"+cargoDstPlace+"' ";
		}
		
			final String hql="from CargoInfo where "+where;
			List<CargoInfo> cargoList= (List<CargoInfo>) this.getHibernateTemplate().execute(new HibernateCallback<Object>() {
				@Override
				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query query=session.createQuery(hql);
							
					return query.list();
				}
			});
				
			
	
		return cargoList;
	}

	@Override
	public void saveCargoInfo(final CargoInfo newCargo) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().execute(new HibernateCallback<Object>() {
	    	@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
	    		  
              
					session.save(newCargo);
			
						session.flush();
					
                    session.clear();  
			       return null; 
			}
		});
	}

	
}
