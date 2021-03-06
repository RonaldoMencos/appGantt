/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Empresa;
import model.ParseException_Exception;
import model.WebServiceSvc_Service;

public class SrvProyecto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private List<Empresa> listaEmpresa;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException_Exception {
        try ( PrintWriter out = response.getWriter()) {
            RequestDispatcher rd = null;
            WebServiceSvc_Service webServiceSvc = new WebServiceSvc_Service();
            listaEmpresa = webServiceSvc.getWebServiceSvcPort().listarEmpresas();
            request.setAttribute("listaEmpresa", listaEmpresa);
            request.setCharacterEncoding("iso-8859-1");
            rd = request.getRequestDispatcher("nuevoProyecto.jsp");
            rd.forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            
            processRequest(request, response);
        } catch (ParseException_Exception ex) {
            Logger.getLogger(SrvProyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            WebServiceSvc_Service webServiceSvc = new WebServiceSvc_Service();
            String titulo, descripcion, fechaInicio, fechaFin;
            int respuesta, empresa;

            titulo = request.getParameter("txttitulo").toString();
            descripcion = request.getParameter("txtdescripcion").toString();
            fechaInicio = request.getParameter("txtfechainicio").toString();
            fechaFin = request.getParameter("txtfechafin").toString();
            empresa = Integer.parseInt(request.getParameter("txtempresa").toString());
            respuesta = webServiceSvc.getWebServiceSvcPort().insertarProyecto(titulo, descripcion, fechaInicio, fechaFin, empresa);
            request.setAttribute("respuesta", respuesta);
            processRequest(request, response);

        } catch (ParseException_Exception ex) {
            Logger.getLogger(SrvProyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
