<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Restaurants</title>
</head>
<body>
    <header>
        <h1 style="text-align: center; font-size: 2.5em;">Available Restaurants</h1>
    </header>

    <section>
        <c:if test="${empty restaurants}">
            <div style="text-align: center; font-size: 1.5em; color: gray;">
                <p>No restaurants found.</p>
            </div>
        </c:if>

        <c:forEach var="r" items="${restaurants}">
            <article style="border: 1px solid #ddd; border-radius: 8px; padding: 20px; margin: 20px auto; width: 80%; max-width: 600px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);">
                <h2 style="text-align: center; font-size: 2em; color: #333;"> 
                    <c:out value="${r.name}"/>
                </h2>
                <div style="font-size: 1.2em; color: #555;">
                    <p><strong>Address:</strong> <c:out value="${r.address}"/></p>
                    <p><strong>Phone:</strong> <c:out value="${r.phone}"/></p>
                    <p style="text-align: center;">
                        <a href="${pageContext.request.contextPath}/restaurants/${r.restaurantId}/menu" style="font-size: 1.1em; color: #007BFF; text-decoration: none;">View Menu</a>
                    </p>
                </div>
            </article>
        </c:forEach>
    </section>

    <footer style="text-align: center; padding: 20px; font-size: 1.2em;">
        <p><a href="${pageContext.request.contextPath}/" style="color: #007BFF; text-decoration: none;">Home</a></p>
    </footer>
</body>
</html>
