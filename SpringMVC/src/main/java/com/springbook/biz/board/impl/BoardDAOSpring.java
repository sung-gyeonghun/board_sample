package com.springbook.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.JDBCUtil;

//@Repository("boardDAO")
@Repository
public class BoardDAOSpring {
	// 게시판에 대한 생성, 삭제, 조회, 수정

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// 사용할 SQL 명령어 준비
	private final String BOARD_INSERT = "INSERT INTO board(seq, title, writer, content) "
			+ " VALUES ((select nvl(max(seq),0)+1 from board),?,?,?);";

	private final String BOARD_UPDATE = "UPDATE BOARD SET title=?, content=? where seq=?;";

	private final String BOARD_DELETE = "DELETE BOARD where seq=?;";

	private final String BOARD_GET = "SELECT * from BOARD where seq=?;";

	private final String BOARD_LIST = "SELECT * from BOARD order by seq desc;";

	public void insertBoard(BoardVO vo) {
		System.out.println("===>Spring JDBC로 insertBoard() 기능처리");
		jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
	}

	public void updateBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC로 updateBoard() 기능처리");
		jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	}

	public void deleteBoard(BoardVO vo) {
		System.out.println("===>Spring JDBC로 deleteBoard() 기능처리");
		jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
	}

	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===>Spring JDBC로 getBoard() 기능처리");
		Object[] args = { vo.getSeq() };
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());

	}

	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===>Spring JDBC로 getBoardList() 기능처리");
		return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());

	}

	class BoardRowMapper implements RowMapper<BoardVO> {
		@Override
		public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			BoardVO board = new BoardVO();
			board.setSeq(rs.getInt("SEQ"));
			board.setTitle(rs.getString("TITLE"));
			board.setWriter(rs.getString("WRITER"));
			board.setContent(rs.getString("CONTENT"));
			board.setRegDate(rs.getDate("REGDATE"));
			board.setCnt(rs.getInt("CNT"));
			return board;
		}

	}

}
