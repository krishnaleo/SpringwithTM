package com.websystique.springmvc.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.websystique.springmvc.configuration.AOP;
import com.websystique.springmvc.configuration.Atom;


@RestController
public class HelloWorldRestController 
{

	@Autowired
	Atom atom;
	

	@SuppressWarnings("unused")
	@RequestMapping("/")
	public String welcome() throws Exception 
	{
		
		System.out.println(atom.org);
		System.out.println(atom.name);
		atom.insertData();
		if(true)
		{
		 throw new Exception();
		}
		return "Welcome to RestTemplate Example.";
	}

	/*@RequestMapping("/hello/{player}")
	public Message message(@PathVariable String player) 
	{
		//REST Endpoint.

		Message msg = new Message(player, "Hello " + player);
		return msg;
	}*/
	
	
	@ExceptionHandler(Exception.class)
	public String handleEmployeeNotFoundException(HttpServletRequest request, Exception ex)
	{
	   
	    return ex+" Custom exception";
	}

	
}
