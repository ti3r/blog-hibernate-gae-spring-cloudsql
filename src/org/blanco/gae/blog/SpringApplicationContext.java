package org.blanco.gae.blog;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringApplicationContext implements ApplicationContextAware {

	static ApplicationContext myContext = null;
	
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		myContext = arg0;
	}

	public static Object getBean(String beanName) { 
        return (myContext != null) ? myContext.getBean(beanName) : null; 
    }
	
}
