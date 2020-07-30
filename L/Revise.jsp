<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	Connection conn = null;
Statement stmt = null;
ResultSet rs = null;

String url = "jdbc:oracle:thin:@localhost:1521:orcl";
String uid = "system";
String pass = "kosea2019a";

String sql = "select * from EMPLOYEES where id = '" + session.getAttribute("F") + "'";
%>
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
		<form action="update.jsp" method="post" name="frm">
			<table style="text-align: center;">
				<%
					request.setCharacterEncoding("UTF-8");

				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					conn = DriverManager.getConnection(url, uid, pass);
					stmt = conn.createStatement();
					rs = stmt.executeQuery(sql);
					while (rs.next()) {
						out.println("<tr>");
						out.println("<td>아이디</td>");
						out.println("<td><input type='text' name='id' value = " + rs.getString("id") + " + ></td>");
						out.println("</tr>");
						out.println("<tr>");
						out.println("<td>비밀번호</td>");
						out.println("<td><input type='password' name='pwd' value = " + rs.getString("pass") + " + ></td>");
						out.println("</tr>");
						out.println("<tr>");
						out.println("<td>이름</td>");
						out.println("<td><input type='text' name='name' value = " + rs.getString("name") + " + ></td>");
						out.println("</tr>");
						out.println("<tr>");
						out.println("<td>권한</td>");

						if (rs.getString("lev").equals("A")) {

					out.println(
							"<td><select name='lv'><option value='A'>일반회원</option><option value='B'>관리자</option></select></td>");

						} else {

					out.println(
							"<td><select name='lv'><option value='B'>관리자</option><option value='A'>일반회원</option></select></td>");

						}
						out.println("</tr>");
						out.println("<td>성별</td>");

						if (rs.getString("gender").equals("1")) {

					out.println(
							"<td><select name='gender'><option value='1'>남자</option><option value='2'>여자</option></select></td>");

						} else {

					out.println(
							"<td><select name='gender'><option value='2'>여자</option><option value='1'>남자</option></select></td>");

						}
						out.println("</tr>");
						out.println("<td>전화번호</td>");
						out.println("<td><input type='text' name='phone' value = " + rs.getString("phone") + " + ></td>");
						out.println("</tr>");

						out.println("</tr>");
						out.println("<td colspan = '2'><input type = 'submit' value = '수정'><input type = 'reset' value = '취소'></td>");
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
			</table>
		</form>
	</center>
</body>
</html>