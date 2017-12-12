<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Storyboards</title>
</head>
<body>

<h3>All your storyboards</h3>

<c:forEach var="storyboard" items="${storyboards}" varStatus="row">
    <a href="${pageContext.request.contextPath}/storyboards/${storyboard.id}">${storyboard.title}</a>
</c:forEach>

<h3>Create a storyboard</h3>
<form action="/storyboards" method="post">
    <div class="text-box app-font">
        <input placeholder="Title" type="text" id="title" name="title"/>
    </div>
    <div class="text-box app-font">
        <textarea id="description" type="text" name="description" rows="10" cols="70" placeholder="Please add storyBoard description here."></textarea>
    </div>
    <div class="text-box app-font login-button">
        <input type="submit" value="Create"/>
    </div>
</form>

</body>
</html>
