package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;

public class AfterThrowingAdvice {
	public void exceptionLog(JoinPoint jp, Exception execeptObj) {
		String method = jp.getSignature().getName();
		
		System.out.println("[����ó�� ] "
				+ method+"() �޼��� ������  ���ܸ޽���"+execeptObj.getMessage());
	}

}
