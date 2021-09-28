/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ParseException_Exception;
import model.Tarea;
import model.WebServiceSvc_Service;

public class SrvActividad extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private List<Tarea> listaTarea;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException_Exception {
        RequestDispatcher rd = null;
        rd = request.getRequestDispatcher("nuevaActividad.jsp");
        rd.forward(request, response);

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
            WebServiceSvc_Service webServiceSvc = new WebServiceSvc_Service();
            listaTarea = webServiceSvc.getWebServiceSvcPort().listarTareas();
            request.setAttribute("listaTarea", listaTarea);
            processRequest(request, response);
        } catch (ParseException_Exception ex) {
            Logger.getLogger(SrvActividad.class.getName()).log(Level.SEVERE, null, ex);
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
            int respuesta, tarea;

            titulo = request.getParameter("tituloActividad").toString();
            descripcion = request.getParameter("descripcionActividad").toString();
            fechaInicio = request.getParameter("fechaInicioActividad").toString();
            fechaFin = request.getParameter("fechaFinActividad").toString();
            tarea = Integer.parseInt(request.getParameter("tarea").toString());
            respuesta = webServiceSvc.getWebServiceSvcPort().insertarActividad(titulo, descripcion, fechaInicio, fechaFin, tarea);
            request.setAttribute("respuesta", respuesta);
            processRequest(request, response);

        } catch (ParseException_Exception ex) {
            Logger.getLogger(SrvActividad.class.getName()).log(Level.SEVERE, null, ex);
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
