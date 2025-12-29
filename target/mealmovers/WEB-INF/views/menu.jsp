<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menu</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/menu.css">
</head>

<body>

<header class="restaurant-header">
    <h1>Menu for <c:out value="${restaurant.name}"/></h1>

    <p><strong>Address:</strong> <c:out value="${restaurant.address}"/></p>
    <p><strong>Phone:</strong> <c:out value="${restaurant.phone}"/></p>

    <a class="back-link" href="${pageContext.request.contextPath}/restaurants">
        Back to Restaurants
    </a>
</header>

<main class="menu-section">

    <h2>Menu Items</h2>

    <table class="menu-table">
        <thead>
            <tr>
                <th>Name</th>
                <th>Description</th>
                <th class="price-col">Price</th>
                <th class="action-col">Action</th>
            </tr>
        </thead>

        <tbody>
        <c:forEach var="item" items="${menuItems}">
            <tr>
                <td class="item-name"><c:out value="${item.name}"/></td>
                <td class="item-description"><c:out value="${item.description}"/></td>
                <td class="item-price">$<c:out value="${item.price}"/></td>

                <td class="item-action">
                    <form action="${pageContext.request.contextPath}/cart/add" method="post">
                        <input type="hidden" name="menuId" value="${item.menuId}">
                        <input type="hidden" name="restaurantId" value="${restaurant.restaurantId}"/>

                        <label class="qty-label">
                            Qty:
                            <input class="qty-input" type="number" name="quantity" value="1" min="1">
                        </label>

                        <input class="add-btn" type="submit" value="Add to Cart">
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</main>

</body>
</html>
