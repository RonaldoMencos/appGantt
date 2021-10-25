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
        <title>Reporte Gantt</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <form name="frmReporteGantt" action="SrvReporteGantt" method="POST">
            <div class="container-md d-flex justify-content-center  h-100" style="margin-top: 5em;">
                <div class="card" style="width: 100%">
                    <div class="card-body">
                        <h1 class="card-title text-center color-primario">Reporte Gantt                             
                        </h1>
                    </div>
                    <div class="d-flex justify-content-center row">
                        <div class="form-group form-inline col-md-auto">
                            <label for="txtBuscar" class="label_input mr-4" >Buscar Proyecto Por Id </label>
                            <input type="text" class="form-control mr-4" id="txtBuscar" name="txtBuscar" style="width: 15rem">
                            <button type="submit" class="btn btn-primary d-flex justify-content-center align-content-between" style="width:110px" name="btnBuscar">
                                <i class="material-icons mr-1">search</i> <span>Buscar</span>
                            </button>
                        </div>
                    </div>                   
                </div>
            </div>
        </form>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>        <script src="js/sweetalert.min.js" type="text/javascript"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>       
    </body>
</html>
