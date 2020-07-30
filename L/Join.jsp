<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<c:import url="header.jsp"></c:import>
		<p>
		<p>
		<form action="Update2.jsp" method="post" name="frm">
			<table style="text-align: center;">
				<tr>
					<td colspan="2">사원등록</td>
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
					<td>이름</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>권한</td>
					<td><select name="lv">
							<option value="A">일반회원</option>
							<option value="B">관리자</option>
					</select></td>
				</tr>
				<tr>
					<td>성별</td>
					<td><select name="gender">
							<option value="1">남자</option>
							<option value="2">여자</option>
					</select></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" name="phone"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="등록"><input
						type="reset" value="취소"></td>
				</tr>

			</table>
		</form>
	</center>
</body>
</html>