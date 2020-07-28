<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.sql.DriverManager"%>

<%!Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String uid = "system";
	String pass = "kosea2019a";

	String sql = "select max(custno) from member_tbl_02";%>
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
	<c:import url="nav.jsp"></c:import>
		<h2>홈쇼핑 회원 등록</h2>
		<form action="add.jsp" method="post" name = "frm">
			<table border="1" style="text-align: center;">

				<%
					try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					conn = DriverManager.getConnection(url, uid, pass);
					stmt = conn.createStatement();
					rs = stmt.executeQuery(sql);
					while (rs.next()) {
						out.println("<tr>");
						out.println("<td>회원번호(자동발생)</td>");

						int A = rs.getInt("max(custno)") + 1;
						out.println("<td><input type='text' name='custno' value = " + A + " + ></td>");
						out.println("</tr>");

					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						if (rs != null)
					rs.close();
						if (stmt != null)
					stmt.close();
						if (conn != null)
					conn.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				%>
				<tr>
					<td>회원성명</td>
					<td><input type="text" name="custname"></td>
				</tr>
				<tr>
					<td>회원전화</td>
					<td><input type="text" name="phone"></td>
				</tr>
				<tr>
					<td>회원주소</td>
					<td><input type="text" name="address"></td>
				</tr>
				</tr>
				<tr>
					<td>가입일자</td>
					<td><input type="text" name="joindate"></td>
				</tr>
				<tr>
					<td>고객등급[A:VIP,B:일반,C:직원]</td>
					<td><input type="text" name="grade"></td>
				</tr>
				<tr>
					<td>도시코드</td>
					<td><input type="text" name="city"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="등 록"
						onclick="return loginCheck()"> <input type="button"
						value="조 회" onclick="location.href='search.jsp'"></td>
				</tr>
			</table>
		</form>
	<c:import url="footer.jsp"></c:import>
		</center>
</body>
</html>