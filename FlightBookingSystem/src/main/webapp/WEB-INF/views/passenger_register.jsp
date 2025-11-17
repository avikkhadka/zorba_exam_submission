<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Passenger Registration</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <style>
        .error { color: red; font-size: 0.9em; }
    </style>
</head>
<body>

<h2>Passenger Registration Form</h2>

<form:form id="passengerForm" modelAttribute="passenger" method="post">
    Name: <form:input path="passengerName" name="passengerName"/>
    <span class="error" id="nameError"></span><br/><br/>

    Email: <form:input path="passengerEmail" name="passengerEmail"/>
    <span class="error" id="emailError"></span><br/><br/>

    Mobile: <form:input path="passengerMobile" name="passengerMobile"/>
    <span class="error" id="mobileError"></span><br/><br/>

    Address: <form:input path="passengerAddress" name="passengerAddress"/>
    <span class="error" id="addressError"></span><br/><br/>

    Username: <form:input path="passengerUsername" name="passengerUsername"/>
    <span class="error" id="usernameError"></span><br/><br/>

    Password: <form:password path="passengerPassword" name="passengerPassword"/>
    <span class="error" id="passwordError"></span><br/><br/>

    <input type="submit" value="Register"/>
</form:form>

<p>Already have an account? <a href="<c:url value='/passenger/login'/>">Login here</a></p>

<script src="<c:url value='/resources/js/passengerRegistration.js' />"></script>

</body>
</html>
