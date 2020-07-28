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
String sql = "select * from member_tbl_02 where custno =" + request.getParameter("custno");
%>

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
		<h2>홈쇼핑 회원 수정</h2>
		<form action="update.jsp" method="post" name="frm">
			<table width="350" border="1" style="text-align: center;">
				<%
					try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					conn = DriverManager.getConnection(url, uid, pass);
					stmt = conn.createStatement();
					rs = stmt.executeQuery(sql);
					while (rs.next()) {
						out.println("<tr>");
						out.println("<td>회원번호(자동발생)</td>");
						out.println("<td><input type='text' name='custno' value = " + rs.getInt("custno") + " + ></td>");
						out.println("</tr>");
						out.println("<tr>");
						out.println("<td>회원성명</td>");
						out.println("<td><input type = 'text' name = 'custname' value = " + rs.getString("custname") + " + ></td>");
						out.println("</tr>");
						out.println("<tr>");
						out.println("<td>회원전화</td>");
						out.println("<td><input type = 'text' name = 'phone' value = " + rs.getString("phone") + " + ></td>");
						out.println("</tr>");
						out.println("<tr>");
						out.println("<td>회원주소</td>");
						out.println("<td><input type = 'text' name = 'address' value = " + rs.getString("address") + " + ></td>");
						out.println("</tr>");
						out.println("<tr>");
						out.println("<td>가입날짜</td>");
						out.println("<td><input type = 'text' name = 'joindate' value = " + rs.getString("joindate") + " + ></td>");
						out.println("</tr>");
						out.println("<tr>");
						out.println("<td>고객등급</td>");
						out.println("<td><input type = 'text' name = 'grade' value = " + rs.getString("grade") + " + ></td>");
						out.println("</tr>");
						out.println("<tr>");
						out.println("<td>도시코드</td>");
						out.println("<td><input type = 'text' name = 'city' value = " + rs.getString("city") + " + ></td>");
						out.println("</tr>");
						out.println("<tr>");
						out.println("<td colspan='2'><input type='submit' value='수 정' onclick = 'return loginCheck2()'><input type = 'reset' value = '취 소'></td>");
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

	<c:import url="footer.jsp"></c:import>
		</center>

</body>
</html>