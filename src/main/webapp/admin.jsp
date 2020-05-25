<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home Page</title>
</head>
<body>
<a href="logout">logout</a> <br><br>
<security:authorize access="hasRole('ADMIN')">
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
    <br>
    <br>
    <br>
    <br>
    <table class="tg" border='1' cellpadding='2' width='100%'>
        <tr>
            <th>ID</th>
            <th>FIRST_NAME</th>
            <th>LAST_NAME</th>
            <th>POSITION</th>
            <th>PHONE</th>
            <th>ADDRESS</th>
            <th>DIAGNOSIS_ID</th>
            <th>MEDICINE_ID</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${listPatient}" var="patient">
            <tr>
                <td>${patient.id}</td>
                <td>${patient.firstName}</td>
                <td>${patient.lastName}</td>
                <td>${patient.position}</td>
                <td>${patient.phone}</td>
                <td>${patient.address}</td>
                <td>${patient.diagnosisId}</td>
                <td>${patient.medicineId}</td>
                <td><a href="updatePatient/<c:out value='${patient.id}'/>">Update</a></td>
                <td><a href="deletePatient/<c:out value='${patient.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <br>
    <table class="tg" border='1' cellpadding='2' width='30%'>
        <tr>
            <td>Create new personal</td>
            <td><a href="${pageContext.request.contextPath}/createNewPersonal">Create</a></td>
        </tr>
        <tr>
            <td>Find personal</td>
            <td><a href="${pageContext.request.contextPath}/findP">Find by...</a></td>
        </tr>
        <tr>
            <td>Create new patient</td>
            <td><a href="${pageContext.request.contextPath}/createNewPatient">Create</a></td>
        </tr>
        <tr>
            <td>Find patient</td>
            <td><a href="${pageContext.request.contextPath}/findPatient">Find by...</a></td>
        </tr>
        <tr>
            <td>My cabinet</td>
            <td><a href="${pageContext.request.contextPath}/user">My cabinet</a></td>
        </tr>
        <tr>
            <td>Look at departments</td>
            <td><a target="_blank" href="${pageContext.request.contextPath}/getDepartment">departments</a></td>
        </tr>
        <tr>
            <td>Look at jobs</td>
            <td><a target="_blank" href="${pageContext.request.contextPath}/getJobs">jobs</a></td>
        </tr>
        <tr>
            <td>Look at medicine</td>
            <td><a target="_blank" href="${pageContext.request.contextPath}/getMedicine">medicine</a></td>
        </tr>
        <tr>
            <td>Look at diagnosis</td>
            <td><a target="_blank" href="${pageContext.request.contextPath}/getDiagnosis">diagnosis</a></td>
        </tr>
        <tr>
            <td>Look at treatments</td>
            <td><a target="_blank" href="${pageContext.request.contextPath}/getTreatment">treatments</a></td>
        </tr>
    </table>
    <br>
    <br>
</security:authorize>
<security:csrfInput/>
</body>
</html>