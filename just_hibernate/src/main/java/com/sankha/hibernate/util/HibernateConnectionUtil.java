package com.sankha.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class HibernateConnectionUtil {
	private static SessionFactory sessionFactory;

	/**
	 * Since Hibernate 4.x, this approach is deprecated. According to Hibernate
	 * 4.0 API docs, the Configuration class’ buildSessionFactory() method is
	 * deprecated.
	 * 
	 * The Configuration class’ configure() method loads mappings and properties
	 * from the convention resource file hibernate.cfg.xml which should be
	 * present in the classpath.
	 * 
	 * @return SessionFactory
	 */
	/*-
	public static SessionFactory initSessionFactoryBeforeHibernae4_x() {
	if (sessionFactory == null) {
			Configuration configuration = new Configuration().configure();
			sessionFactory = configuration.buildSessionFactory();
		}
	
		return sessionFactory;
	}
	*/

	/**
	 * Hibernate recommends developers to use the
	 * buildSessionFactory(ServiceRegistry) instead from 4.0 till 4.2.x.
	 * 
	 * The Configuration class’ configure() method loads mappings and properties
	 * from the convention resource file hibernate.cfg.xml which should be
	 * present in the classpath.
	 * 
	 * @return SessionFactory
	 */
	/*-
	public static SessionFactory initSessionFactoryTillHibernate4_2_x() {
		if (sessionFactory == null) {
			Configuration configuration = new Configuration().configure();
			ServiceRegistryBuilder serviceRegistryBuilder = new ServiceRegistryBuilder();
			serviceRegistryBuilder.applySettings(configuration.getProperties());
			ServiceRegistry serviceRegistry = serviceRegistryBuilder.buildServiceRegistry();
	
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
	
		return sessionFactory;
	}
	*/

	/**
	 * As of 2014, the above code is deprecated. Here’s new version of the
	 * HibernateUtil class that is up-to-date since version 4.3.x
	 * 
	 * @return SessionFactory
	 */
	/*-
	public static SessionFactory initSessionFactory() {
		if (sessionFactory == null) {
			// loads configuration and mappings
			Configuration configuration = new Configuration().configure();
			ServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();
			standardServiceRegistryBuilder.applySettings(configuration.getProperties());
			ServiceRegistry serviceRegistry = standardServiceRegistryBuilder.build();
	
			// builds a session factory from the service registry
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
	
		return sessionFactory;
	}
	*/

	/**
	 * As of version 5.x, the above code is not working. Need to replace
	 * ServiceRegistry interface with StandardServiceRegistryBuilder and used
	 * "metadatasources" to create session factory.
	 * 
	 * @return SessionFactory
	 */
	public static SessionFactory initSessionFactory() {
		if (sessionFactory == null) {
			// loads configuration and mappings
			ServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
			Metadata metadata = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
			sessionFactory = metadata.getSessionFactoryBuilder().build();
		}

		return sessionFactory;
	}
}
