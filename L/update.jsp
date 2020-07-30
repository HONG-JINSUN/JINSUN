<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	Connection conn = null;
PreparedStatement pstmt = null;

String url = "jdbc:oracle:thin:@localhost:1521:orcl";
String uid = "system";
String pass = "kosea2019a";

String sql = "update EMPLOYEES set pass = ?, name = ?, lev = ?, enter = sysdate, gender = ?, phone = ? where id = ?";
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

	String pwd = request.getParameter("pwd");
	String name = request.getParameter("name");
	String lev = request.getParameter("lv");
	String gender = request.getParameter("gender");
	String phone = request.getParameter("phone");
	String id = request.getParameter("id");

	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, uid, pass);
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, pwd);
		pstmt.setString(2, name);
		pstmt.setString(3, lev);
		pstmt.setString(4, gender);
		pstmt.setString(5, phone);
		pstmt.setString(6, id );
		pstmt.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if (pstmt != null)
		pstmt.close();
			if (conn != null)
		conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	%>
		<jsp:include page="View.jsp"></jsp:include>
</body>
</html>