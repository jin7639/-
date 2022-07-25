<%@page import="DTO.ScoreDto"%>
<%@page import="java.util.ArrayList"%>
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
	<%Dao dao = new Dao();%>
	<%@ include file="header.jsp"%>
	<h2>학생성적</h2>
	
	<table border="1">
		<tr>
			<th>학년</th><th>반</th><th>번호</th><th>이름</th><th>국어</th><th>수학</th><th>영어</th><th>역사</th><th>합계</th><th>평균</th><th>순위</th>
		</tr>
		<%ArrayList<ScoreDto> score = dao.getscorelsit(); 
			/*
			for(int i=0; i<score.size()-1; i++){
				
				for (int j=i+1; j <score.size(); j++){
					if(score.get(i).getSum() <score.get(j).getSum()){
						
					}
				}
			}
			*/
			for(ScoreDto dto : score ){
				String sno = dto.getSno();
				int sum = dto.getEkor()+dto.getEmath()+dto.getEeng()+dto.getEhist();
		
		%>
		<tr>
			<td><%=sno.substring(0, 1)%></td><td><%=sno.substring(1, 3)%></td><td><%=sno.substring(3, 5)%></td>
			<td><%=dto.getSname() %></td><td><%=dto.getEkor() %></td><td><%=dto.getEmath() %></td>
			<td><%=dto.getEeng() %></td><td><%=dto.getEhist() %></td>
			<td><%=dto.getSum()%></td><td><%=dto.getAvg() %></td><td>순위</td>
		</tr>
		<%} %>
	</table>
	
	<%@ include file="footer.jsp"%>
</body>
</html>