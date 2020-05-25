<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<sec:authorize access="hasRole('DOCTOR')">
    <p><strong><a href="${pageContext.request.contextPath}/user">BACK TO DOCTOR</a></strong></p>
</sec:authorize>
<sec:authorize access="hasRole('ADMIN')">
    <p><strong><a href="${pageContext.request.contextPath}/admin">BACK TO ADMIN</a></strong></p>
    <c:if test="${msg != null}">
        <h1>${msg}</h1>
        <c:redirect url="/admin"/>
    </c:if>
    <c:if test="${task == 1}">
        <form action="${pageContext.request.contextPath}/updateP" method="post">

<pre>
    <c:set var="personal" value="${Personal}"/>
    <br>
    <h1>Update personal with id ${personal.id}</h1>

    <input type="hidden" name="id" value="${personal.id} "/><br>

    LAST_NAME
    <input type="text" name="lastName" value="${personal.lastName}"/><br>

    BOSS:
    <select required name="bossId">
       <c:forEach items="${personals}" var="personals">
           <c:if test="${personals.id != personal.id}">
               <option value="${personals.id}">${personals.lastName}</option>
           </c:if>
       </c:forEach>
    </select><br>

    PREMIUM
    <input type="number" name="com" value="${personal.premium}"/><br>

    SALARY
    <input type="number" name="salary" value="${personal.salary}"/><br>

    JOB
    <select required name="jobId">
       <c:forEach items="${jobs}" var="jobs">
           <option value="${jobs.jobId}">${jobs.jobName}</option>
       </c:forEach>
    </select><br>

    DEPARTMENT:
    <select required name="department">
       <c:forEach items="${dept}" var="dep">
           <option value="${dep.departmentId}">${dep.departmentName}</option>
       </c:forEach>
    </select><br>

    PATIENT:
    <select required name="patient">
        <option value="0"></option>
           <c:forEach items="${patient}" var="patients">
               <option value="${patients.id}">${patients.lastName}</option>
           </c:forEach>
    </select><br>

    <input type="submit" value="update"/>
</pre>
            <sec:csrfInput/>
        </form>
    </c:if>
</sec:authorize>
<sec:authorize access="hasAnyRole('ADMIN', 'DOCTOR')">
    <c:if test="${msg != null}">
        <h1>${msg}</h1>
        <c:redirect url="/user"/>
    </c:if>
    <c:if test="${task == 2}">
        <form action="${pageContext.request.contextPath}/updatePatient" method="post">

<pre>
    <c:set var="patient" value="${Patient}"/>
    <br>
    <h1>Update personal with id ${patient.id}</h1>

    <input type="hidden" name="id" value="${patient.id} "/><br>
    FIRST_NAME:
    <input type="text" disabled name="firstName" value="${patient.firstName}"/><br>

    LAST_NAME:
    <input type="text" disabled name="lastName" value="${patient.lastName}"/><br>

    POSITION:
    <input type="text" disabled name="position" value="${patient.position}"/><br>

    PHONE:
    <input type="text" disabled name="phone" value="${patient.phone}"/><br>

    ADDRESS:
    <input type="text" disabled name="address" value="${patient.address}"/>

    DIAGNOSIS:
    <select required name="diagnosisId">
           <c:forEach items="${diagnos}" var="diagnosis">
               <option value="${diagnosis.diagnosisId}">${diagnosis.diagnosisName}</option>
           </c:forEach>
    </select><br>
    MEDICINE:
    <select required name="medicineId">
           <c:forEach items="${medicine}" var="med">
               <option value="${med.medicineId}">${med.medicineName}</option>
           </c:forEach>
    </select><br>

    <input type="submit" value="update"/>
</pre>
            <sec:csrfInput/>
        </form>
    </c:if>
</sec:authorize>
</body>
</html>