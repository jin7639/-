<%@page import="DAO.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		function scoresave() {
			if(document.exam.sno.value == ""){
				alert("학생번호가 입력되지 않았습니다.");
				document.exam.sno.focus();
				return false;
			}
			if(document.exam.ekor.value == ""){
				alert("국어점수가 입력되지 않았습니다.");
				document.exam.ekor.focus();
				return false;
			}
			if(document.exam.emath.value == ""){
				alert("수학점수가 입력되지 않았습니다.");
				document.exam.emath.focus();
				return false;
			}
			if(document.exam.eeng.value == ""){
				alert("영어점수가 입력되지 않았습니다.");
				document.exam.eeng.focus();
				return false;
			}
			if(document.exam.ehist.value == ""){
				alert("역사점수가 입력되지 않았습니다.");
				document.exam.ehist.focus();
				return false;
			}
			alert("학생성적이 모두 입력되었습니다.");
			document.exam.submit();
		}
	</script>
	<%Dao dao = new Dao();%>
	<%@ include file="header.jsp"%>
	<h2>성적입력</h2>
	<form action="formsave.jsp" name= "exam" method="post">
		<table border="1">
		<tr>
			<td>학번</td><td><input type="text" name="sno" id="sno"></td>
		</tr>
		<tr>
			<td>국어</td><td><input type="text" name="ekor" id="ekor"></td>
		</tr>
		<tr>
			<td>수학</td><td><input type="text" name="emath" id="emath"></td>
		</tr>
		<tr>
			<td>영어</td><td><input type="text" name="eeng" id="eeng"></td>
		</tr>
		<tr>
			<td>역사</td><td><input type="text" name="ehist" id="ehist"></td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: center"><button type="button" onclick = "scoresave()">등록하기</button></td>
		</tr>
	</table>
	</form>
	<%@ include file="footer.jsp"%>
	
</body>
</html>