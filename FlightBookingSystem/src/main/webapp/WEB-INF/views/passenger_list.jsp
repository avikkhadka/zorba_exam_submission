


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Passenger List</title>
</head>
<body>
<h2>All Passengers</h2>

<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Mobile</th>
        <th>Address</th>
        <th>Actions</th>
    </tr>

    <c:forEach var="p" items="${passengers}">
        <tr>
            <td>${p.id}</td>
            <td>${p.passengerName}</td>
            <td>${p.passengerEmail}</td>
            <td>${p.passengerMobile}</td>
            <td>${p.passengerAddress}</td>
            <td>
                <!-- Edit Link -->
                <a href="${pageContext.request.contextPath}/passenger/edit/${p.id}">Edit</a>

                <!-- Delete Form -->
                <form action="${pageContext.request.contextPath}/passenger/deletePassenger/${p.id}"
                      method="post" style="display:inline;">
                    <input type="submit" value="Delete"
                           onclick="return confirm('Are you sure you want to delete this passenger?');"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
