<%@page import="models.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="utils.Utils"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@page errorPage="pruebas/error.jsp" %>
<!-- User data -->
<%
    User usuario = (User) session.getAttribute("User");
%>
<%-- routes --%>
<%
    String[] urls = request.getRequestURL().toString().split("/");
    String url = urls[urls.length - 1];
    List<String> routes = Arrays.asList("index", "admin");
    List<String> routesForm = Arrays.asList("login", "sing in");
    String itemRoute = "<li class='nav-item %s'><a class='nav-link' href='%s'>%s</a></li>";
    String itemRouteForm = "<a class='btn btn-%s btn-block my-2 m-md-0' href='%s'>%s</a>";
%>
<!DOCTYPE html>
<header>
    <nav class="navbar navbar-expand-md navbar-dark bg-dark rounded-0" style="z-index: 10;">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#main-navbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="main-navbar">
            <ul class="navbar-nav mr-auto">
                <%=  Utils.htmlRoutes(routes, url, itemRoute, "active")%>
            </ul>
            <div class="navbar-bnts w-25 flex-column flex-md-row">
                <%
                    if (usuario != null) {
                %>
                <div class="dropdown">
                    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                        User Data
                    </button>
                    <div class="dropdown-menu text-center">
                        <p class="m-0 border-bottom"><%= usuario.getFullName()%></p>
                        <p class="m-0 border-bottom"><%= usuario.getEmail()%></p>
                        <p class="m-0"><%= usuario.getRol()%></p>
                    </div>
                </div>
                <a href="logout" class="btn btn-outline-primary btn-block">Logout</a>
                <%
                    } else {
                        out.print(Utils.htmlRoutes(routesForm, url, itemRouteForm, "color"));
                    }
                %>
            </div>
        </div>
    </nav>
</header>
