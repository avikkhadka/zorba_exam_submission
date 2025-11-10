<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page isELIgnored="false" %>
<html>
<head>
    <title>All Flights</title>
</head>
<body>

<h2>Flight List</h2>

<table border="1" cellpadding="5">
    <tr>
        <th>ID</th>
        <th>Flight Type</th>
        <th>From Address</th>
        <th>Destination Address</th>
        <th>Duration</th>
        <th>Condition</th>
        <th>Actions</th>
    </tr>

    <c:forEach var="flight" items="${flights}">
        <tr>
            <td>${flight.id}</td>
            <td>${flight.flightType}</td>
            <td>${flight.flightToAddress}</td>
            <td>${flight.flightDestinationAddress}</td>
            <td>${flight.flightDuration}</td>
            <td>${flight.flightCondition}</td>
            <td>
                <a href="edit/${flight.id}">Edit</a> |
                <form action="delete/${flight.id}" method="post" style="display:inline;">
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<p><a href="registration">Register New Flight</a></p>
<p><a href="<c:url value='/passenger/logout'/>">Logout</a></p>

</body>
</html>
