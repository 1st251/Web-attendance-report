<%-- 
    Document   : login
    Created on : Mar 20, 2023, 1:45:41 PM
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
        <form action="login" method="POST">
            <label for="email">Username:</label>
            <input type="text" id="username" name="username" required><br><!-- comment -->
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required><br>
            <button type="submit">Submit</button> 
        </form>
        <c:if test="${sessionScope.acc == null}">${mess}</c:if>
    </body>
</html>
