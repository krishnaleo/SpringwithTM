package com.websystique.springmvc.configuration;


import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
public class AOP
{

	    @After("execution(* Atom.DispData()) || execution(* Atom.DisplayData())")
	    public void logBeforeAllMethods()
	    {
	        System.out.println("\n\n\n ****LoggingAspect.logBeforeAllMethods() : \n\n\n ");
	    }
	
	
	

}
