/**
 * 
 */
package com.shundr.database.dao.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.shundr.database.dao.CompanyInfoDao;

/**
 * @author Snailer
 *
 */
@Repository
public class CompanyInfoDaoImpl implements CompanyInfoDao {
	private static final Logger log = LoggerFactory
			.getLogger(CompanyInfoDaoImpl.class);
	
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
}
