<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" scope="request" value="Login"/>
<%@ include file="header.jsp" %>

<form action="/login" method="post">
    <label for="email">Email(Username): </label>
    <input type="text" name="email" id="email" />
    <label for="password">Password: </label>
    <input type="password" name="password" id="password" />
    <input type="submit" value="Login" />
</form>
