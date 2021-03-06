<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html lang="es">
    <head>     
        <title>Nuevo Usuario</title>

    </head>
    <body>
        <%@include file="menu.jsp" %>

        <form name="frmNuevaEmpresa" action="nuevaEmpresa" method="POST">
            <div class="container-md d-flex justify-content-center  h-100" style="margin-top: 5em;">
                <div class="card" style="width: 80rem;">
                    <div class="card-body">
                        <h1 class="card-title text-center color-primario">Nueva Empresa                             
                        </h1>
                    </div>
                    <div style="padding:2rem">
                        <div class="form-group">
                            <label for="idNombre" class="label_input">Nombre</label>
                            <input type="text" class="form-control" id="idNombre" name="txtnombre" required>
                        </div> 
                        <div class="form-group">
                            <label for="idDireccion" class="label_input">Direccion</label>
                            <input type="text" class="form-control" id="idDireccion" name="txtdireccion" required>
                        </div>
                        <div class="form-group">
                            <label for="idEmail" class="label_input">Email</label>
                            <input type="email" class="form-control" id="idEmail" name="txtemail" required>
                        </div>
                        <div class="form-group">
                            <label for="idTelefono" class="label_input">Telefono</label>
                            <input type="tel" class="form-control" id="idTelefono" name="txttelefono" required>
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
        <script>swal("Guardado con ??xito!", "", "success");</script>
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
