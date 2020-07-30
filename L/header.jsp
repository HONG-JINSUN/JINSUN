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


	<%
		if (session.getAttribute("L") == null) {

		out.println("<table width='1000' border = '1'>");
		out.println("<tr>");
		out.println("<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>");
		out.println("<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>");
		out.println("<th><input type = 'button' value = '로그인' onclick = " + "\"location.href = 'Login.jsp'\"" + "></th>");
		out.println("<th>사원등록<p>관리자 로그인 후 사용가능</th>");
		out.println("<th>마이페이지<p>로그인 후 사용가능</th>");
		out.println("</tr>");
		out.println("</table>");

	} else if (session.getAttribute("L").equals("B")) {

		out.println("<table width='1000' border = '1'>");
		out.println("<tr>");
		out.println("<th>" + session.getAttribute("R") + "님 안녕하세요 </th>");
		out.println("<th> 레벨 : " + session.getAttribute("L"));
		out.println("<th><input type = 'button' value = '로그아웃' onclick = " + "\"location.href = 'Logout.jsp'\"" + "></th>");
		out.println("<th><input type = 'button' value = '사원등록' onclick = " + "\"location.href= 'Join.jsp'\"" + "></th>");
		out.println(
		"<th><input type = 'button' value = '마이페이지' onclick = " + "\"location.href= 'Revise.jsp' \"" + "></th>");
		out.println("</tr>");
		out.println("</table>");

	} else if (session.getAttribute("L").equals("A")) {

		out.println("<table width='1000' border = '1'>");
		out.println("<tr>");
		out.println("<th>" + session.getAttribute("R") + "님 안녕하세요 </th>");
		out.println("<th> 레벨 : " + session.getAttribute("L"));
		out.println("<th><input type = 'button' value = '로그아웃' onclick = " + "\"location.href = 'Logout.jsp'\"" + "></th>");
		out.println("<th>사원등록<p>( 관리자로 로그인 후 사용가능 )</th>");
		out.println("<th><input type = 'button' value = '마이페이지' onclick = " + "\"location.href= 'Revise.jsp'\"" + "></th>");
		out.println("</tr>");
		out.println("</table>");

	}
	%>

</body>
</html>