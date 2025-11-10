<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Edit Passenger</title>
</head>
<body>
<h2>Edit Passenger</h2>

<c:url value="/passenger/updatePassengerInfo" var="updateUrl"/>

<form:form modelAttribute="passenger"
           action="${updateUrl}"
           method="post">
    <form:hidden path="id"/>
    Name: <form:input path="passengerName"/><br/><br/>
    Email: <form:input path="passengerEmail"/><br/><br/>
    Mobile: <form:input path="passengerMobile"/><br/><br/>
    Address: <form:input path="passengerAddress"/><br/><br/>
    <input type="submit" value="Update"/>
</form:form>

</body>
</html>
