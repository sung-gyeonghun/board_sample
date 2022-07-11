package com.springbook.biz.user.impl;

import com.springbook.biz.user.UserVO;

public interface UserService {
	
	// 회원정보 조회
	UserVO getUser(UserVO vo);
}
