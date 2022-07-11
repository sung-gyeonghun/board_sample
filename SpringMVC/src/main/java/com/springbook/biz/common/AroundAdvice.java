package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class AroundAdvice {
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		String method = pjp.getSignature().getName();
		
		StopWatch stopwatch = new StopWatch();
	
		// 사전 작업
		System.out.println(" [Before]: 비즈니스 메서드 수행 전에 처리할 내용...");
		
		stopwatch.start();		
		Object returnObj = pjp.proceed();
		stopwatch.stop();
		
		System.out.println(method +"() 메서드 수행에 걸린 시간 :"
				+ stopwatch.getTotalTimeMillis() +"(ms)초");
		// 사후 작업 			
		return returnObj;
	}

}
