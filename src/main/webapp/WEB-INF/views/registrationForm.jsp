This is the registration form! Register here.


<form action="${pageContext.request.contextPath}/register" method="post">
    <label for="first-name">
        First name:
    </label>
        <input type="text" id="first-name" name="firstName"/>
    <label for="last-name">
        Last name:
    </label>
    <input type="text" id="last-name" name="lastName"/>
    <label for="email">
        Email:
    </label>
    <input type="text" id="email" name="email"/>
    <label for="password">
        Password:
    </label>
    <input type="password" id="password" name="password"/>
    <label for="confirm-password">
        Confirm Password:
    </label>
    <input type="password" id="confirm-password" name="confirmPassword"/>
    <input type="submit" value="Create"/>
</form>
