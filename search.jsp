<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%!Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String uid = "system";
	String pass = "kosea2019a";
	String sql = "select * from member_tbl_02";%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<center>
	<c:import url="header.jsp"></c:import>
	<c:import url="nav.jsp"></c:import>


	<h2>회원정보 조회</h2>
	<table width="800" border="1">

		<tr>
			<th>회원번호</th>
			<th>회원성함</th>
			<th>전화번호</th>
			<th>회원주소</th>
			<th>가입일</th>
			<th>등급</th>
			<th>도시코드</th>
		</tr>
		<%
			try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, uid, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				out.println("<tr>");
				out.println("<td>" + "<a href='revise.jsp?custno=" + rs.getString("custno") + "'>" + rs.getString("custno"));
				out.println("<td>" + rs.getString("custname") + "</td>");
				out.println("<td>" + rs.getString("phone") + "</td>");
				out.println("<td>" + rs.getString("address") + "</td>");
				out.println("<td>" + rs.getString("joindate") + "</td>");

				String grade = rs.getString("grade");
				if (rs.getString("grade").equals("A")) {

			grade = "VIP";

				} else if (rs.getString("grade").equals("B")) {

			grade = "일반";

				} else if (rs.getString("grade").equals("C")) {

			grade = "직원";

				}
				out.println("<td>" + grade + "</td>");
				out.println("<td>" + rs.getString("city") + "</td>");
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
	<c:import url="footer.jsp"></c:import>
	</center>

</body>
</html>