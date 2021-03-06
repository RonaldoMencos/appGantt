<%@page import="model.Empresa"%>
<%@page import="model.Proyecto"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.WebServiceSvc_Service"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html lang="es">
    <head>     
        <title>Actualizar Proyecto</title>

    </head>
    <body>
        <%@include file="menu.jsp" %>

        <%            Integer idProyecto = null;
            Proyecto a = new Proyecto();
            SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
            if (request.getParameter("id") != null) {
                idProyecto = Integer.parseInt(request.getParameter("id").toString());
                WebServiceSvc_Service servicio = new WebServiceSvc_Service();
                a = servicio.getWebServiceSvcPort().listarProyectoPorId(idProyecto);
                
            }
        %>
        <form name="frmActualizarProyecto" action="actualizarProyecto?id=<%=a.getIdProyecto() %>" method="POST">
            <div class="container-md d-flex justify-content-center  h-100" style="margin-top: 5em;">
                <div class="card" style="width: 80rem;">
                    <div class="card-body">
                        <h1 class="card-title text-center color-primario">Actualizar Proyecto                             
                        </h1>
                    </div>
                    <div style="padding:2rem">
                        <div class="form-group">
                            <label for="idProyecto" class="label_input">Titulo Proyecto</label>
                            <input type="text" class="form-control" id="idProyecto" name="txtidproyecto" readonly value="<%=a.getIdProyecto()%>"> 
                        </div>
                        <div class="form-group">
                            <label for="tituloProyecto" class="label_input">Titulo Proyecto</label>
                            <input type="text" class="form-control" id="tituloProyecto" name="txttitulo" required value="<%=a.getTitulo()%>">
                        </div> 
                        <div class="form-group">
                            <label for="idDescripcionProyecto" class="label_input">Descripci??n Proyecto</label>
                            <input type="text" class="form-control" id="idDescripcionProyecto" name="txtdescripcion" required value="<%=a.getDescripcion() %>">
                        </div>
                        <div class="form-group">
                            <label for="datepicker" class="label_input">Fecha Inicio Proyecto</label>
                            <input type="text" class="form-control" id="datepicker" name="txtfechainicio" required value="<%=f.format(a.getFechaInicio().toGregorianCalendar().getTime()) %>">
                        </div>
                        <div class="form-group">
                            <label for="datepicker2" class="label_input">Fecha Fin Proyecto</label>
                            <input type="text" class="form-control" id="datepicker2" name="txtfechafin" required value="<%=f.format(a.getFechaFin().toGregorianCalendar().getTime()) %>">
                        </div> 
                        <div class="form-group">
                            <label for="idEmpresa" class="label_input">Empresa</label>
                            <%                                ArrayList<Empresa> listaEmpresa = (ArrayList<Empresa>) request.getAttribute("listaEmpresa");
                                if (listaEmpresa != null) {
                            %>  
                            <select class="form-control" id="idTarea" name="txtempresa" >
                                <%
                                    for (Empresa e : listaEmpresa) {
                                %>
                                <option value="<%=e.getIdEmpresa()%>"><%=e.getNombre()%></option>
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
        <script>swal("Actualizado con ??xito!", "", "success");</script>
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
