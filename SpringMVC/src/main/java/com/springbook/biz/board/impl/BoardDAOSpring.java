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
	// �Խ��ǿ� ���� ����, ����, ��ȸ, ����

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// ����� SQL ��ɾ� �غ�
	private final String BOARD_INSERT = "INSERT INTO board(seq, title, writer, content) "
			+ " VALUES ((select nvl(max(seq),0)+1 from board),?,?,?);";

	private final String BOARD_UPDATE = "UPDATE BOARD SET title=?, content=? where seq=?;";

	private final String BOARD_DELETE = "DELETE BOARD where seq=?;";

	private final String BOARD_GET = "SELECT * from BOARD where seq=?;";

	private final String BOARD_LIST = "SELECT * from BOARD order by seq desc;";

	public void insertBoard(BoardVO vo) {
		System.out.println("===>Spring JDBC�� insertBoard() ���ó��");
		jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
	}

	public void updateBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC�� updateBoard() ���ó��");
		jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	}

	public void deleteBoard(BoardVO vo) {
		System.out.println("===>Spring JDBC�� deleteBoard() ���ó��");
		jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
	}

	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===>Spring JDBC�� getBoard() ���ó��");
		Object[] args = { vo.getSeq() };
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());

	}

	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===>Spring JDBC�� getBoardList() ���ó��");
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
