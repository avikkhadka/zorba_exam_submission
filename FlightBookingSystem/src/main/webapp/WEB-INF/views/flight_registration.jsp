<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Flight Registration</title>
</head>
<body>

<h2>Flight Registration Form</h2>

<form:form modelAttribute="flight" action="saveFlight" method="post">
    Flight Type: <form:input path="flightType"/><br/><br/>
    Flight From (To Address): <form:input path="flightToAddress"/><br/><br/>
    Flight Destination Address: <form:input path="flightDestinationAddress"/><br/><br/>
    Flight Duration: <form:input path="flightDuration"/><br/><br/>
    Flight Condition: <form:input path="flightCondition"/><br/><br/>
    <input type="submit" value="Register Flight"/>
</form:form>

<p><a href="list">View All Flights</a></p>
<p><a href="<c:url value='/passenger/logout'/>">Logout</a></p>

</body>
</html>
