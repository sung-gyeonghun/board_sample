package com.springbook.biz.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.springbook.biz.common.JDBCUtil;


@Repository("userDAO")
public class UserDAO {

	// JDBC 관련 변수
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private String USER_GET =
			"SELECT * FROM USERS WHERE ID=? AND PASSWORD=?";

	// 회원정보 얻기
	public UserVO getUser(UserVO vo) {
		System.out.println("---> getUser() 기능 처리..");
		
		UserVO user = null;
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(USER_GET);
			pstmt.setString(1,vo.getId());
			pstmt.setString(2,vo.getPassword());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				user = new UserVO();
				user.setId(rs.getNString("ID"));
				user.setPassword(rs.getNString("PASSWORD"));
				user.setName(rs.getNString("NAME"));
				user.setRole(rs.getNString("ROLE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		
		return user;
		
	}
	
}
