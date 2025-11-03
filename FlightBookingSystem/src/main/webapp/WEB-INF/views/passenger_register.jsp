<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Passenger Registration</title>
</head>
<body>
<h2>Passenger Registration Form</h2>

<form:form modelAttribute="passenger" method="post" action="">
    Name: <form:input path="passengerName"/><br/><br/>
    Email: <form:input path="passengerEmail"/><br/><br/>
    Mobile: <form:input path="passengerMobile"/><br/><br/>
    Address: <form:input path="passengerAddress"/><br/><br/>
    <input type="submit" value="Register"/>
</form:form>

</body>
</html>
