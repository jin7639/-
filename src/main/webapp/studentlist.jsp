<%@page import="DTO.StudentDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style type="text/css">
		td{
			text-align: center;
			
		}
	</style>
</head>
<body>
	<%
	Dao dao = new Dao();
	%>
	<%@ include file="header.jsp"%>
	<h2>학생목록</h2>
	<table border="1">
		<tr>
			<th>학번</th><th>이름</th><th>학년</th><th>반</th><th>번호</th><th>성별</th><th>전화번호</th><th>주소</th>
		</tr>
		
		<%ArrayList<StudentDto> slist = dao.getlist();
					for(StudentDto student : slist){
						String sno = student.getSno();
						String sgender = student.getSgender();
						if(sgender.equals("M")){
							sgender = "남";
						}else {
							sgender = "여";
						}
					String 성별 = student.getSgender().equals("M") ?"남" : "여";
		%>
		
		<tr>
			<td><%=student.getSno() %></td><td><%=student.getSname() %></td><td><%=sno.substring(0, 1)%></td><td><%=sno.substring(1, 3)%></td><td><%=sno.substring(3, 5)%></td><td><%=sgender %></td><td><%=student.getSphone() %></td><td><%=student.getSaddress() %></td>
		<tr>
		<%} %>
	</table>
	
	<%@ include file="footer.jsp"%>
</body>
</html>