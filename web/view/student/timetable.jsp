<%-- 
    Document   : timetable
    Created on : Mar 24, 2023, 1:33:44 PM
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
        ${requestScope.fromYear}
        <table border="1px">
            <tr>
                <td>
                    <form method="post" action="timetable">
                         Year <select name="year" onchange="this.form.submit()">
                            <option value="2023" <c:if test="${2023 eq requestScope.year}">selected</c:if>>2023</option>
                            <option value="2022" <c:if test="${2022 eq requestScope.year}">selected</c:if>>2022</option>
                        </select>
                        <br>week  
                        <select name="week" onchange="this.form.submit()">
                            <c:forEach items="${requestScope.weeks}" var="w">
                                <option value="${w}"  <c:if test="${w eq requestScope.fromto}">selected</c:if> >${w}</option>
                            </c:forEach>
                        </select>
                            
                        <input type="text" name="sid" value="${sessionScope.acc.student.sid}">
                    </form>
                <c:forEach items="${requestScope.dates}" var="d">
                    <td> 
                    <fmt:formatDate value="${d}" pattern="EEEE dd/MM"/>
                    </td>
                </c:forEach>

            <tr/>
            <c:forEach items="${requestScope.slots}" var="s">
                <tr>
                    <td>${s.description}</td>
                    <c:forEach items="${requestScope.dates}" var="d">
                        <td>
                            <c:forEach items="${requestScope.sessions}" var="ses">
                                <c:if test="${ses.timeslot.tid eq s.tid and ses.date eq d}">
                                    ${ses.group.gname}-${ses.group.course.cname} <br/>
                                    ${ses.room.rname} 
                                    -
                                    <c:if test="${ses.status}">-(attended)</c:if>
                                    <c:if test="${!ses.status}">-
                                        (future)
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </td>
                    </c:forEach>
                <tr/> 
            </c:forEach>

        </table>
    </body>
</html>
