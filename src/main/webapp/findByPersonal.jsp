<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p><strong><a href="${pageContext.request.contextPath}/admin">BACK TO ADMIN</a></strong></p>
<br>
<br>
    <form action="findByName" method="post">
        LAST_NAME: <input type="text" name="lastName"/>
        <input type="submit" value="find"/>
        <sec:csrfInput/>
    </form>

    <form action="findById" method="post">
        ID: <input type="number" name="id"/>
        <input type="submit" value="find"/>
        <sec:csrfInput/>
    </form>
<table class="tg" border='1' cellpadding='2' width='100%'>
    <tr>
        <th>ID</th>
        <th>FIRST_NAME</th>
        <th>LAST_NAME</th>
        <th>JOB_ID</th>
        <th>BOSS_ID</th>
        <th>SALARY</th>
        <th>PREMIUM</th>
        <th>DEPARTMENT_ID</th>
        <th>PATIENT_ID</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${listPersonal}" var="personal">
        <tr>
            <td>${personal.id}</td>
            <td>${personal.firstName}</td>
            <td>${personal.lastName}</td>
            <td>${personal.jobId}</td>
            <td>${personal.bossID}</td>
            <td>${personal.salary}</td>
            <td>${personal.premium}</td>
            <td>${personal.department_id}</td>
            <td>${personal.patient_id}</td>
            <td><a href="update/<c:out value='${personal.id}'/>">Update</a></td>
            <td><a href="delete/<c:out value='${personal.id}'/>">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<sec:csrfInput/>
</body>
</html>
