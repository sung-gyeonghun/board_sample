<%@page import="com.springbook.biz.board.impl.BoardDAO"%>
<%@page import="com.springbook.biz.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세 보기</title>
<link rel="stylesheet" href="css/contents.css">
<style>

#content {
	width: 600px;
	margin: 50px auto;
	padding: 10px;
}


#table_content td:nth-child(odd) {
	background-color: #adad85;
}

#table_content > tbody > tr:last-child > td {
	background-color: #ccccb3;
}

</style>
</head>
<body>
	<div id="content">
		<h1>글 상세 보기</h1>
		<a href="logout.do">Log-out</a></br></br>
		<form action="updateBoard.do" method="post">
			<input name="seq" type="hidden" value="${board.seq}" />
			<table id="table_content">
				<tr>
					<td>제목</td>
					<td align="left"><input name="title" type="text"
						value="${board.title}" /></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td align="left">${board.writer}</td>
				</tr>
				<tr>
					<td>내용</td>
					<td align="left"><textarea name="content" cols="40" rows="10">
						${board.content}</textarea></td>
				</tr>
				<tr>
					<td bgcolor="orange">등록일</td>
					<td align="left">${board.regDate}</td>
				</tr>
				<tr>
					<td bgcolor="orange">조회수</td>
					<td align="left">${board.cnt}</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="글 수정" /></td>
				</tr>
			</table>
		</form></br>
		<a href="insertBoard.jsp">글등록</a>&nbsp;&nbsp;&nbsp; <a
			href="deleteBoard.do?seq=${board.seq}">글삭제</a>&nbsp;&nbsp;&nbsp; <a
			href="getBoardList.do">글목록</a>
	</div>

</body>
</html>