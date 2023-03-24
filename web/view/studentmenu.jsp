<%-- 
    Document   : studentmenu
    Created on : Mar 24, 2023, 12:40:05 PM
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
        <div>WELCOME ${sessionScope.acc.username}</div><br>
        <a href="${pageContext.request.contextPath}/student/attendance">Attendance</a><br>
        <a href="${pageContext.request.contextPath}/student/timetable">TimeTable</a>
    </body>
</html>
