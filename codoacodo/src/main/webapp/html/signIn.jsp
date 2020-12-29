<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Sign In</title>
        <%@include file="../views/meta_imports.html" %>
        <!-- CSS -->
        <link rel="stylesheet" href="../css/formularios.css" />
        <link rel="stylesheet" href="../css/views.css"/>
    </head>
    <body>
        <div id="app" class="grid">
            <%@include file="../views/header.jsp" %>
            <div class="form-content main">
                <form action="../signin" class="form bg-light" method="POST">
                    <h1 class="text-center">Sign In</h1>
                    <div class="input-group">
                        <i class="fas fa-user fa-2x"></i>
                        <div class="flex-grow-1 d-flex">
                            <input
                                type="text"
                                name="name"
                                placeholder="Name"
                                class="form-control"
                                />
                            <input
                                type="text"
                                name="surname"
                                placeholder="Surname"
                                class="form-control"
                                />
                        </div>
                    </div>
                    <div class="input-group">
                        <i class="fas fa-envelope fa-2x"></i>
                        <input
                            type="email"
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
                    <input type="submit" class="btn btn-outline-primary btn-block" value="Sign In"/>
                </form>
            </div>
            <%@include file="../views/footer.html" %>
        </div>
    </body>
</html>

