<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Menu</title>
</head>
<body>

    <!-- Restaurant Details -->
    <header>
        <h1>
            Menu for <c:out value="${restaurant.name}"/>
        </h1>

        <p>
            <strong>Address:</strong>
            <c:out value="${restaurant.address}"/>
        </p>

        <p>
            <strong>Phone:</strong>
            <c:out value="${restaurant.phone}"/>
        </p>

        <p>
            <a href="${pageContext.request.contextPath}/restaurants">
                Back to Restaurants
            </a>
        </p>
    </header>

    <!-- Menu Items -->
    <main>
        <h2>Menu</h2>

        <table border="1" cellspacing="0" cellpadding="6">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Price</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach var="item" items="${menuItems}">
                    <tr>
                        <td><c:out value="${item.name}"/></td>
                        <td><c:out value="${item.description}"/></td>
                        <td><c:out value="${item.price}"/></td>

                        <td>
                            <form action="${pageContext.request.contextPath}/cart/add" method="post">
                                <input type="hidden" name="menuId" value="${item.menuId}">
                                <input type="hidden" name="restaurantId" value="${restaurant.restaurantId}"/>

                                
                                <label>
                                    Qty:
                                    <input type="number" name="quantity" value="1" min="1">
                                </label>

                                <input type="submit" value="Add to Cart">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </main>

</body>
</html>
