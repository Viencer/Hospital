<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<h1><strong>Sorry, but something went wrong</strong></h1>
<security:authorize access="hasRole('ADMIN')">
    <a href="${pageContext.request.contextPath}/admin"><h1>Back to admin</h1></a>
</security:authorize>
<security:authorize access="hasRole('DOCTOR')">
    <a href="${pageContext.request.contextPath}/user"><h1>Back to user</h1></a>
</security:authorize>
<a href="${pageContext.request.contextPath}/"><h1>Back to main menu</h1></a>
</body>
</html>
