<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Login</title>
        <%@include file="../views/meta_imports.html" %>
        <!-- CSS -->
        <link rel="stylesheet" href="../css/formularios.css" />
        <link rel="stylesheet" href="../css/views.css"/>
    </head>
    <body>
        <div id="app" class="grid">
            <%@include file="../views/header.jsp" %>
            <div class="form-content main">
                <form action="../login" class="form bg-light">
                    <h1 class="text-center">Login</h1>
                    <div class="input-group">
                        <i class="fas fa-envelope fa-2x"></i>
                        <input type="email"
                            name="email"
                            placeholder="Email"
                            class="form-control"
                            />
                    </div>
                    <div class="input-group">
                        <i class="fas fa-lock fa-2x"></i>
                        <input
                            type="password"
                            name="password"
                            placeholder="Password"
                            class="form-control"
                            />
                    </div>
                    <input type="submit" class="btn btn-block btn-outline-primary mt-3" value="Login" />
                </form>
            </div>
            <%@include file="../views/footer.html" %>
        </div>
    </body>
</html>
