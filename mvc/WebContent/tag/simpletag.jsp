<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ct.Customer" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		List<Customer> customers=new ArrayList<Customer>();
	    customers.add(new Customer(1,"AA","AA","AA"));
	    customers.add(new Customer(1,"BB","BB","BB"));
	    customers.add(new Customer(1,"CC","CC","CC"));
	    customers.add(new Customer(1,"DD","DD","DD"));
	    
	    
	    request.setAttribute("customers", customers);
	%>
	<jsp:forward page="b.jsp"></jsp:forward>
</body>
</html>