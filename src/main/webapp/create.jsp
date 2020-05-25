<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Update</title>
</head>
<body>

<sec:authorize access="hasRole('DOCTOR')">
    <p><strong><a href="${pageContext.request.contextPath}/user">BACK TO DOCTOR</a></strong></p>
    <c:if test="${msg != null}">
        <h1>${msg}</h1>
        <c:redirect url="/user"/>
    </c:if>
</sec:authorize>

<sec:authorize access="hasRole('ADMIN')">
    <p><strong><a href="${pageContext.request.contextPath}/admin">BACK TO ADMIN</a></strong></p>
    <p><strong><a href="${pageContext.request.contextPath}/user">BACK TO DOCTOR</a></strong></p>
    <c:if test="${msg != null}">
        <h1>${msg}</h1>
        <c:redirect url="/admin"/>
    </c:if>
    <c:if test="${task == 1}">
        <form action="${pageContext.request.contextPath}/createPersonal" method="post">

<pre>
    FIRST_NAME:
 <input type="text" name="firstName" required placeholder="firstName"/><br>
    LAST_NAME:
 <input type="text" name="lastName" required placeholder="lastName"/><br>
    BOSS:
 <select required name="bossId">
       <c:forEach items="${personal}" var="personals">
           <option value="${personals.id}">${personals.lastName}</option>
       </c:forEach>
  </select><br>
    PREMIUM:
 <input type="se" name="com" value="0"/><br>
    SALARY:
 <input type="number" name="salary" required placeholder="salary"/><br>
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
    USERNAME:
 <input type="text" name="username" required placeholder="username"/><br>
    PASSWORD:
 <input type="text" name="password" required placeholder="password"/><br>

    <input type="submit" value="create"/>
</pre>
            <sec:csrfInput/>
        </form>
    </c:if>
</sec:authorize>

<c:if test="${task == 2}">
    <c:if test="${msg != null}">
        <h1>${msg}</h1>
        <c:redirect url="/admin"/>
    </c:if>

    <form action="createPatient" method="post">
<pre>
    <br>
    FIRST_NAME:
 <input type="text" name="firstName" required placeholder="firstName"/>    <br>
    LAST_NAME:
 <input type="text" name="lastName" required placeholder="lastName"/>    <br>
    POSITION:
 <input type="text" name="position" required placeholder="position"/>    <br>
    PHONE:
 <input type="number" name="phone" required placeholder="phone"/>    <br>
    ADDRESS:
 <input type="text" name="address" required placeholder="address"/>    <br>
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

 <input type="submit" value="create"/>
</pre>
        <sec:csrfInput/>
    </form>
</c:if>
</body>
</html>
