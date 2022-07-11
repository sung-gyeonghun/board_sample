package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;

public class AfterThrowingAdvice {
	public void exceptionLog(JoinPoint jp, Exception execeptObj) {
		String method = jp.getSignature().getName();
		
		System.out.println("[예외처리 ] "
				+ method+"() 메서드 수행중  예외메시지"+execeptObj.getMessage());
	}

}
