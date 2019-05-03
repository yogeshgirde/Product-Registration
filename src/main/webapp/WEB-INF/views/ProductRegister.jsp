<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
||<a href="all">View All</a> || <a href="../logout">Logout</a>||
<hr/>
<h3>Welcome to Product Register Page</h3>
<form:form action="save" method="post" modelAttribute="product">
<pre>
 CODE : <form:input path="prodCode"/>
 NAME : <form:input path="prodName"/>
 TYPE : <form:select path="prodType">
 			<form:option value="">-SELECT-</form:option>
 			<form:option value="BRAND">BRAND</form:option>
 			<form:option value="NORMAL">NORMAL</form:option>
 			<form:option value="SIMPLE">SIMPLE</form:option>
 	   </form:select>
 COST : <form:input path="prodCost"/>
 <input type="submit" value="Register"/> 	   
</pre>
</form:form>
${message }
</body>
</html>