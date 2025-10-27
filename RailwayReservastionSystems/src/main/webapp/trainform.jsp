<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Train Registration Form</title>
</head>
<body>
<h2>Train Registration Form</h2>

<form action="${pageContext.request.contextPath}/train/save" method="post">
    <label for="trainName">Train Name:</label><br>
    <input type="text" id="trainName" name="trainName"><br><br>

    <label for="noOfCoaches">No of Coaches:</label><br>
    <input type="number" id="noOfCoaches" name="noOfCoaches"><br><br>

    <label for="startStation">Train Start Station:</label><br>
    <input type="text" id="startStation" name="startStation"><br><br>

    <label for="endStation">Train End Station:</label><br>
    <input type="text" id="endStation" name="endStation" required><br><br>

    <label for="trainType">Train Type:</label><br>
    <select id="trainType" name="trainType" required>
        <option value="">--Select--</option>
        <option value="Local Train">Local Train</option>
        <option value="Super Fast Train">Super Fast Train</option>
        <option value="Intercity Express">Intercity Express</option>
        <option value="Goods Train">Goods Train</option>
    </select><br><br>

    <label for="avgSpeed">Average Speed (km/h):</label><br>
    <input type="number" id="avgSpeed" name="avgSpeed" min="1" required><br><br>

    <input type="submit" value="Submit">
</form>

</body>
</html>
