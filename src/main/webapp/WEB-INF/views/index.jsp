<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" scope="request" value="Home"/>
<%@ include file="header.jsp" %>

<c:out value="${message}"/>

<ul>
    <c:forEach var="user" items="${users}" varStatus="row">
        <li>${user.lastName}, ${user.firstName} </li>
    </c:forEach>
</ul>