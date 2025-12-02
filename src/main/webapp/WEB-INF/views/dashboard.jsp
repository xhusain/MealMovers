<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Dashboard</title>
</head>
<body>
    <header>
        <h1>Welcome, ${username}</h1>
        <h1>Welcome, ${user_id}</h1>
    </header>

    <main>
        <p>You have successfully logged in.</p>

        <nav>
            <ul>
                <li><a href="logout">Logout</a></li>
                <li><a href="${pageContext.request.contextPath}/restaurants">Browse Restaurants</a></li>
            </ul>
        </nav>
    </main>

    <footer>
        <!-- Optional footer content can go here -->
    </footer>
</body>
</html>
