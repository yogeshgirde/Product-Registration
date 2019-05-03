<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.error{
	color: red;
}
.success{
	color: green;
}
</style>
</head>
<body>
<form name="f" action="login" method="post"> 
<pre>
 	<c:if test="${param.error != null}">          
    <div class="error">
    Invalid User name/password.
    </div>  
    </c:if>
    <c:if test="${param.logout != null}">         
    <div class="success">
    You have been logged out.
    </div>  
    </c:if>
    User Name: <input type="text" id="username" name="username"/>      
    Password:<input type="password" id="password" name="password"/>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>      
    <input type="submit" value="Login"/>  
</pre>        
</form>
</body></html>  