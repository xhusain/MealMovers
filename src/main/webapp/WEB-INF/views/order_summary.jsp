<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Order Summary</title>
</head>
<body>
<h1>Order Summary</h1>

<c:if test="${empty cartItems}">
    <p>Your cart is empty. <a href="${pageContext.request.contextPath}/restaurants">Back to restaurants</a></p>
</c:if>

<c:if test="${not empty cartItems}">
    <table border="1" cellpadding="6">
        <tr><th>Item</th><th>Price</th><th>Quantity</th><th>Subtotal</th></tr>
        <c:forEach var="it" items="${cartItems}">
            <tr>
                <td>${it.name}</td>
                <td>${it.price}</td>
                <td>${it.quantity}</td>
                <td>${it.price * it.quantity}</td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="3" align="right"><strong>Total:</strong></td>
            <td><strong>${total}</strong></td>
        </tr>
    </table>

    <h3>Choose Payment Method</h3>

    <form action="${pageContext.request.contextPath}/order/pay" method="post" style="margin-bottom:8px">
        <input type="hidden" name="method" value="EASYPAY"/>
        <input type="submit" value="Pay with Easypaisa"/>
    </form>

    <form action="${pageContext.request.contextPath}/order/pay" method="post" style="margin-bottom:8px">
        <input type="hidden" name="method" value="JAZZCASH"/>
        <input type="submit" value="Pay with JazzCash"/>
    </form>

    <form action="${pageContext.request.contextPath}/order/pay" method="post" style="margin-bottom:8px">
        <input type="hidden" name="method" value="COD"/>
        <input type="submit" value="Cash on Delivery"/>
    </form>

    <p><a href="${pageContext.request.contextPath}/cart/view">Back to Cart</a></p>
</c:if>
</body>
</html>
