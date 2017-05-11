package com.bp.onlinecollaboration.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "com.bp.onlinecollaboration" })
@EnableTransactionManagement
public class HibernateConfig {

	// Datasource bean available
	private final static String DATABASE_URL = "jdbc:oracle:thin:@172.23.79.102:1521:orcl1";
	private final static String DATABASE_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.Oracle10gDialect";
	private final static String DATABASE_USERNAME = "hr";
	private final static String DATABASE_PASSWORD = "niit";
          
	
	@Bean("datasource")
	public DataSource getDataSource() {
		// providing the database connections
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName(DATABASE_DRIVER);
		datasource.setUrl(DATABASE_URL);
		datasource.setUsername(DATABASE_USERNAME);
		datasource.setPassword(DATABASE_PASSWORD);

		return datasource;
	}

	// SessionFactory bean is available
	@Bean
	public SessionFactory getSessionFactory(DataSource datasource) {

		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(datasource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.bp.onlinecollaboration.model");
		return builder.buildSessionFactory();
	}

	// Hibernate properties
	private Properties getHibernateProperties() {

		Properties properties = new Properties();
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;

	}

	// hibernate transaction bean
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {

		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
}
