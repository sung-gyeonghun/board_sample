package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;

public class BeforeAdvice {
	
	public void beforeLog(JoinPoint jp) {
		
		 String method = jp.getSignature().getName();
		 Object[] args = jp.getArgs();
		 
		 System.out.println("[����ó�� "+ method+"() �޼��� ARGS ����"+
		                     args[0].toString());		
	}
}
