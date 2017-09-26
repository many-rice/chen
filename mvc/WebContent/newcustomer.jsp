<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		System.out.println(request.getAttribute("message"));
	%>
	<%=request.getParameter("message") == null ? "":request.getAttribute("message") %>
	<form action="add.do" method="post">
		<table>
			<tr>
				<td>id:</td>
				<td><input type="text" name="id" value="<%=request.getAttribute("id") %>"></td>
			</tr>
			<tr>
				<td>CustomerName:</td>
				<td><input type="text" name="name"  value="<%= request.getAttribute("name") == null ?"" :request.getAttribute("name")%>"></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><input type="text" name="address"   value="<%=request.getAttribute("address")==null? "":request.getAttribute("address") %>"></td>
			</tr>
			<tr>
				<td>Phone:</td>
				<td><input type="text" name="phone" value="<%=request.getAttribute("phone")==null? "":request.getAttribute("phone") %>" ></td>
			</tr>
			<tr>
				<td><input type="submit" value="Query"></td>
			</tr>
		</table>
	</form>
</body>
</html>