<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Home</title>
</head>
<body>
<c:out value="${message}"/>

<ul>
    <c:forEach var="user" items="${users}" varStatus="row">
        <li>${user.lastName}, ${user.firstName} </li>
    </c:forEach>
</ul>
</body>
</html>