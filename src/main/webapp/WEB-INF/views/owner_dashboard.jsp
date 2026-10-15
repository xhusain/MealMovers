<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Restaurant Owner Dashboard</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/owner_dashboard.css">
</head>

<body>

<header class="dashboard-header">
    <h1>Welcome, <c:out value="${ownerName}"/></h1>
    <h3>Your Restaurant Orders</h3>
</header>

<main class="dashboard-container">

    <table class="orders-table">
        <thead>
        <tr>
            <th>Order ID</th>
            <th>Customer</th>
            <th>Total Amount</th>
            <th>Status</th>
            <th>Created At</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="order" items="${orders}">
            <tr>
                <td><c:out value="${order.orderId}"/></td>
                <td><c:out value="${order.customerName}"/></td>
                <td>$<c:out value="${order.totalAmount}"/></td>
                <td><c:out value="${order.status}"/></td>
                <td><c:out value="${order.createdAt}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div class="logout-container">
        <a class="logout-btn" href="${pageContext.request.contextPath}/logout">Logout</a>
    </div>

</main>

</body>
</html>
