package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class AroundAdvice {
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		String method = pjp.getSignature().getName();
		
		StopWatch stopwatch = new StopWatch();
	
		// ���� �۾�
		System.out.println(" [Before]: ����Ͻ� �޼��� ���� ���� ó���� ����...");
		
		stopwatch.start();		
		Object returnObj = pjp.proceed();
		stopwatch.stop();
		
		System.out.println(method +"() �޼��� ���࿡ �ɸ� �ð� :"
				+ stopwatch.getTotalTimeMillis() +"(ms)��");
		// ���� �۾� 			
		return returnObj;
	}

}