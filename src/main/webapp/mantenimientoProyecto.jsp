<%@page import="model.Empresa"%>
<%@page import="model.Proyecto"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.WebServiceSvc_Service"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mantenimiento Proyecto</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <form name="frmMantenimientoProyecto" action="mantenimientoProyecto" method="POST">
            <div class="container-md d-flex justify-content-center  h-100" style="margin-top: 5em;">
                <div class="card" style="width: 100%">
                    <div class="card-body">
                        <h1 class="card-title text-center color-primario">Mantenimiento Proyecto                             
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
                                <th scope="col">IdProyecto</th>
                                <th scope="col">Titulo</th>
                                <th scope="col">Descripción</th>
                                <th scope="col">Fecha Inicio</th>
                                <th scope="col">Fecha Fin</th>
                                <th scope="col">Empresa</th>
                                <th scope="col">Opciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% List<Proyecto> listProyecto;
                                Proyecto pr = new Proyecto();
                                Empresa e = new Empresa();
                                SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
                                WebServiceSvc_Service servicio = new WebServiceSvc_Service();

                                if (request.getAttribute("idProyecto") != null) {
                                    Integer idProyecto = 0;
                                    idProyecto = Integer.parseInt(request.getAttribute("idProyecto").toString());
                                    pr = servicio.getWebServiceSvcPort().listarProyectoPorId(idProyecto);
                                    e = servicio.getWebServiceSvcPort().listarEmpresaPorId(pr.getEmpresa());
                            %>
                            <tr>
                                <th scope="row"><%=pr.getIdProyecto()%></th>
                                <td><%=pr.getTitulo()%></td>
                                <td><%=pr.getDescripcion()%></td>
                                <td><%=f.format(pr.getFechaInicio().toGregorianCalendar().getTime())%></td>
                                <td><%=f.format(pr.getFechaFin().toGregorianCalendar().getTime())%></td>
                                <td><%=e.getNombre()%></td>
                                <td>
                                    <a href="actualizarProyecto?id=<%=pr.getIdProyecto()%>" class="mb-2 btn btn-success d-flex justify-content-center align-content-between" style="width:110px">
                                        <i class="material-icons mr-1">edit</i> <span>Editar</span>
                                    </a>
                                    <a class="btn btn-danger d-flex justify-content-center align-content-between" style="width:110px" href="mantenimientoProyecto?eliminar=<%=pr.getIdProyecto()%>">
                                        <i class="material-icons mr-1">delete</i> <span>Eliminar</span>
                                    </a>
                                </td>
                            </tr>
                            <%
                            } else {
                                listProyecto = servicio.getWebServiceSvcPort().listarProyectos();

                                for (Proyecto p : listProyecto) {
                                    e = servicio.getWebServiceSvcPort().listarEmpresaPorId(p.getEmpresa());

                            %> 

                            <tr>
                                <th scope="row"><%=p.getIdProyecto()%></th>
                                <td><%=p.getTitulo()%></td>
                                <td><%=p.getDescripcion()%></td>
                                <td><%=f.format(p.getFechaInicio().toGregorianCalendar().getTime())%></td>
                                <td><%=f.format(p.getFechaFin().toGregorianCalendar().getTime())%></td>
                                <td><%=e.getNombre()%></td>
                                <td>
                                    <a href="actualizarProyecto?id=<%=p.getIdProyecto()%>" class="mb-2 btn btn-success d-flex justify-content-center align-content-between" style="width:110px">
                                        <i class="material-icons mr-1">edit</i> <span>Editar</span>
                                    </a>
                                    <a class="btn btn-danger d-flex justify-content-center align-content-between" style="width:110px" href="mantenimientoProyecto?eliminar=<%=p.getIdProyecto()%>">
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
