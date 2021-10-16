<%@page import="model.Proyecto"%>
<%@page import="model.Tarea"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.WebServiceSvc_Service"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html lang="es">
    <head>     
        <title>Actualizar Tarea</title>

    </head>
    <body>
        <%@include file="menu.jsp" %>

        <%            Integer idTarea = null;
            Tarea a = new Tarea();
            SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
            if (request.getParameter("id") != null) {
                idTarea = Integer.parseInt(request.getParameter("id").toString());
                WebServiceSvc_Service servicio = new WebServiceSvc_Service();
                a = servicio.getWebServiceSvcPort().listarTareaPorId(idTarea);
                
            }
        %>
        <form name="frmActualizarTarea" action="actualizarTarea?id=<%=a.getIdTarea() %>" method="POST">
            <div class="container-md d-flex justify-content-center  h-100" style="margin-top: 5em;">
                <div class="card" style="width: 80rem;">
                    <div class="card-body">
                        <h1 class="card-title text-center color-primario">Actualizar Tarea                             
                        </h1>
                    </div>
                    <div style="padding:2rem">
                        <div class="form-group">
                            <label for="idTarea" class="label_input">Id Tarea</label>
                            <input type="text" class="form-control" id="idTarea" name="txtidtarea" readonly value="<%=a.getIdTarea()%>"> 
                        </div>
                        <div class="form-group">
                            <label for="tituloTarea" class="label_input">Titulo Tarea</label>
                            <input type="text" class="form-control" id="tituloTarea" name="txttitulo" required value="<%=a.getTitulo()%>">
                        </div> 
                        <div class="form-group">
                            <label for="idDescripcionTarea" class="label_input">Descripción Tarea</label>
                            <input type="text" class="form-control" id="idDescripcionTarea" name="txtdescripcion" required value="<%=a.getDescripcion() %>">
                        </div>
                        <div class="form-group">
                            <label for="datepicker" class="label_input">Fecha Inicio Tarea</label>
                            <input type="text" class="form-control" id="datepicker" name="txtfechainicio" required value="<%=f.format(a.getFechaInicio().toGregorianCalendar().getTime()) %>">
                        </div>
                        <div class="form-group">
                            <label for="datepicker2" class="label_input">Fecha Fin Tarea</label>
                            <input type="text" class="form-control" id="datepicker2" name="txtfechafin" required value="<%=f.format(a.getFechaFin().toGregorianCalendar().getTime()) %>">
                        </div> 
                        <div class="form-group">
                            <label for="idProyecto" class="label_input">Empresa</label>
                            <%                                ArrayList<Proyecto> listaProyecto = (ArrayList<Proyecto>) request.getAttribute("listaProyecto");
                                if (listaProyecto != null) {
                            %>  
                            <select class="form-control" id="idTarea" name="txtproyecto" >
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
        <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>        <script src="js/sweetalert.min.js" type="text/javascript"></script>
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
