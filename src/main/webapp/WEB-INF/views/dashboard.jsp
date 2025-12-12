<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Dashboard</title>

    <!-- Link CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/dashboard.css">


</head>

<body>
    <header class="top-header">
        <div class="welcome-box">
            <h2>Hello, <span>${username}</span></h2>
            <p class="uid">User ID, ${user_id}</p>
        </div>
    </header>

    <main class="main-content">
        <section class="info-card">
            <p>You have successfully logged in.</p>
        </section>

        <nav class="dashboard-nav">
            <ul>
                <li><a href="logout" class="btn danger">Logout</a></li>
                <li><a href="${pageContext.request.contextPath}/restaurants" class="btn primary">Browse Restaurants</a></li>
            </ul>
        </nav>
    </main>

    <footer class="footer">
        <!-- Optional footer content -->
    </footer>
</body>
</html>
