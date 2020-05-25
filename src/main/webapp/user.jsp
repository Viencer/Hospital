<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home Page</title>
</head>
<body>
<a href="logout">logout</a> <br><br>
<security:authorize access="hasRole('ADMIN')">
    <a href="${pageContext.request.contextPath}/admin">Admin mode</a>
</security:authorize>
<br><br>
<security:authorize access="hasAnyRole('DOCTOR', 'ADMIN')">
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
        </tr>
        <c:set var="personal" value="${person}"/>
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
        </tr>
    </table>
    <br>
    PATIENTS
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
                <td><a href="updatePatient/<c:out value='${personal.id}'/>">Update</a></td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <br>
    <table class="tg" border='1' cellpadding='2' width='30%'>
        <tr>
            <td>Look at my boss</td>
            <c:set var="personal" value="${person}"/>
            <form action="${pageContext.request.contextPath}/getBoss" method="post">
                <input type="hidden" name="idB" value="${personal.bossID}">
                <input type="hidden" name="idP" value="${personal.id}">
                <td><input type="submit" value="find my boss"/></td>
                <security:csrfInput/>
            </form>

        </tr>
        <tr>
            <td>Create new patient</td>
            <td><a href="${pageContext.request.contextPath}/createNewPatient" <security:csrfInput/>>Create</a></td>
        </tr>
        <tr>
            <td>Find patient</td>
            <td><a href="${pageContext.request.contextPath}/findPatient">Find by...</a></td>
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
</security:authorize>
<security:csrfInput/>
</body>
</html>