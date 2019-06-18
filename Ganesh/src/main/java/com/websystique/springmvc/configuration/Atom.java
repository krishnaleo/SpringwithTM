package com.websystique.springmvc.configuration;

import java.sql.SQLException;

import javax.imageio.stream.MemoryCacheImageInputStream;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class Atom
{

	
	public String org;
	public String name;
	
	private JdbcTemplate jdbcTemplate;
	public DataSource dataSource;
	
	@Autowired
	public PlatformTransactionManager transactionManager;
	
	
	public Atom(String org, String name)
	{
		this.org = org;
		this.name = name;
	}

	
	@Autowired
	public void setDataSource(DataSource dataSource) 
	{
		 this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	

	
	public void insertData()
	{
		
		TransactionDefinition def = new DefaultTransactionDefinition();
		
		
	    TransactionStatus status = transactionManager.getTransaction(def); 
		try{
		
		
	  
		      
			String sql="insert into [Ganesh].[dbo].[delete] ([slno]) values(?)";
			
			
		
				jdbcTemplate.update(sql,new Object[] {"1"});
				jdbcTemplate.update(sql,new Object[] {"2"});
				jdbcTemplate.update(sql,new Object[] {"3"});
				jdbcTemplate.update(sql,new Object[] {"4"});
		
			    transactionManager.commit(status);
			
			
			
	      }catch(Exception e)
	      {
	    	  transactionManager.rollback(status);
	    	  System.out.println("tranction error rolled back transaction"+e);
	      }
		
	}
	
	

	@Transactional(noRollbackFor=Exception.class)
	public void annotationbaedTM()
	{
		
		String sql="insert into [Ganesh].[dbo].[delete] ([slno]) values(?)";
		jdbcTemplate.update(sql,new Object[] {"1"});
		jdbcTemplate.update(sql,new Object[] {"2"});
		jdbcTemplate.update(sql,new Object[] {"xyz123aaaaaaaa"});
		jdbcTemplate.update(sql,new Object[] {"4"});

	}
	
}
