<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login - FinSecure</title>
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

        h2 {
            text-align: center;
            color: #003366;
            margin-top: 30px;
        }

        form {
            width: 400px;
            margin: 20px auto;
            padding: 30px;
            background-color: rgba(255, 255, 255, 0.95);
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0,0,0,0.2);
        }

        form input {
            width: 100%;
            margin-bottom: 15px;
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 6px;
        }

        form button {
            width: 100%;
            padding: 10px;
            background-color: #0077cc;
            color: white;
            font-size: 16px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
        }

        form button:hover {
            background-color: #005fa3;
        }

        .error {
            color: red;
            text-align: center;
        }

        .message {
            color: green;
            text-align: center;
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

<!-- Login Form -->
<h2>Login to Your Account</h2>
<form action="login" method="post">
    <input type="email" name="email" placeholder="Email Address" required />
    <input type="password" name="password" placeholder="Password" required />
    <button type="submit">Login</button>
</form>

<% if (request.getAttribute("message") != null) { %>
<p class="message"><%= request.getAttribute("message") %></p>
<% } else if (request.getAttribute("error") != null) { %>
<p class="error"><%= request.getAttribute("error") %></p>
<% } %>
<% if (request.getAttribute("message") != null) { %>
<p class="message"><%= request.getAttribute("message") %></p>
<% } else if (request.getParameter("message") != null) { %>
<p class="message"><%= request.getParameter("message") %></p>
<% } else if (request.getAttribute("error") != null) { %>
<p class="error"><%= request.getAttribute("error") %></p>
<% } %>


</body>
</html>
