<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Order Summary</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/order_summary.css">
</head>

<body>

<header class="summary-header">
    <h1>Order Summary</h1>
</header>

<main class="summary-container">

    <!-- If cart is empty -->
    <c:if test="${empty cartItems}">
        <div class="empty-cart">
            <p>Your cart is empty.</p>
            <a href="${pageContext.request.contextPath}/restaurants">Back to Restaurants</a>
        </div>
    </c:if>

    <!-- If cart has items -->
    <c:if test="${not empty cartItems}">
        
        <table class="summary-table">
            <thead>
            <tr>
                <th>Item</th>
                <th class="price-col">Price</th>
                <th class="qty-col">Quantity</th>
                <th class="subtotal-col">Subtotal</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach var="it" items="${cartItems}">
                <tr>
                    <td><c:out value="${it.name}"/></td>
                    <td>$<c:out value="${it.price}"/></td>
                    <td><c:out value="${it.quantity}"/></td>
                    <td>$<c:out value="${it.price * it.quantity}"/></td>
                </tr>
            </c:forEach>

            <tr class="total-row">
                <td colspan="3" align="right"><strong>Total:</strong></td>
                <td><strong>$<c:out value="${total}"/></strong></td>
            </tr>
            </tbody>
        </table>

        <section class="payment-section">
            <h3>Choose Payment Method</h3>

            <form action="${pageContext.request.contextPath}/order/pay" method="post">
                <input type="hidden" name="method" value="EASYPAY"/>
                <input class="pay-btn easypaisa" type="submit" value="Pay with Easypaisa"/>
            </form>

            <form action="${pageContext.request.contextPath}/order/pay" method="post">
                <input type="hidden" name="method" value="JAZZCASH"/>
                <input class="pay-btn jazzcash" type="submit" value="Pay with JazzCash"/>
            </form>

            <form action="${pageContext.request.contextPath}/order/pay" method="post">
                <input type="hidden" name="method" value="COD"/>
                <input class="pay-btn cod" type="submit" value="Cash on Delivery"/>
            </form>
        </section>

        <div class="back-cart">
            <a href="${pageContext.request.contextPath}/cart/view">Back to Cart</a>
        </div>

    </c:if>

</main>

</body>
</html>