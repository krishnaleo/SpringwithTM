package com.websystique.springmvc.configuration;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AOP
{

	    @Before("Atom.insertData()")
	    public void logBeforeAllMethods()
	    {
	        System.out.println("\n\n\n ****LoggingAspect.logBeforeAllMethods() : \n\n\n ");
	    }
	
}
