<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Your Cart</title></head>
<body>

<h1>Your Cart</h1>

<table border="1">
    <tr>
        <th>Item</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Subtotal</th>
        <th>Actions</th>
    </tr>

    <c:forEach var="item" items="${cartItems}">
        <tr>
            <td>${item.name}</td>
            <td>${item.price}</td>

            <td>
                <form action="${pageContext.request.contextPath}/cart/update" method="post">
                    <input type="hidden" name="cartId" value="${item.cartId}" />
                    <input type="number" name="quantity" value="${item.quantity}" min="1" />
                    <input type="submit" value="Update" />
                </form>
            </td>

            <td>${item.price * item.quantity}</td>

            <td>
                <form action="${pageContext.request.contextPath}/cart/remove" method="post">
                    <input type="hidden" name="cartId" value="${item.cartId}" />
                    <input type="submit" value="Remove" />
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<br>

<form action="${pageContext.request.contextPath}/cart/complete" method="post">
    <button type="submit">Complete Order</button>
</form>

</body>
</html>
