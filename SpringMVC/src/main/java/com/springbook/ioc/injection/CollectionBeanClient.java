package com.springbook.ioc.injection;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import polymorphism.TV;

public class CollectionBeanClient {

	public static void main(String[] args) {
		
		// 1. Spring �����̳ʸ� �����Ѵ�.
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");

		// 2. Spring �����̳ʷκ��� �ʿ��� ��ü�� ��û(Lookup)�Ѵ�.
		CollectionBean bean = (CollectionBean) factory.getBean("collectionBean");
		List<String> addressList = bean.getAddress();
		for(String address : addressList) {
			System.out.println(address.toString());
		}
		
		factory.close();

	}

}
