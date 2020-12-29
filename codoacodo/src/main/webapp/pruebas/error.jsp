<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Error!</h1>
        <%
            out.println(pageContext.getErrorData().getRequestURI());
            out.println("<br/>");
            out.println(pageContext.getErrorData().getStatusCode());
            out.println("<br/>");
            out.println(pageContext.getException());
            out.println("<br/>");
        %>
    </body>
</html>
