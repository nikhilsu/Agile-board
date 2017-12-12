<a href="/">Home</a>
<c:if test="${sessionScope.loggedInUser == null}">
    <a href="/register">Register</a>
    <a href="/login">Login</a>
</c:if>
<c:if test="${sessionScope.loggedInUser != null}">
    <a href="/logout">Logout</a>
</c:if>
