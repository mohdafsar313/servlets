# 🏦 FinSecure – Java Web Banking System

**FinSecure** is a secure, lightweight online banking system built with **Core Java**, **JSP**, **Servlets**, and **MySQL**. It includes user registration, login, deposit, withdraw, passbook tracking, and logout — all styled with responsive HTML/CSS and JavaScript.

---

## 📁 Project Structure

```
BankingSystem/
├── src/
│   ├── com/bank/app/
│   │   ├── dto/
│   │   │   ├── UserDTO.java
│   │   │   └── PassbookEntryDTO.java
│   │   ├── repository/
│   │   │   ├── UserRepository.java
│   │   │   └── UserRepositoryImpl.java
│   │   ├── service/
│   │   │   ├── UserService.java
│   │   │   └── UserServiceImpl.java
│   │   └── servlet/
│   │       ├── RegisterServlet.java
│   │       ├── LoginServlet.java
│   │       ├── DashboardServlet.java
│   │       ├── DepositServlet.java
│   │       ├── WithdrawServlet.java
│   │       ├── PassbookServlet.java
│   │       └── LogoutServlet.java
├── WebContent/
│   ├── css/style.css
│   ├── js/script.js
│   ├── index.jsp
│   ├── register.jsp
│   ├── login.jsp
│   ├── dashboard.jsp
│   ├── deposit.jsp
│   ├── withdraw.jsp
│   ├── passbook.jsp
│   ├── logout.jsp
│   └── WEB-INF/web.xml
├── lib/
│   ├── lombok.jar
│   └── mysql-connector.jar
```

---

## 🔧 Technologies Used

- Core Java (JDK 8+)
- JSP, Servlets
- HTML, CSS, JavaScript
- JDBC (MySQL)
- MySQL Database
- Apache Tomcat (v9+)
- IntelliJ IDEA (recommended)
- Lombok (for DTO boilerplate)

---

## 🛠 Setup Instructions

### 1️⃣ Prerequisites

- ✅ Java JDK 8 or above
- ✅ Apache Tomcat 9 or above
- ✅ MySQL installed
- ✅ IntelliJ IDEA (recommended)
- ✅ `mysql-connector.jar` and `lombok.jar` in `/lib/`

---

### 2️⃣ Create MySQL Database & Tables

```sql
CREATE DATABASE IF NOT EXISTS bankdb;

USE bankdb;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(100),
    balance DOUBLE DEFAULT 0.0
);

CREATE TABLE passbook (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    type VARCHAR(20),
    amount DOUBLE,
    balance_after DOUBLE,
    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);
```

---

### 3️⃣ Configure Database Credentials

In `UserRepositoryImpl.java`, update:

```java
private static final String URL = "jdbc:mysql://localhost:3306/bankdb";
private static final String USER = "root";
private static final String PASSWORD = "your_password";
```

---

### 4️⃣ Build and Run

1. Open project in IntelliJ IDEA
2. Add `lombok.jar` and `mysql-connector.jar` via  
   `File → Project Structure → Modules → Dependencies → + JARs`
3. Enable annotation processing:  
   `File → Settings → Build, Execution, Deployment → Compiler → Annotation Processors → ✅ Enable`
4. Configure Apache Tomcat server:
   - Add artifact: `war exploded` from WebContent
   - Set deployment path to `/FinSecure`
5. Run project → Open browser → go to `http://localhost:8080/FinSecure/`

---

## ✅ Features

- 📝 User Registration & Login
- 💼 Dashboard with balance info
- ➕ Deposit & ➖ Withdraw
- 📄 Passbook with history (date, type, amount, balance)
- 🔒 Secure Session Handling
- 🚪 Logout

---

## 🔐 Security Considerations

- Input validations in all layers
- Passwords stored as plain text (❗ for demo only — use hashing in production)
- PreparedStatements used to prevent SQL injection
- Session control enabled (auto-logout on inactivity)

---

## 📌 Credits

- Developed by Mohammed Afsar K A(mohdafsar313)
- Internship Project 
- Built with 💙 using Java Web Stack

---

## 📬 Feedback / Contributions

Pull requests and suggestions are welcome!  
Feel free to fork the repo and enhance it.
