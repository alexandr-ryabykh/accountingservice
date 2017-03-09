<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="POST" modelAttribute="student">
    <div class="field">
        <label>Name:</label>
        <input type="text" name="firstName" value="${student.name}"/>
    </div>
    <div class="field">
        <label>Surname:</label>
        <input type="text" name="lastName" value="${student.surname}"/>
    </div>
    <div class="field">
        <label>Phone:</label>
        <input type="text" name="telephone" value="${student.phoneNumber}"/>
    </div>
    <div class="field">
        <label>E-mail:</label>
        <input type="text" name="email" value="${student.email}"/>
    </div>
    <input type="submit"/>
</form:form>
<form:form method="GET" action="/student/${student.id}/remove">
    <input type="submit" value="Remove"/>
</form:form>
</body>
</html>
