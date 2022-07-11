package com.springbook.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.JDBCUtil;

@Repository("boardDAO")
public class BoardDAO {
	// �Խ��ǿ� ���� ����, ����, ��ȸ, ����

	// JDBC ���� ����
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// ����� SQL ��ɾ� �غ�
	private final String BOARD_INSERT = "INSERT INTO board(seq, title, writer, content) "
			+ " VALUES ((select nvl(max(seq),0)+1 from board),?,?,?);";

	private final String BOARD_UPDATE = "UPDATE BOARD SET title=?, content=? where seq=?;";

	private final String BOARD_DELETE = "DELETE BOARD where seq=?;";

	private final String BOARD_GET = "SELECT * from BOARD where seq=?;";

	private final String BOARD_LIST = "SELECT * from BOARD order by seq desc;";

	public void insertBoard(BoardVO vo) {
		System.out.println("===>JDBC�� insertBoard() ���ó��");
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_INSERT);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
	}

	public void updateBoard(BoardVO vo) {
		System.out.println("===>JDBC�� updateBoard() ���ó��");

		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_UPDATE);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getSeq());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
	}
	
	public void deleteBoard(BoardVO vo) {
		System.out.println("===>JDBC�� deleteBoard() ���ó��");

		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_DELETE);
			pstmt.setInt(1, vo.getSeq());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
	}
	
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===>JDBC�� getBoard() ���ó��");
		BoardVO board=null;
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_GET);
			pstmt.setInt(1, vo.getSeq());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}		
		return board;		
	}
	
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===>JDBC�� getBoardList() ���ó��");
		List<BoardVO> boardList = new ArrayList<BoardVO>();		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_LIST);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
				boardList.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}		
		return boardList;		
	}


}
