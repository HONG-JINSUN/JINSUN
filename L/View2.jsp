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
String sql = "select * from employees where id = '" + session.getAttribute("H") + "'";
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
		<table style="text-align: center;">
			<%
				try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection(url, uid, pass);
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					out.println("<tr>");
					out.println("<td colspan = '2'>사원정보<p>회원등록에 성공했습니다.</td>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<td>아이디</td>");
					out.println("<td>" + rs.getString("id") + "</td>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<td>비밀번호</td>");
					out.println("<td>" + rs.getString("pass") + "</td>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<td>이름</td>");
					out.println("<td>" + rs.getString("name") + "</td>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<td>권한</td>");
					out.println("<td>" + rs.getString("lev") + "</td>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<td>성별</td>");

					String A = rs.getString("gender");

					if (A.equals("1")) {

				A = "남성";
					} else {

				A = "여성";

					}

					out.println("<td>" + A + "</td>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<td>전화번호</td>");
					out.println("<td>" + rs.getString("phone") + "</td>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<td colspan = '2'><input type = 'submit' value = '메인페이지로 이동' onclick = "
					+ "\"location.href= 'Main.jsp'\"" + "></th>");
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
	</center>
</body>
</html>