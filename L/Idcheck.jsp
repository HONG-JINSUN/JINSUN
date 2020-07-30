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

String U = request.getParameter("id");
session.setAttribute("F", U);

String sql = "select pass, lev, name from EMPLOYEES where id = '" + U + "'";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");

	String A;
	String B;
	String C = request.getParameter("pwd");
	String D = request.getParameter("lv");
	String E;

	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, uid, pass);
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		while (rs.next()) {

			A = rs.getString("pass");
			B = rs.getString("lev");
			E = rs.getString("name");

			session.setAttribute("R", E);
			session.setAttribute("L", B);

			if (C.equals(A) && D.equals(B)) {

		response.sendRedirect("Main.jsp");

			}
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

	<c:import url="Login.jsp"></c:import>

</body>
</html>