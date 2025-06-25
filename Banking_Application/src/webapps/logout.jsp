<%@ page contentType="text/html;charset=UTF-8" %>
<%
// Invalidate session
session.invalidate();

// Set logout message and redirect to login
response.sendRedirect("login.jsp?message=You have successfully logged out.");
%>
