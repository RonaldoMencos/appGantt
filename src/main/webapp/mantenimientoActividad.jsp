<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.Tarea"%>
<%@page import="model.WebServiceSvc_Service"%>
<%@page import="model.Actividad"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mantenimiento Actividad</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <form name="frmMantenimientoActividad" action="mantenimientoActividad" method="POST">
            <div class="container-md d-flex justify-content-center  h-100" style="margin-top: 5em;">
                <div class="card" style="width: 100%">
                    <div class="card-body">
                        <h1 class="card-title text-center color-primario">Mantenimiento Actividad                             
                        </h1>
                    </div>
                    <div class="d-flex justify-content-center row">
                        <div class="form-group form-inline col-md-auto">
                            <label for="txtBuscar" class="label_input mr-4" >Buscar Por Id </label>
                            <input type="text" class="form-control mr-4" id="txtBuscar" name="txtBuscar" style="width: 15rem">
                            <button type="submit" class="btn btn-primary d-flex justify-content-center align-content-between" style="width:110px">
                                <i class="material-icons mr-1">search</i> <span>Buscar</span>
                            </button>
                        </div>
                    </div>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th scope="col">IdActividad</th>
                                <th scope="col">Titulo</th>
                                <th scope="col">Descripción</th>
                                <th scope="col">Fecha Inicio</th>
                                <th scope="col">Fecha Fin</th>
                                <th scope="col">Tarea</th>
                                <th scope="col">Opciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% List<Actividad> listActividad;
                                Actividad ac = new Actividad();
                                Tarea t = new Tarea();
                                SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
                                WebServiceSvc_Service servicio = new WebServiceSvc_Service();

                                if (request.getParameter("eliminar") != null) {
                                    int respuesta = 0;
                                    int idEliminar = Integer.parseInt(request.getParameter("eliminar").toString());
                                    servicio.getWebServiceSvcPort().eliminarActividad(idEliminar);
                                    if (respuesta == 1) {
                                }
                            }

                            if (request.getAttribute("idActividad") != null) {
                                Integer idActividad = 0;
                                idActividad = Integer.parseInt(request.getAttribute("idActividad").toString());
                                ac = servicio.getWebServiceSvcPort().listarActividadPorId(idActividad);
                                t = servicio.getWebServiceSvcPort().listarTareaPorId(ac.getTarea());
                        %>
                        <tr>
                            <th scope="row"><%=ac.getIdActividad()%></th>
                            <td><%=ac.getTitulo()%></td>
                            <td><%=ac.getDescripcion()%></td>
                            <td><%=ac.getFechaInicio()%></td>
                            <td><%=ac.getFechaFin()%></td>
                            <td><%=t.getTitulo()%></td>
                            <td>
                                <a href="actualizarActividad?id=<%=ac.getIdActividad()%>" class="mb-2 btn btn-success d-flex justify-content-center align-content-between" style="width:110px">
                                    <i class="material-icons mr-1">edit</i> <span>Editar</span>
                                </a>
                                <a class="btn btn-danger d-flex justify-content-center align-content-between" style="width:110px" href="mantenimientoActividad?eliminar=<%=ac.getIdActividad()%>">
                                    <i class="material-icons mr-1">delete</i> <span>Eliminar</span>
                                </a>
                            </td>
                        </tr>
                        <%
                        } else {
                            listActividad = servicio.getWebServiceSvcPort().listarActividades();

                            for (Actividad a : listActividad) {
                                t = servicio.getWebServiceSvcPort().listarTareaPorId(a.getTarea());
                        %> 

                        <tr>
                            <th scope="row"><%=a.getIdActividad()%></th>
                            <td><%=a.getTitulo()%></td>
                            <td><%=a.getDescripcion()%></td>
                            <td><%=a.getFechaInicio()%></td>
                            <td><%=a.getFechaFin()%></td>
                            <td><%=t.getTitulo()%></td>
                            <td>
                                <a href="actualizarActividad?id=<%=a.getIdActividad()%>" class="mb-2 btn btn-success d-flex justify-content-center align-content-between" style="width:110px">
                                    <i class="material-icons mr-1">edit</i> <span>Editar</span>
                                </a>
                                <a class="btn btn-danger d-flex justify-content-center align-content-between" style="width:110px" href="mantenimientoActividad?eliminar=<%=a.getIdActividad()%>">
                                    <i class="material-icons mr-1">delete</i> <span>Eliminar</span>
                                </a>
                            </td>
                        </tr>
                        <%}
                            }%>

                        </tbody>
                    </table>    
                </div>
            </div>
        </form>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>        <script src="js/sweetalert.min.js" type="text/javascript"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    </body>
</html>
