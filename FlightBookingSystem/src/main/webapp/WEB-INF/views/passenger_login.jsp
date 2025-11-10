<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Passenger Login</title>
</head>
<body>

<h2>Passenger Login</h2>

<!-- Show success message after registration -->
<c:if test="${param.registered eq 'true'}">
    <p style="color:green;">Account created successfully! Please login.</p>
</c:if>

<!-- Show error message if login failed -->
<c:if test="${not empty error}">
    <p style="color:red;">${error}</p>
</c:if>

<form:form modelAttribute="passenger" action="login" method="post">
    Username: <form:input path="passengerUsername"/><br/><br/>
    Password: <form:password path="passengerPassword"/><br/><br/>
    <input type="submit" value="Login"/>
</form:form>

<p>Don't have an account? <a href="register">Register here</a></p>

</body>
</html>
