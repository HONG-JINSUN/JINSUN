<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- CSS only -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">

<!-- JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
	integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
	crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="param.js"></script>
</head>
<body>
	<form method="get" action="All" name="frm">
		<p class="bg-warning text-white font-italic">
			이름 : <input type="text" name="name"><br> 주민등록번호 : <input
				type="text" name="inumber"> - <input type="text"
				name="inumber2"><br> 아이디 : <input type="text" name="id"><br>
			비밀번호 : <input type="text" name="pwd"> <br> 비밀번호 확인 : <input
				type="text" name="pwd2"> <br> 이메일 : <input type="text"
				name="email"> @ <input type="text" name="email2"><span
				style="float:; margin-right: 20px"> <label for="email"></label>
				<select id="job" name="job" size="1">
					<option value="직접입력">직접입력</option>
					<option value="nate.com">nate.com</option>
					<option value="naver.com">naver.com</option>
					<option value="daum.net">daum.net</option>
					<option value="google.com">google.com</option>
			</select></span><br> 우편번호 : <input type="text" name="anumber"> <br>
			주소 : <input type="text" name="add"> <input type="text"
				name="add2"><br> 핸드폰번호 : <input type="text"
				name="pnumber"> <br> <label for="job2">직업</label> <select
				id="job2" name="job2" size="1">
				<option value="">선택하세요.</option>
				<option value="학생">학생</option>
				<option value="컴퓨터/인터넷">컴퓨터/인터넷</option>
				<option value="언론">언론</option>
				<option value="공무원">공무원</option>
				<option value="군인">군인</option>
				<option value="서비스업">서비스업</option>
				<option value="교육">교육</option>
			</select><br> <label for="chk_mail"> 메일/SMS 정보 수신 </label> <input
				type="radio" id="chk_mail" name="chk_mail" value="yes" checked>
			수신 <input type="radio" id="chk_mail" name="chk_mail" value="no">
			거부 <br> 관심분야<input type="checkbox" name="interest" value="생두">
			생두 <input type="checkbox" name="interest" value="원두"> 원두 <input
				type="checkbox" name="interest" value="로스팅"> 로스팅 <input
				type="checkbox" name="interest" value="핸드드립"> 핸드드립 <input
				type="checkbox" name="interest" value="에스프레소"> 에소프레소 <input
				type="checkbox" name="interest" value="창업"> 창업<br> <input
				type="submit" value="회원가입" onclick="return check()"> <input
				type="button" value="취소">
		</p>
	</form>
</body>
</html>