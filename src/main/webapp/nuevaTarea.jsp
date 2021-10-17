<%@page import="model.Proyecto"%>
<%@page import="model.Empresa"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html lang="es">
    <head>     
        <title>Nueva Tarea </title>

    </head>
    <body>
        <%@include file="menu.jsp" %>

        <form name="frmNuevaTarea" action="nuevaTarea" method="POST">
            <div class="container-md d-flex justify-content-center  h-100" style="margin-top: 5em;">
                <div class="card" style="width: 80rem;">
                    <div class="card-body">
                        <h1 class="card-title text-center color-primario">Nueva Tarea                              
                        </h1>
                    </div>
                    <div style="padding:2rem">
                        <div class="form-group">
                            <label for="idTitulo" class="label_input">Titulo </label>
                            <input type="text" class="form-control" id="idTitulo" name="txttitulo" required>
                        </div> 
                        <div class="form-group">
                            <label for="idDescripcion" class="label_input">Descripción </label>
                            <input type="text" class="form-control" id="idDescripcion" name="txtdescripcion" required>
                        </div>
                        <div class="form-group">
                            <label for="datepicker" class="label_input">Fecha Inicio </label>
                            <input type="text" class="form-control" id="datepicker" name="txtfechainicio" required>
                        </div>
                        <div class="form-group">
                            <label for="datepicker2" class="label_input">Fecha Fin </label>
                            <input type="text" class="form-control" id="datepicker2" name="txtfechafin" required>
                        </div> 
                        <div class="form-group">
                            <label for="idProyecto" class="label_input">Proyecto</label>
                            <%  
                                ArrayList<Proyecto> listaProyecto = (ArrayList<Proyecto>) request.getAttribute("listaProyecto");
                                if (listaProyecto!=null) {
                            %>  
                            <select class="form-control" id="idProyecto" name="txtproyecto">
                                <% 
                                    for (Proyecto e : listaProyecto) {
                                %>
                                <option value="<%=e.getIdProyecto()%>"><%=e.getTitulo()%></option>
                                <%
                                    }
                                %>
                            </select>
                            <%}%>
                        </div>
                        <button type="submit" class="btn btn-primario d-flex justify-content-center align-content-between">
                            <i class="material-icons mr-1">save</i> <span>Guardar</span>
                        </button>
                    </div>    
                </div>
            </div>
        </form>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>        
        <script src="js/sweetalert.min.js" type="text/javascript"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

                <script>
$(function () {
$("#datepicker").datepicker({
    dateFormat: "dd-mm-yy"
});
$("#datepicker2").datepicker({
    dateFormat: "dd-mm-yy"
});
});
</script>
        <%  
            if (request.getAttribute("respuesta") != null) {
                String respuesta = request.getAttribute("respuesta").toString();
                if (respuesta.equals("1")) {
                %>
                    <script>swal("Guardado con Éxito!", "", "success");</script>
                <%   
                } else {
                %>
                    <script>swal("Error", "Las fechas deben de estar en el rango de fechas del proyecto", "error");</script>
                <%    
                }
            }
        %>
        
    </body>    
</html>
