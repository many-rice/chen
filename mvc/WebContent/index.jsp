<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="com.ct.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="query.do" method="post">
		<table>
			<tr>
				<td>CustomerName:</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><input type="text" name="address"></td>
			</tr>
			<tr>
				<td>Phone:</td>
				<td><input type="text" name="phone"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Query"></td>
				<td><a href="newcustomer.jsp">Create New Customer</td>
			</tr>
		</table>
	</form>
	
	<br><br>
	
	<table border="1" >
		<tr>
			<td>ID</td>
			<td>姓名</td>
			<td>地址</td>
			<td>电话</td>
		</tr>
		<%
			List<Customer> customers=(List)request.getAttribute("customers");
			if(customers!=null &&customers.size()>0) {
				for(Customer i:customers){
		%>
				<tr>
					<td><%=i.getId() %></td>
					<td><%=i.getName() %></td>
					<td><%=i.getAddress() %></td>
					<td><%=i.getPhone() %></td>
					<td><a href="edit.do?id=<%=i.getId()%>">update</a></td>
					<td><a href="delete.do?id=<%=i.getId()%>">delete</a></td>
				</tr>
		<%
				}
			}
		%>
	</table>
	
</body>
</html>