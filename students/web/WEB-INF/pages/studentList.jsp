<link rel="stylesheet" href="../css/bootstrap.css">
<script src="../js/bootstrap.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Student list</title>
</head>
<body>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Phone number</th>
        <th>Email</th>
    </tr>
    <c:forEach var="student" items="${studentList}">
        <tr>
            <td><c:out value="${student.id}"/></td>
            <td><c:out value="${student.name}"/></td>
            <td><c:out value="${student.surname}"/></td>
            <td><c:out value="${student.phoneNumber}"/></td>
            <td><c:out value="${student.email}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>