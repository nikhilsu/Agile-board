<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang = "en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Page</title>
</head>
<%@include file="header.jsp" %>
<body class="app-color">

    <hr>
            <h1 class="color-white text-center app-font" align = "center"> Welcome to Prorg</h1>
            <div class = " text-center division-login" align = "center">
                 <a href="/login" class="button-home login-button text-box"><input type="submit" value="Login"/ style="margin-left: 90%"></a>
            </div>
            <div class = "text-center division-register">
                 <a href="/register" class= "button-home login-button"><input type="submit" value="Register" style="margin-left: 90%"/></a>
            </div>
    </div>


    <%--<div class="image-home"><img src="images/home.jpg" align="right" ></div>--%>
</body>
</html>