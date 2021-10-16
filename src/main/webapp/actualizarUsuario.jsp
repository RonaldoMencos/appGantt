<%@page import="model.WebServiceSvc_Service"%>
<%@page import="model.Usuario"%>
<%@page import="model.Tarea"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html lang="es">
    <head>     
        <title>Actualizar Usuario</title>

    </head>
    <body>
        <%@include file="menu.jsp" %>
        <%            Integer idUsuario = null;
            Usuario u = new Usuario();
            if (request.getParameter("id") != null) {
                idUsuario = Integer.parseInt(request.getParameter("id").toString());
                WebServiceSvc_Service servicio = new WebServiceSvc_Service();
                u = servicio.getWebServiceSvcPort().listarUsuarioPorId(idUsuario);

            }
        %>
        <form name="frmNuevoUsuario" action="actualizarUsuario?id=<%=u.getIdUsuario() %>" method="POST">
            <div class="container-md d-flex justify-content-center  h-100" style="margin-top: 5em;">
                <div class="card" style="width: 80rem;">
                    <div class="card-body">
                        <h1 class="card-title text-center color-primario">Actualizar Usuario                             
                        </h1>
                    </div>
                    <div style="padding:2rem">
                        <div class="form-group">
                            <label for="idNombre" class="label_input">Id Usuario</label>
                            <input type="text" class="form-control" id="idNombre" name="txtidusuario" readonly value="<%=u.getIdUsuario()%>">
                        </div> 
                        <div class="form-group">
                            <label for="idNombre" class="label_input">Nombre</label>
                            <input type="text" class="form-control" id="idNombre" name="txtnombre" required value="<%=u.getNombre()%>">
                        </div> 
                        <div class="form-group">
                            <label for="idApellido" class="label_input">Apellido</label>
                            <input type="text" class="form-control" id="idApellido" name="txtapellido" required value="<%=u.getApellido()%>">
                        </div>
                        <div class="form-group">
                            <label for="idEmail" class="label_input">Email</label>
                            <input type="email" class="form-control" id="idEmail" name="txtemail" required value="<%=u.getEmail()%>">
                        </div>
                        <div class="form-group">
                            <label for="idPassword" class="label_input">Contraseña</label>
                            <input type="password" class="form-control" id="idPassword" name="txtpassword" required value="<%=u.getPassword()%>">
                        </div> 

                        <button type="submit" class="btn btn-primario d-flex justify-content-center align-content-between">
                            <i class="material-icons mr-1">save</i> <span>Guardar</span>
                        </button>
                    </div>    
                </div>
            </div>
        </form>
        <script src="js/sweetalert.min.js" type="text/javascript"></script>
        <%            if (request.getAttribute("respuesta") != null) {
                String respuesta = request.getAttribute("respuesta").toString();
                if (respuesta.equals("1")) {
        %>
        <script>swal("Actualizado con Éxito!", "", "success");</script>
        <%
        } else {
        %>
        <script>swal("Error", "", "error");</script>
        <%
                }
            }
        %>

    </body>    
</html>
