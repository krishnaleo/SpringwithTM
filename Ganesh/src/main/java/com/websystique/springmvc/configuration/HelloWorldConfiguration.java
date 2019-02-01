package com.websystique.springmvc.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableAspectJAutoProxy
@EnableWebMvc
@ComponentScan(basePackages = "com.websystique.springmvc")
public class HelloWorldConfiguration 
{
	
	
	@Bean(name="atom")
	Atom atomValues()
	{
		return new Atom("Ganesh","Murugan");
		
	}

	@Bean
	public DataSource setdataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

	    dataSource.setDriverClassName("net.sourceforge.jtds.jdbc.Driver");
	    dataSource.setUrl("jdbc:jtds:sqlserver://localhost:1433");
	    dataSource.setUsername("evolve");
	    dataSource.setPassword("evolve@123");
	  
	    return dataSource;
	}
	
	
	 @Bean
	  public PlatformTransactionManager txManager() 
	  {
	         return new DataSourceTransactionManager(setdataSource());
	  }
}