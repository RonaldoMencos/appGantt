/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ParseException_Exception;
import model.WebServiceSvc_Service;

/**
 *
 * @author oscar
 */
public class SrvMantenimientoActividad extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher rd = null;
        rd = request.getRequestDispatcher("mantenimientoActividad.jsp");
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
           if (request.getParameter("eliminar") != null) {
               try {
                   int respuesta = 0;
                   int idEliminar = Integer.parseInt(request.getParameter("eliminar").toString());
                   WebServiceSvc_Service service = new WebServiceSvc_Service();
                   respuesta =service.getWebServiceSvcPort().eliminarActividad(idEliminar);
                   request.setAttribute("respuesta", respuesta);
               } catch (ParseException_Exception ex) {
                   Logger.getLogger(SrvMantenimientoActividad.class.getName()).log(Level.SEVERE, null, ex);
               }
            
        }
        processRequest(request, response);
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
        response.setContentType("text/html;charset=UTF-8");
        Integer idActividad = null;
        WebServiceSvc_Service service = new WebServiceSvc_Service();
        if (request.getParameter("txtBuscar")!=null && !request.getParameter("txtBuscar").toString().isEmpty()) {
            System.out.println(request.getParameter("txtBuscar"));
            idActividad = Integer.parseInt(request.getParameter("txtBuscar").toString());
            System.out.println(idActividad);
            request.setAttribute("idActividad", idActividad);
        }
        
        processRequest(request, response);
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
