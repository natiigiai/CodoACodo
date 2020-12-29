<%@page import="models.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="views/meta_imports.html" %>
        <link rel="stylesheet" href="css/views.css"/>
        <link rel="stylesheet" href="css/style.css" />
        <script defer src="js/main.js"></script>
        <!-- Vue -->
        <script defer src="js/components/cardProduct.js"></script>
        <script defer src="js/mainVue.js"></script>
    </head>
    <body>
        <div id="app" class="grid">
            <%@include file="views/header.jsp" %>
            <div class="grid-product main">
                <!-- card vue -->
                <card-product></card-product>
            </div>
            <div>
                <%= session.getMaxInactiveInterval() %>
            </div>
            <%@include file="views/footer.html" %>
        </div>
    </body>
</html>
