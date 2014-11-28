/**
 * 
 */
package com.shundr.database.dao.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.shundr.database.dao.TruckInfoDao;

/**
 * @author Snailer
 *
 */
@Repository
public class TruckInfoDaoImpl implements TruckInfoDao {
	private static final Logger log = LoggerFactory
			.getLogger(TruckInfoDaoImpl.class);
	
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
}
