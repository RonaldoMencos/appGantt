<%@page import="model.Tarea"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html lang="es">
    <head>     
        <title>Nueva Actividad</title>

    </head>
    <body>
        <%@include file="menu.jsp" %>

        <form name="frmNuevaActividad" action="nuevaActividad" method="POST">
            <div class="container-md d-flex justify-content-center  h-100" style="margin-top: 5em;">
                <div class="card" style="width: 80rem;">
                    <div class="card-body">
                        <h1 class="card-title text-center color-primario">Nueva Actividad                             
                        </h1>
                    </div>
                    <div style="padding:2rem">
                        <div class="form-group">
                            <label for="idTituloActividad" class="label_input">Titulo Actividad</label>
                            <input type="text" class="form-control" id="idTituloActividad" name="tituloActividad" required>
                        </div> 
                        <div class="form-group">
                            <label for="idDescripcionActividad" class="label_input">Descripción Actividad</label>
                            <input type="text" class="form-control" id="idDescripcionActividad" name="descripcionActividad" required>
                        </div>
                        <div class="form-group">
                            <label for="datepicker" class="label_input">Fecha Inicio Actividad</label>
                            <input type="text" class="form-control" id="datepicker" name="fechaInicioActividad" required>
                        </div>
                        <div class="form-group">
                            <label for="datepicker2" class="label_input">Fecha Fin Actividad</label>
                            <input type="text" class="form-control" id="datepicker2" name="fechaFinActividad" required>
                        </div> 
                        <div class="form-group">
                            <label for="idTarea" class="label_input">Tarea</label>
                            <%  
                                ArrayList<Tarea> listaTarea = (ArrayList<Tarea>) request.getAttribute("listaTarea");
                                if (listaTarea!=null) {
                            %>  
                            <select class="form-control" id="idTarea" name="tarea">
                                <% 
                                    for (Tarea t : listaTarea) {
                                %>
                                <option value="<%=t.getIdTarea()%>"><%=t.getTitulo()%></option>
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
                    <script>swal("Error", "Las fechas deben de estar en el rango de fechas de la tarea", "error");</script>
                <%    
                }
            }
        %>
        
    </body>    
</html>
