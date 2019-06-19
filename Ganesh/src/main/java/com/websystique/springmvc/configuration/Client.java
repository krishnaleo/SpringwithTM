package com.websystique.springmvc.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Client
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		ApplicationContext context=new AnnotationConfigApplicationContext(Test.class);
		
		Atom obj=(Atom) context.getBean("testing");
		
		obj.DispData();
		obj.chkData("Ture");
		
	//	obj.annotationbaedTM();
		
	}

}
