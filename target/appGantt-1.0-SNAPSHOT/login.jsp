<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <div class="container-md d-flex justify-content-center  h-100" style="margin-top: 10em;">
            <div class="card" style="width: 25em">
                <span class=" material-icons d-flex justify-content-center color-primario" style="font-size: 10rem;">
                    account_circle
                </span>

                <div class="card-body">
                    <form name="frmUser" method="POST" action="login">
                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="basic-addon1"><span class="material-icons">
                                        mail
                                    </span></span>
                            </div>
                            <input type="text" class="form-control" placeholder="Email" aria-label="Email" name="txtEmail">
                        </div>
                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="basic-addon1"><span class="material-icons">
                                        password
                                    </span></span>
                            </div>
                            <input type="password" class="form-control" placeholder="Password" aria-label="Password" name="txtPassword">
                        </div>
                        <button type="submit" class="btn btn-danger bk-primario btn-lg btn-block" name="btnIngresar">Iniciar Sesión</button>
                    </form>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/sweetalert.min.js" type="text/javascript"></script>

        <%
            HttpSession sesion = request.getSession();
            if (request.getAttribute("usuario") != null) {
                if (request.getAttribute("respuesta") == "True") {
                    sesion.setAttribute("usuario", request.getAttribute("usuario"));
                    response.sendRedirect("menu.jsp");
                } else {
        %>
        <script>swal("Acceso Incorrecto", "", "error");</script>
        <%
                }
            }

            if (request.getParameter("cerrar")!= null) {
                session.invalidate();
            }
        %>


    </body>
</html>
