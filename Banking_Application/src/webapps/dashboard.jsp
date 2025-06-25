<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.bank.app.dto.UserDTO" %>
<%
UserDTO user = (UserDTO) session.getAttribute("user");
if (user == null) {
response.sendRedirect("login.jsp");
return;
}
%>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard - FinSecure</title>
    <link rel="stylesheet" href="css/style.css">
    <style>
        body.bank-body {
            background: url('bank-background.jpg') no-repeat center center fixed;
            background-size: cover;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
        }

        .navbar {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background-color: rgba(0, 51, 102, 0.85);
            padding: 10px 20px;
            color: white;
        }

        .navbar .logo {
            display: flex;
            align-items: center;
        }

        .navbar .logo img {
            height: 40px;
            margin-right: 10px;
        }

        .navbar nav a {
            color: white;
            text-decoration: none;
            margin: 0 15px;
            font-weight: bold;
        }

        .navbar nav a:hover {
            text-decoration: underline;
        }

        .dashboard-container {
            max-width: 700px;
            margin: 60px auto;
            background-color: rgba(255, 255, 255, 0.95);
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 5px 15px rgba(0,0,0,0.2);
            text-align: center;
        }

        .dashboard-container h2 {
            color: #003366;
            margin-bottom: 20px;
        }

        .dashboard-container p {
            font-size: 18px;
            margin: 10px 0;
            color: #333;
        }
    </style>
</head>
<body class="bank-body">

<!-- Navbar -->
<div class="navbar">
    <div class="logo">
        <img src="logo.png" alt="FinSecure Logo">
        <span style="font-size: 1.5em; font-weight: bold;">FinSecure</span>
    </div>
    <nav>
        <a href="index.jsp">Home</a>
        <a href="register.jsp">Register</a>
        <a href="login.jsp">Login</a>
        <a href="dashboard.jsp">Dashboard</a>
        <a href="deposit.jsp">Deposit</a>
        <a href="withdraw.jsp">Withdraw</a>
        <a href="passbook.jsp">Passbook</a>
        <a href="logout.jsp">Logout</a>
    </nav>
</div>

<!-- Dashboard Info -->
<div class="dashboard-container">
    <h2>Welcome, <%= user.getName() %> 👋</h2>
    <p><strong>Email:</strong> <%= user.getEmail() %></p>
    <p><strong>Account Balance:</strong> ₹ <%= user.getBalance() %></p>
</div>

</body>
</html>
