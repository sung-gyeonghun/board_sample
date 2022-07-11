<%@page import="java.util.List"%>
<%@page import="com.springbook.biz.board.impl.BoardDAO"%>
<%@page import="com.springbook.biz.board.BoardVO"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
<link rel="stylesheet" href="css/contents.css">
<style>
#content {
	width: 700px;
	margin: 50px auto;
}

.search {
	margin: 10px 5px;
	font-size: 1em;
	padding: 5px;
}

td {
	padding: 5px;
}

.seq{
	width: 40px;
	text-align: right;
	padding-right: 10px;
}
.title {
	width: 350px;
}

.cnt {
	width: 40px;
	text-align: center;
}
h1 { text-align: center;}
</style>
</head>
<body>
<div id="content">
	<h1>게시판 글 목록</h1>
	<h3>${userName}님 환영합니다...<a href="logout.do">로그아웃</a></h3>
	
	<!-- 검색 기능 -->
	<form action="getBoardList.do" method="post">
		<table id="table_content">
			<tr>
				<th>
					<select name="searchCondition">
						<c:forEach items="${conditionMap}" var="option">
								<option value="${option.value}">${option.key}
						</c:forEach>
					</select> 
					<input class="search" type="text" name="searchKeyword" />
					<input class="search" type="submit" value="검색" />					
				</th>
			</tr>			
		</table>
	</form>
	<!--  검색기능  종료 -->
	<!-- 게시판 출력 시작 -->
	<table id="table_content">
		<tr>
			<th bgcolor="orange">번호</th>
			<th bgcolor="orange" width="100">제목</th>
			<th bgcolor="orange" width="100">작성자</th>
			<th bgcolor="orange" width="100">등록일</th>
			<th bgcolor="orange" >조회수</th>
		</tr>
		<c:forEach items="${boardList}" var="board">
			<tr>
				<td class="seq">${board.seq}</td>
				<td class="title"><a href="getBoard.do?seq=${board.seq}">${board.title}</a></td>
				<td>${board.writer}</td>
				<td>${board.regDate}</td>
				<td class="cnt">${board.cnt}</td>			
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="insertBoard.jsp">새글 등록</a>
</div>
</body>
</html>