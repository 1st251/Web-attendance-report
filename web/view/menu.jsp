<%-- 
    Document   : menu
    Created on : Mar 21, 2023, 1:49:37 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="${pageContext.request.contextPath}/lecturer/attendance">Attendance</a><br>
        <a href="${pageContext.request.contextPath}/lecturer/timetable">TimeTable</a>
    </body>
</html>
