<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%!

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String uid = "system";
	String pass = "kosea2019a";
	String sql = "SELECT DISTINCT m.CUSTNO, CUSTNAME, GRADE, sum(m2.PRICE) FROM system.MEMBER_TBL_02 m, system.MONEY_TBL_02 m2 WHERE m.CUSTNO = m2.CUSTNO GROUP BY m.CUSTNO, custname, GRADE ORDER BY sum(m2.PRICE) desc";%>

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
		<h2>회원매출조회</h2>
		<table width="800" border="1">

		<tr>
			<th>회원번호</th>
			<th>회원성명</th>
			<th>고객등급</th>
			<th>매출</th>
		</tr>
		<%
			try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, uid, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				out.println("<tr>");
				out.println("<td>" + rs.getInt("custno") + "</td>");
				out.println("<td>" + rs.getString("custname") + "</td>");
				out.println("<td>" + rs.getString("grade") + "</td>");
				out.println("<td>" + rs.getInt("sum(m2.price)") + "</td>");
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