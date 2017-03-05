<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Student list</title>
</head>
<body>
<c:forEach items="${studentList}" var="studentForm">
    <c:out value="${studentForm.id}"/>
    <c:out value="${studentForm.name}"/>
    <c:out value="${studentForm.surname}"/>
    <c:out value="${studentForm.email}"/>
</c:forEach>
</body>
</html>