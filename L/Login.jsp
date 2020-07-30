<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="f.js"></script>
</head>
<body>
	<center>
		<c:import url="header.jsp"></c:import>
		<p>
		<p>
		<form action="Idcheck.jsp" method="post" name="frm">
			<table border="1" style="text-align: center;">
				<tr>
					<td colspan="2">로그인</td>
				</tr>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pwd"></td>
				</tr>
				<tr>
					<td>레벨</td>
					<td><select name="lv">
							<option value="A">일반회원</option>
							<option value="B">관리자</option>
					</select></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="로그인"
						onclick="return loginCheck()"> <input type="reset"
						value="취소"></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>