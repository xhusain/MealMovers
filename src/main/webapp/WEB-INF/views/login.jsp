<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/login.css">
</head>

<body>

<div class="form-container">

    <h1 class="title">Login</h1>

    <form action="login" method="post" class="login-form">

        <label class="input-label">
            Email
            <input type="email" name="email" required>
        </label>

        <label class="input-label">
            Password
            <input type="password" name="password" required>
        </label>

        <button class="submit-btn" type="submit">Login</button>

    </form>

    <p class="register-link">
        Don't have an account?
        <a href="${pageContext.request.contextPath}/register">Register</a>
    </p>

</div>

</body>
</html>
