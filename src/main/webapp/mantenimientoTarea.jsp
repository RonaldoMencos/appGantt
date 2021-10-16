<%@page import="model.Proyecto"%>
<%@page import="model.Empresa"%>
<%@page import="model.Tarea"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.WebServiceSvc_Service"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mantenimiento Tarea</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <form name="frmMantenimientoTarea" action="mantenimientoTarea" method="POST">
            <div class="container-md d-flex justify-content-center  h-100" style="margin-top: 5em;">
                <div class="card" style="width: 100%">
                    <div class="card-body">
                        <h1 class="card-title text-center color-primario">Mantenimiento Tarea                             
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
                                <th scope="col">IdTarea</th>
                                <th scope="col">Titulo</th>
                                <th scope="col">Descripción</th>
                                <th scope="col">Fecha Inicio</th>
                                <th scope="col">Fecha Fin</th>
                                <th scope="col">Proyecto</th>
                                <th scope="col">Opciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% List<Tarea> listTarea;
                                Tarea ta = new Tarea();
                                Proyecto p = new Proyecto();
                                SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
                                WebServiceSvc_Service servicio = new WebServiceSvc_Service();

                                if (request.getAttribute("idTarea") != null) {
                                    Integer idTarea = 0;
                                    idTarea = Integer.parseInt(request.getAttribute("idTarea").toString());
                                    ta = servicio.getWebServiceSvcPort().listarTareaPorId(idTarea);
                                    p= servicio.getWebServiceSvcPort().listarProyectoPorId(ta.getProyecto());
                            %>
                            <tr>
                                <th scope="row"><%=ta.getIdTarea()%></th>
                                <td><%=ta.getTitulo()%></td>
                                <td><%=ta.getDescripcion()%></td>
                                <td><%=f.format(ta.getFechaInicio().toGregorianCalendar().getTime())%></td>
                                <td><%=f.format(ta.getFechaFin().toGregorianCalendar().getTime())%></td>
                                <td><%=p.getTitulo()%></td>
                                <td>
                                    <a href="actualizarTarea?id=<%=ta.getIdTarea()%>" class="mb-2 btn btn-success d-flex justify-content-center align-content-between" style="width:110px">
                                        <i class="material-icons mr-1">edit</i> <span>Editar</span>
                                    </a>
                                    <a class="btn btn-danger d-flex justify-content-center align-content-between" style="width:110px" href="mantenimientoTarea?eliminar=<%=ta.getIdTarea()%>">
                                        <i class="material-icons mr-1">delete</i> <span>Eliminar</span>
                                    </a>
                                </td>
                            </tr>
                            <%
                            } else {
                                listTarea = servicio.getWebServiceSvcPort().listarTareas();

                                for (Tarea t : listTarea) {
                                    p = servicio.getWebServiceSvcPort().listarProyectoPorId(t.getProyecto());

                            %> 

                            <tr>
                                <th scope="row"><%=t.getIdTarea()%></th>
                                <td><%=t.getTitulo()%></td>
                                <td><%=t.getDescripcion()%></td>
                                <td><%=f.format(t.getFechaInicio().toGregorianCalendar().getTime())%></td>
                                <td><%=f.format(t.getFechaFin().toGregorianCalendar().getTime())%></td>
                                <td><%=p.getTitulo()%></td>
                                <td>
                                    <a href="actualizarTarea?id=<%=t.getIdTarea()%>" class="mb-2 btn btn-success d-flex justify-content-center align-content-between" style="width:110px">
                                        <i class="material-icons mr-1">edit</i> <span>Editar</span>
                                    </a>
                                    <a class="btn btn-danger d-flex justify-content-center align-content-between" style="width:110px" href="mantenimientoTarea?eliminar=<%=t.getIdTarea()%>">
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

        <%
            if (request.getAttribute("respuesta") != null) {
                String respuesta = request.getAttribute("respuesta").toString();
                if (respuesta.equals("1")) {
        %>
        <script>swal("Eliminado con Éxito!", "", "success");</script>
        <%
                }
            }
        %>
    </body>
</html>
