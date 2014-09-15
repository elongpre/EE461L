<%@ page import="examresult.entity.*" %>
<html>  
	<head>   
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
  		<title>Exam Results</title>  
  	</head>  
  	<body>   
  		<h1>Welcome to your exam results!</h1>
  		<hr/>   
  		<%
  		ExamResult result = (ExamResult)session.getAttribute("result");   
  		if (result != null){   
  		%>   
  		<table>    
  			<tr>
    			<td style="font-weight:bold;">ID Number:</td>
    			<td><%=result.getIdNumber().getName() %></td>  
    		</tr>   
    		<tr>
    			<td style="font-weight:bold;">Name:</td>
    			<td><%=result.getName() %></td>  
    		</tr>   
    		<tr>
    			<td style="font-weight:bold;">Grade 1:</td>
    			<td><%=result.getGrade1() %></td>  
    		</tr>   
    		<tr>
    			<td style="font-weight:bold;">Grade 2:</td>
    			<td><%=result.getGrade2() %></td>  
    		</tr>   
    	</table>   
    	<%} else {%>   
  		<h3>We could not provide you with any results.</h3>   
  		<% } %>   
  		<hr/>
  		<a href="index.html">Back to Home</a>
 	</body> 
</html> 