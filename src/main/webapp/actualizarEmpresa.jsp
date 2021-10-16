<%@page import="model.Empresa"%>
<%@page import="model.WebServiceSvc_Service"%>
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
        <%            Integer idEmpresa = null;
            Empresa e = new Empresa();
            if (request.getParameter("id") != null) {
                idEmpresa = Integer.parseInt(request.getParameter("id").toString());
                WebServiceSvc_Service servicio = new WebServiceSvc_Service();
                e = servicio.getWebServiceSvcPort().listarEmpresaPorId(idEmpresa);

            }
        %>
        <form name="frmActualizarEmpresa" action="actualizarEmpresa?id=<%=e.getIdEmpresa() %>" method="POST">
            <div class="container-md d-flex justify-content-center  h-100" style="margin-top: 5em;">
                <div class="card" style="width: 80rem;">
                    <div class="card-body">
                        <h1 class="card-title text-center color-primario">Actualizar Empresa                             
                        </h1>
                    </div>
                    <div style="padding:2rem">
                        <div class="form-group">
                            <label for="idEmpresa" class="label_input">Id Empresa</label>
                            <input type="text" class="form-control" id="idEmpresa" name="txtidempresa" readonly value="<%=e.getIdEmpresa()%>">
                        </div> 
                        <div class="form-group">
                            <label for="idNombre" class="label_input">Nombre</label>
                            <input type="text" class="form-control" id="idNombre" name="txtnombre" required value="<%=e.getNombre()%>">
                        </div> 
                        <div class="form-group">
                            <label for="idDireccion" class="label_input">Apellido</label>
                            <input type="text" class="form-control" id="idDireccion" name="txtdireccion" required value="<%=e.getDireccion()%>">
                        </div>
                        <div class="form-group">
                            <label for="idEmail" class="label_input">Email</label>
                            <input type="email" class="form-control" id="idEmail" name="txtemail" required value="<%=e.getEmail()%>">
                        </div>
                        <div class="form-group">
                            <label for="idTelefono" class="label_input">Teléfono</label>
                            <input type="tel" class="form-control" id="idTelefono" name="txttelefono" required value="<%=e.getTelefono()%>">
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
