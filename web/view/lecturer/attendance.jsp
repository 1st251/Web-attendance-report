<%-- 
    Document   : attendance
    Created on : Mar 20, 2023, 4:56:00 PM
    Author     : admin
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDate"%>
<%@ page import="java.time.DayOfWeek"%>
<%@ page import="java.time.temporal.TemporalAdjusters"%>
<%@ page import="java.time.temporal.ChronoUnit"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<!--        <input type="hidden" name="lid" value="${sessionScope.acc.lecturer.lid}">-->
<!--      <form action="attendance" method="POST">
            <input type="text" name="lid" value="${requestScope.lid}">
            <input type="submit" name="Show"> 
        </form>-->
            <table border="1" >
                <thead>
                    <tr>
                        <th>NO</th>
                        <th>Student ID</th>
                        <c:forEach items="${requestScope.sessions}" var="s">
                        <th>SLOT</th>
                        </c:forEach>
                        <th>ATTENDACE</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        
                    </tr>
                    
                </tbody>
            </table>
   <!--         <div>ABSENT: ${requestScope.absent} ABSENT SO FAR (${requestScope.count} ABSENT ON ${requestScope.countSes} Total)
                </div>-->
    </body>
</html>
