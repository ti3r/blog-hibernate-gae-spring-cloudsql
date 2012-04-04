package org.blanco.gae.blog.dao;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HibernateSessionFactory {

	private static ApplicationContext myContext = null;
	static SessionFactory myFactory = null;
	
	static{
		 myContext = new ClassPathXmlApplicationContext("/SpringBeans.xml");
	}
	
	
	public static ApplicationContext getApplicationContext(){
		return myContext;
	}
	
	public static SessionFactory getSessionFactory(){
		if (myFactory == null){
			myFactory = (SessionFactory) myContext.getBean("sessionFactory");
		}
		return myFactory;
	}
}
