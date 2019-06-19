package com.websystique.springmvc.configuration;


import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
public class AOP
{
	/*	@Pointcut("execution(* com.websystique.springmvc.configuration.Atom.chkData(..))")
		private void  callArround(String val) {   }
	*/
	
	    @After("execution(* Atom.DispData()) || execution(* Atom.DisplayData())")
	    public void logBeforeAllMethods()
	    {
	        System.out.println("\n\n\n ****LoggingAspect.logBeforeAllMethods() : \n\n\n ");
	    }
	  
	    
	    

	    @Around("execution(* Atom.chkData(..))")
	    public void checkValNRun(ProceedingJoinPoint obj) throws Throwable
	    {
	    	Object[] args=obj.getArgs();
	    	System.out.println("Value from the method"+args[0] );
	    	System.out.println("method Name"+obj.getClass().getName());
	    	if(args[0].toString().length()>3)
	    	obj.proceed();
	    	else
	    		System.out.println("content length should be greater than 3");
	    	
	    	
	    }
	

}
