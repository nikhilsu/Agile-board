<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Storyboard</title>
</head>
<body>
<h3>${storyboard.title}</h3>

<h3>All you swimlanes</h3>
<c:forEach var="swimlane" items="${storyboard.swimlanes}" varStatus="row">
    <p>${swimlane.name}</p>
</c:forEach>

<h3>Add swimlane</h3>
<form action="/storyboards/${storyboard.id}/swimlanes" method="post">
    <div class="text-box app-font">
        <input placeholder="Name" type="text" id="name" name="name"/>
    </div>
    <div class="text-box app-font login-button">
        <input type="submit" value="Add"/>
    </div>
</form>


</body>
</html>
