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
    <p><strong><a href="${pageContext.request.contextPath}/admin">BACK TO ADMIN</a></strong></p>
    <p><strong><a href="${pageContext.request.contextPath}/user">BACK TO DOCTOR</a></strong></p>
    <br>
    <br>
    <c:if test="${task == 1}">
        <table class="tg" border='1' cellpadding='2' width='50%'>
            <tr>
                <th>DEPARTMENT_id</th>
                <th>DEPARTMENT_NAME</th>
                <th>DEPARTMENT_BUDGET</th>
            </tr>
            <c:forEach items="${listDepartments}" var="department">
                <tr>
                    <td>${department.departmentId}</td>
                    <td>${department.departmentName}</td>
                    <td>${department.departmentBudget}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${task == 2}">
        <table class="tg" border='1' cellpadding='2' width='50%'>
            <tr>
                <th>JOB_ID</th>
                <th>JOB_NAME</th>
                <th>MIN_SALARY</th>
                <th>MAX_SALARY</th>
            </tr>
            <c:forEach items="${listJobs}" var="job">
                <tr>
                    <td>${job.jobId}</td>
                    <td>${job.jobName}</td>
                    <td>${job.minSal}</td>
                    <td>${job.maxSal}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</security:authorize>
<security:authorize access="hasRole('DOCTOR')">
    <p><strong><a href="${pageContext.request.contextPath}/user">BACK TO CABINET</a></strong></p>
</security:authorize>
<security:authorize access="hasRole('INTERN')">
    <p><strong><a href="${pageContext.request.contextPath}/intern">BACK TO CABINET</a></strong></p>
</security:authorize>
<security:authorize access="hasAnyRole('DOCTOR', 'ADMIN', 'INTERN')">
    <c:if test="${task == 3}">
        <table class="tg" border='1' cellpadding='2' width='50%'>
            <tr>
                <th>DIAGNOSIS_ID</th>
                <th>DAY_TO_DEATH</th>
                <th>DIAGNOSIS_NAME</th>
                <th>TREATMENT_ID</th>
            </tr>
            <c:forEach items="${listDiagnosis}" var="diagnosis">
                <tr>
                    <td>${diagnosis.diagnosisId}</td>
                    <td>${diagnosis.dayToDeath}</td>
                    <td>${diagnosis.diagnosisName}</td>
                    <td>${diagnosis.treatmentId}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${task == 4}">
        <table class="tg" border='1' cellpadding='2' width='50%'>
            <tr>
                <th>MEDICINE_ID</th>
                <th>MEDICINE_NAME</th>
                <th>ADMISSION_DAYS</th>
                <th>PROVIDER_NAME</th>
            </tr>
            <c:forEach items="${listMedicine}" var="medicine">
                <tr>
                    <td>${medicine.medicineId}</td>
                    <td>${medicine.medicineName}</td>
                    <td>${medicine.admissionDays}</td>
                    <td>${medicine.providerName}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${task == 5}">
        <table class="tg" border='1' cellpadding='2' width='50%'>
            <tr>
                <th>TREATMENT_ID</th>
                <th>NAME_OF_TREATMENT</th>
                <th>DURATION_DAYS</th>
            </tr>
            <c:forEach items="${listTreatment}" var="treatment">
                <tr>
                    <td>${treatment.treatmentId}</td>
                    <td>${treatment.nameOfTreatment}</td>
                    <td>${treatment.durationDays}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</security:authorize>
<security:csrfInput/>
</body>
</html>