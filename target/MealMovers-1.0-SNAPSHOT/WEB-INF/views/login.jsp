<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Login</title>
</head>
<body>

    <header>
        <h1>Login</h1>
    </header>

    <main>
        <form action="login" method="post">
            <div>
                <label>Email:</label><br>
                <input type="email" name="email" required>
            </div>

            <div>
                <label>Password:</label><br>
                <input type="password" name="password" required>
            </div>

            <div>
                <input type="submit" value="Login">
            </div>
        </form>
    </main>

</body>
</html>