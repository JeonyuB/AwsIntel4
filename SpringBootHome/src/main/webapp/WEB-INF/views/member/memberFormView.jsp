<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>회원 등록</title>

<script type="text/javascript">
function pageMoveListFnc() {
	location.href = './list';
}
</script>

</head>

<body>
	<jsp:include page="/WEB-INF/views/Header.jsp"/>
	
	<h1>회원등록</h1>
	<form action='./add' method='post'>
		이름: <input type='text' name='memberName'><br>
		이메일: <input type='text' name='email'><br>
		암호: <input type='password' name='password'><br>
		
		<input type='submit' value='추가'>
		<input type='reset' value='취소'>
		<input type="button" value="회원 목록으로 이동" onclick="pageMoveListFnc();">
	</form>
	
	<jsp:include page="/WEB-INF/views/Tail.jsp" />
</body>
</html>