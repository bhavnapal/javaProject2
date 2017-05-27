package com.niit.onlinecollaboration.config;

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
@ComponentScan(basePackages = {"com.niit.onlinecollaboration"})
@EnableTransactionManagement
public class HibernateConfig {

	/*public final static String DATABASE_URL="jdbc:oracle:thin:@172.23.79.102:1521:orcl1";
	public final static String DATABASE_DRIVER="oracle.jdbc.driver.OracleDriver";
	public final static String DATABASE_DIALECT="org.hibernate.dialect.Oracle10gDialect";
	public final static String DATABASE_USERNAME="hr";
	public final static String DATABASE_PASSWORD="niit";*/
	
	public final static String DATABASE_URL="jdbc:h2:tcp://localhost/~/test";
	public final static String DATABASE_DRIVER="org.h2.Driver";
	public final static String DATABASE_DIALECT="org.hibernate.dialect.h2Dialect";
	public final static String DATABASE_USERNAME="sa";
	public final static String DATABASE_PASSWORD="";
	
	
    @Bean(name="dataSource")
	public DataSource getDataSource(){
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
        return dataSource;
    }
	
	//SessionFactory bean
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource){
		LocalSessionFactoryBuilder sessionFactory = new LocalSessionFactoryBuilder(dataSource);
		sessionFactory.addProperties(getHibernateProperties());
		sessionFactory.scanPackages("com.niit.onlinecollaboration");
		return sessionFactory.buildSessionFactory();
	}
     
    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect",DATABASE_DIALECT);
        properties.put("hibernate.show_sql","hibernate.show_sql");
        properties.put("hibernate.format_sql","hibernate.format_sql");
        properties.put("hibernate.hbm2ddl.auto", "update");
        return properties;        
    }
     
  //Transaction Manager bean
  	@Bean
  	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory){
  		System.out.println("entering");
  		System.out.println("Session factory object"+sessionFactory);
  		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
  		return transactionManager;
  	}
	
	
	
}
