package com.inventles.data.management;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

public enum InventlesSessionManagement {
	INSTANCE;
	private SessionFactory sessionFactory;
	
	private InventlesSessionManagement(){
		 Configuration configuration = new Configuration();
	     configuration.configure("/resources/hibernate.cfg.xml");
	     ServiceRegistryBuilder serviceRegistryBuilder = new ServiceRegistryBuilder().applySettings(configuration.getProperties());
	     sessionFactory = configuration.buildSessionFactory(serviceRegistryBuilder.buildServiceRegistry());
	}
	
	public SessionFactory getSessionFactory(){
		return sessionFactory;
	}

}
