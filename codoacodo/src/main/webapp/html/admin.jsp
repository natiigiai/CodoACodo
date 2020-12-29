<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Admin</title>
        <%@include file="../views/meta_imports.html" %>
        <link rel="stylesheet" href="../css/views.css"/>
    </head>
    <body>
        <div id="app" class="grid">
            <%@include file="../views/header.jsp" %>
            <div class="main">
                <h1>Admin</h1>
                <div>
                    <h2>Users</h2>
                    <div>
                        <h3>Create User</h3>
                    </div>
                    <div>
                        <h3>Banear User</h3>
                        <form action="">
                            <input type="number" name="id_usuario" placeholder="id user" />
                            <label>
                                <span>reaseon ban</span>
                                <select name="reason">
                                    <option value="leve">leve</option>
                                    <option value="mid">mid</option>
                                    <option value="grave">grave</option>
                                </select>
                            </label>
                            <input type="submit" value="Ban">
                        </form>
                    </div>
                </div>
                <div>
                    <h2>Products</h2>
                    <div>
                        <h3>Create Product</h3>
                        <form>
                            <input type="text" name="name" placeholder="name product">
                            <input type="number" name="price" placeholder="price product">
                            <input type="submit" value="create product">
                        </form>
                    </div>
                </div>
            </div>
            <%@include file="../views/footer.html" %>
        </div>
    </body>
</html>
