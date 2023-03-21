<%-- 
    Document   : att
    Created on : Mar 21, 2023, 6:51:02 AM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="takeattend" method="POST">
            <table border="1px">
                <tr>
                    <td>Seq</td>
                    <td>Id</td>
                    <td>Name</td>
                    <td>Absent/Present</td>
                    <td>Description</td>
                </tr>
                <c:forEach items="${requestScope.atts}" var="a" varStatus="loop">
                    <tr>
                        <td>${loop.index+1}</td>
                        <td>${a.student.sid}
                            <input type="hidden" name="sid" value="${a.student.sid}" />
                            <input type="hidden" name="aid${a.student.sid}" value="${a.aid}" />
                        </td>
                        <td>${a.student.name}</td>
                        <td><input type="radio"
                                   <c:if test="${!a.status}">
                                   checked="checked"
                                   </c:if>
                                   name="status${a.student.sid}" value="absent"/>Absent
                            <input type="radio"
                                   <c:if test="${a.status}">
                                   checked="checked"
                                   </c:if>
                                   name="status${a.student.sid}" value="present"/>Present
                        </td>
                        <td><input type="text" value="${a.description}" name="description${a.student.sid}"/></td>
                    </tr>
                </c:forEach>
            </table>
            <input type="hidden" name="sessionid" value="${param.id}"/>
            <input type="submit" value="Save"/>
        </form>
    </body>
</html>
