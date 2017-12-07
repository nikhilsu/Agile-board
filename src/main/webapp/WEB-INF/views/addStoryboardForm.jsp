<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pageTitle" scope="request" value="Add Storyboard"/>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="css/main.css" />
    <link href="https://fonts.googleapis.com/css?family=Vollkorn+SC" rel="stylesheet">
</head>
<body class="app-color">
<div class="text-center image-logo"><img src="images/logo.png" alt="Smiley face" ></div>
<h1 class="color-white text-center app-font "> Add Storyboard Details</h1>
<div class="flex-center">

    <div class="login-box inline-flex">
        <form  class="width-full" action="${pageContext.request.contextPath}/addStoryboard" method="post">
            <div class="text-box app-font"><input placeholder="Title" type="text" id="title" name="title" /></div>
            <%--<div class="text-box app-font"><input id="description" type="text" name="description" placeholder="Please add storyboard description here." /></div>--%>
            <div class="text-box app-font"><textarea id="description" type="text" name="description" rows="10" cols="70" placeholder="Please add storyBoard description here."></textarea></div>
            <div class="text-box app-font login-button"><input type="submit" value="Save Storyboard" /></div>
        </form>
    </div>
</div>
</body>
</html>
