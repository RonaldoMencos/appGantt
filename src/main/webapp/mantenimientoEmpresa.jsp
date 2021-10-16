<%@page import="model.Empresa"%>
<%@page import="model.WebServiceSvc_Service"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mantenimiento Usuario</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <form name="frmMantenimientoEmpresa" action="mantenimientoEmpresa" method="POST">
            <div class="container-md d-flex justify-content-center  h-100" style="margin-top: 5em;">
                <div class="card" style="width: 100%">
                    <div class="card-body">
                        <h1 class="card-title text-center color-primario">Mantenimiento Empresa                             
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
                                <th scope="col">IdEmpresa</th>
                                <th scope="col">Nombre</th>
                                <th scope="col">Dirección</th>
                                <th scope="col">Email</th>
                                <th scope="col">Teléfono</th>
                                <th scope="col">Opciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% List<Empresa> listEmpresa;
                                Empresa em = new Empresa();
                                WebServiceSvc_Service servicio = new WebServiceSvc_Service();

                                if (request.getAttribute("idEmpresa") != null) {
                                    Integer idEmpresa = 0;
                                    idEmpresa = Integer.parseInt(request.getAttribute("idEmpresa").toString());
                                    em = servicio.getWebServiceSvcPort().listarEmpresaPorId(idEmpresa);
                            %>
                            <tr>
                                <th scope="row"><%=em.getIdEmpresa()%></th>
                                <td><%=em.getNombre()%></td>
                                <td><%=em.getDireccion()%></td>
                                <td><%=em.getEmail()%></td>
                                <td><%=em.getTelefono()%></td>
                                <td>
                                    <a href="actualizarEmpresa?id=<%=em.getIdEmpresa()%>" class="mb-2 btn btn-success d-flex justify-content-center align-content-between" style="width:110px">
                                        <i class="material-icons mr-1">edit</i> <span>Editar</span>
                                    </a>
                                    <a class="btn btn-danger d-flex justify-content-center align-content-between" style="width:110px" href="mantenimientoEmpresa?eliminar=<%=em.getIdEmpresa()%>">
                                        <i class="material-icons mr-1">delete</i> <span>Eliminar</span>
                                    </a>
                                </td>
                            </tr>
                            <%
                            } else {
                                listEmpresa = servicio.getWebServiceSvcPort().listarEmpresas();

                                for (Empresa e : listEmpresa) {

                            %> 

                            <tr>
                                <th scope="row"><%=e.getIdEmpresa()%></th>
                                <td><%=e.getNombre()%></td>
                                <td><%=e.getDireccion()%></td>
                                <td><%=e.getEmail()%></td>
                                <td><%=e.getTelefono()%></td>
                                <td>
                                    <a href="actualizarEmpresa?id=<%=e.getIdEmpresa()%>" class="mb-2 btn btn-success d-flex justify-content-center align-content-between" style="width:110px">
                                        <i class="material-icons mr-1">edit</i> <span>Editar</span>
                                    </a>
                                    <a class="btn btn-danger d-flex justify-content-center align-content-between" style="width:110px" href="mantenimientoEmpresa?eliminar=<%=e.getIdEmpresa()%>">
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
