<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Your Cart</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/cart.css">
</head>

<body>

<header class="cart-header">
    <h1>Your Cart</h1>
</header>

<main class="cart-container">

    <table class="cart-table">
        <thead>
            <tr>
                <th>Item</th>
                <th class="price-col">Price</th>
                <th class="qty-col">Quantity</th>
                <th class="subtotal-col">Subtotal</th>
                <th class="action-col">Actions</th>
            </tr>
        </thead>

        <tbody>
        <c:forEach var="item" items="${cartItems}">
            <tr>
                <td>${item.name}</td>

                <td>$${item.price}</td>

                <td>
                    <form action="${pageContext.request.contextPath}/cart/update" method="post" class="qty-form">
                        <input type="hidden" name="cartId" value="${item.cartId}">
                        <input class="qty-input" type="number" name="quantity" value="${item.quantity}" min="1">
                        <input class="update-btn" type="submit" value="Update">
                    </form>
                </td>

                <td>$${item.price * item.quantity}</td>

                <td>
                    <form action="${pageContext.request.contextPath}/cart/remove" method="post">
                        <input type="hidden" name="cartId" value="${item.cartId}">
                        <input class="remove-btn" type="submit" value="Remove">
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div class="complete-order">
        <form action="${pageContext.request.contextPath}/cart/complete" method="post">
            <button class="complete-btn" type="submit">Complete Order</button>
        </form>
    </div>

</main>

</body>
</html>
