<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style>
#content {
	width: 300px;
	margin: 50px auto;
}
</style>
</head>
<body>
<div id="content">
<h1>로그인</h1>
<form action="login.do" method="post">
	<table>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id" value="${user.id }" /></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="password" value="${user.password }"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="로그인" />
			</td>
		</tr>
	</table>
</form>
</div>
</body>
</html>