<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Register</title>
</head>
<body>

    <header>
        <h1>Register</h1>
    </header>

    <main>
        <form action="register" method="post">

            <div>
                <label>
                    Name:<br>
                    <input type="text" name="name" required>
                </label>
            </div>

            <div>
                <label>
                    Email:<br>
                    <input type="email" name="email" required>
                </label>
            </div>

            <div>
                <label>
                    Password:<br>
                    <input type="password" name="password" required>
                </label>
            </div>

            <div>
                <label>
                    Role:<br>
                    <select name="role">
                        <option value="CUSTOMER">Customer</option>
                        <option value="RESTAURANT_OWNER">Restaurant Owner</option>
                        <option value="RIDER">Rider</option>
                    </select>
                </label>
            </div>

            <div>
                <input type="submit" value="Register">
            </div>

        </form>
    </main>

</body>
</html>
