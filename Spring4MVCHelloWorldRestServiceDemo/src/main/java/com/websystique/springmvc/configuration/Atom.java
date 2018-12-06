package com.websystique.springmvc.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class Atom
{

	
	public String org;
	public String name;
	
	private JdbcTemplate jdbcTemplate;
	public DataSource dataSource;
	
	
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
		
		 
	      try
	      {
		      
			String sql="insert into [Ganesh].[dbo].[delete] ([slno]) values(?)";
			
			jdbcTemplate.update(sql,new Object[] {"290124"});
			
			System.out.println("no error 1");
			
			
			
			
	      }catch(Exception e)
	      {
	    	 
	    	  System.out.println("tranction error rolled back transaction"+e);
	      }
		
	}
	
}
