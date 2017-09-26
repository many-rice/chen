<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="com.ct.Customer"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Customer customer=new Customer();
		customer.setId(1);
		String[] names={"zhangSan","liSi","wangWu","zhaoLiu"};
		pageContext.setAttribute("ns", names);
		
		Map<String,String> stu=new HashMap<String,String>();
		stu.put("chentao", "jiangsu");
		stu.put("yanghao","xian");
		stu.put("wanghongfei","shandong");
		
		pageContext.setAttribute("hs", stu);
	%>
	<c:forEach var="item" items="${hs }" varStatus="ok">
		<c:out value="key:${item.key }  value:${item.value }" /><br>
		<c:if test="${ok.first }">第一行</c:if>
		<c:if test="${ok.last} }">最后一行</c:if>
	</c:forEach>
</body>
</html>