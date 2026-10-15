<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Thank You</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/thankyou.css">
</head>

<body>

<div class="container">

    <h1 class="title">Thank You!</h1>

    <p class="message">Your order was placed successfully.</p>

    <c:if test="${not empty orderId}">
        <p class="info">Order ID: <strong><c:out value="${orderId}"/></strong></p>
    </c:if>

    <c:if test="${not empty method}">
        <p class="info">Payment method: <strong><c:out value="${method}"/></strong></p>
    </c:if>

    <a class="back-btn" href="${pageContext.request.contextPath}/restaurants">
        Back to Main Menu
    </a>

</div>

</body>
</html>
