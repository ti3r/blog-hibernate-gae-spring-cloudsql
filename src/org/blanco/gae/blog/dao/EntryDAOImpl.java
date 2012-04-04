package org.blanco.gae.blog.dao;

import java.util.Date;

import org.blanco.gae.blog.entities.Entry;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class EntryDAOImpl extends HibernateDaoSupport {

	public void create(Entry entry){
		entry.setDate(new Date());
		getHibernateTemplate().save(entry);
	}
	
}
