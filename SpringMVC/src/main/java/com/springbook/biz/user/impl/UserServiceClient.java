package com.springbook.biz.user.impl;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.board.impl.BoardService;
import com.springbook.biz.user.UserVO;

public class UserServiceClient {

	public static void main(String[] args) {

		// 1. Spring �����̳ʸ� �����Ѵ�.
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");

		// 2. Spring �����̳ʷκ��� BoardServiceImpl ��ü�� Lookup �Ѵ�.
		UserService userService = (UserService) container.getBean("userService");

		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPassword("test123");
		
		UserVO user = userService.getUser(vo);
		if(user != null) {
			System.out.println(user.getName()+"ȯ���մϴ�.");
		}else {
			System.out.println("�α��� ����");
		}
		
		container.close();
	}

}