<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>FinSecure - Home</title>
    <link rel="stylesheet" href="css/style.css">
    <script src="js/script.js" defer></script>
    <style>
        body.bank-body {
            background: url('background.jpg') no-repeat center center fixed;
            background-size: cover;
            margin: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
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

        h1, p {
            color: #003366;
            text-align: center;
        }

        .nav-buttons {
            text-align: center;
            margin: 20px 0;
        }

        .nav-buttons a {
            display: inline-block;
            margin: 10px;
            padding: 10px 20px;
            background: #0077cc;
            color: white;
            text-decoration: none;
            border-radius: 6px;
        }

        .nav-buttons a:hover {
            background: #005fa3;
        }

        .features-section {
            background-color: rgba(255, 255, 255, 0.9);
            margin: 50px auto;
            padding: 30px;
            border-radius: 10px;
            max-width: 1000px;
        }

        .features-section h2 {
            font-size: 28px;
            color: #003366;
            margin-bottom: 20px;
            text-align: center;
        }

        .features-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
            gap: 20px;
            text-align: left;
            perspective: 1000px;
        }

        .feature {
            background-color: #f0f8ff;
            border-left: 4px solid #0066cc;
            padding: 15px;
            border-radius: 6px;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
            transition: transform 0.3s ease, box-shadow 0.3s ease;
            transform-style: preserve-3d;
        }

        .feature:hover {
            transform: scale(1.05) rotateX(5deg) rotateY(-5deg);
            box-shadow: 0 12px 20px rgba(0,0,0,0.3);
        }

        .feature h3 {
            color: #005fa3;
            margin-top: 0;
        }

        .feature p {
            margin-bottom: 0;
            color: #333;
        }
    </style>
</head>
<body class="bank-body">

<!-- Navbar -->
<div class="navbar">
    <div class="logo">
        <img src="logo.png" alt="FinSecure ">
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

<!-- Welcome Message -->
<h1 style="color:rgba(0, 51, 102, 0.85)">Welcome to FinSecure</h1>
<p style="color:rgba(0, 51, 102, 0.85)">Your secure and intuitive online banking solution.</p>

<!-- Navigation Buttons -->
<!--<div class="nav-buttons">
    <a href="register.jsp">Register</a>
    <a href="login.jsp">Login</a>
    <a href="dashboard.jsp">Dashboard</a>
    <a href="deposit.jsp">Deposit</a>
    <a href="withdraw.jsp">Withdraw</a>
    <a href="passbook.jsp">Passbook</a>
    <a href="logout.jsp">Logout</a>
</div>-->

<!-- Features Section -->
<section class="features-section">
    <h2>Why Choose FinSecure?</h2>
    <div class="features-grid">
        <div class="feature">
            <h3>🔒 Secure Transactions</h3>
            <p>We use industry-standard encryption to protect your data and money 24/7.</p>
        </div>
        <div class="feature">
            <h3>📱 24/7 Online Banking</h3>
            <p>Manage your account anytime, anywhere with our responsive banking system.</p>
        </div>
        <div class="feature">
            <h3>⚡ Instant Transfers</h3>
            <p>Send and receive money instantly with our real-time transaction engine.</p>
        </div>
        <div class="feature">
            <h3>🌐 Simple & Intuitive UI</h3>
            <p>Clean, fast, and modern design built for ease of use on desktop and mobile.</p>
        </div>
        <div class="feature">
            <h3>💼 User-Centric Accounts</h3>
            <p>Create and manage your savings, current, or business accounts effortlessly.</p>
        </div>
        <div class="feature">
            <h3>🏦 Trusted by Many</h3>
            <p>Thousands of users rely on FinSecure for daily financial management.</p>
        </div>
    </div>
</section>

</body>
</html>
