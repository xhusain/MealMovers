<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Restaurants</title>
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/restaurants.css">
</head>

<body>

<header class="page-header">
    <h1>Available Restaurants</h1>
</header>

<section class="restaurant-list">

    <c:if test="${empty restaurants}">
        <div class="empty-message">
            <p>No restaurants found.</p>
        </div>
    </c:if>

    <c:forEach var="r" items="${restaurants}">
        <article class="restaurant-card">

            <h2><c:out value="${r.name}"/></h2>

            <div class="details">
                <p><strong>Address:</strong> <c:out value="${r.address}"/></p>
                <p><strong>Phone:</strong> <c:out value="${r.phone}"/></p>
            </div>

            <div class="menu-button">
                <a href="${pageContext.request.contextPath}/restaurants/${r.restaurantId}/menu">View Menu</a>
            </div>

        </article>
    </c:forEach>

</section>

<footer class="footer">
    <a href="${pageContext.request.contextPath}/">Home</a>
</footer>

</body>
</html>
