<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Thank You</title></head>
<body>
<h1>Thank you</h1>

<p>Your order was placed successfully.</p>

<c:if test="${not empty orderId}">
    <p>Order ID: <strong>${orderId}</strong></p>
</c:if>

<c:if test="${not empty method}">
    <p>Payment method: <strong>${method}</strong></p>
</c:if>

<p><a href="${pageContext.request.contextPath}/restaurants">Back to Main Menu</a></p>
</body>
</html>
