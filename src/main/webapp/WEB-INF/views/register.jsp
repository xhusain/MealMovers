<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/register.css">
</head>

<body>

<div class="form-container">

    <h1 class="title">Create Account</h1>

    <form action="register" method="post" class="register-form">

        <label class="input-label">
            Name
            <input type="text" name="name" required>
        </label>

        <label class="input-label">
            Email
            <input type="email" name="email" required>
        </label>

        <label class="input-label">
            Password
            <input type="password" name="password" required>
        </label>

        <label class="input-label">
            Role
            <select name="role">
                <option value="CUSTOMER">Customer</option>
                <option value="RESTAURANT_OWNER">Restaurant Owner</option>
                <option value="RIDER">Rider</option>
            </select>
        </label>

        <button class="submit-btn" type="submit">Register</button>

    </form>

    <p class="login-link">
        Already have an account? 
        <a href="${pageContext.request.contextPath}/login">Login</a>
    </p>

</div>

</body>
</html>
