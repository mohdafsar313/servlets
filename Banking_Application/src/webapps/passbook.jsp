<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.bank.app.dto.PassbookEntryDTO" %>
<%@ page import="com.bank.app.dto.UserDTO" %>
<%
UserDTO user = (UserDTO) session.getAttribute("user");
if (user == null) {
response.sendRedirect("login.jsp");
return;
}

List<PassbookEntryDTO> transactions = (List<PassbookEntryDTO>) request.getAttribute("transactions");
    %>
    <!DOCTYPE html>
    <html>
    <head>
        <title>Passbook - FinSecure</title>
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

            .passbook-container {
                max-width: 900px;
                margin: 60px auto;
                background-color: rgba(255, 255, 255, 0.96);
                padding: 30px;
                border-radius: 12px;
                box-shadow: 0 5px 15px rgba(0,0,0,0.2);
            }

            .passbook-container h2 {
                color: #003366;
                text-align: center;
                margin-bottom: 30px;
            }

            table {
                width: 100%;
                border-collapse: collapse;
            }

            th, td {
                padding: 12px 15px;
                text-align: center;
                border-bottom: 1px solid #ccc;
            }

            th {
                background-color: #005fa3;
                color: white;
            }

            tr:hover {
                background-color: #f0f8ff;
            }

            .no-data {
                text-align: center;
                color: #666;
                margin-top: 30px;
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

    <!-- Passbook Table -->
    <div class="passbook-container">
        <h2>Passbook - Recent Transactions</h2>

        <%
        if (transactions == null || transactions.isEmpty()) {
        %>
        <p class="no-data">No transactions found.</p>
        <%
        } else {
        %>
        <table>
            <tr>
                <th>Date</th>
                <th>Type</th>
                <th>Amount (₹)</th>
                <th>Balance After</th>
            </tr>
            <%
            for (PassbookEntryDTO entry : transactions) {
            %>
            <tr>
                <td><%= entry.getDate() %></td>
                <td><%= entry.getType() %></td>
                <td><%= entry.getAmount() %></td>
                <td><%= entry.getBalanceAfter() %></td>
            </tr>
            <%
            }
            %>
        </table>
        <%
        }
        %>
    </div>

    </body>
    </html>