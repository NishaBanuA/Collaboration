package com.myapp.Collaborate.config;

import java.util.Properties;


import javax.sql.DataSource;

import org.hibernate.SessionFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import com.myapp.Collaborate.DAO.BlogDAO;
import com.myapp.Collaborate.DAO.BlogDAOImpl;

import com.myapp.Collaborate.model.Blog;


@Configuration
@ComponentScan("com.myapp.Collaborate")
@EnableTransactionManagement
public class DbConfig {

	public DataSource getOracleDataSource()
	{
		DriverManagerDataSource driverManagerDataSource=new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		driverManagerDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE ");
		driverManagerDataSource.setUsername("nisha");
		driverManagerDataSource.setPassword("9362640108");
		
		return driverManagerDataSource;
		}
	
	public Properties getHibernateProperties()
	{
		Properties properties =new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto","update");
		properties.put("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
		
		return properties;
	}
	@Bean
	public SessionFactory getSessionFactory()
	{
		LocalSessionFactoryBuilder localSessionFactoryBuilder=new LocalSessionFactoryBuilder(getOracleDataSource());
		localSessionFactoryBuilder.addProperties(getHibernateProperties());
		localSessionFactoryBuilder.addAnnotatedClass(Blog.class);
		
		System.out.println("SessionFactory Bean Created");
		return localSessionFactoryBuilder.buildSessionFactory();
	}
	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
	{
		return new HibernateTransactionManager(sessionFactory);
	}
	@Bean
	public BlogDAO getBlogDAO(SessionFactory sessionFactory)
	{
		return new BlogDAOImpl(sessionFactory);
	}
	
	
}