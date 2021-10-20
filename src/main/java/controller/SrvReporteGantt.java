/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Actividad;
import model.Empresa;
import model.ParseException_Exception;
import model.Proyecto;
import model.Tarea;
import model.WebServiceSvc_Service;
import util.HeaderFooterPageEvent;

public class SrvReporteGantt extends HttpServlet {

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
        response.setContentType("application/pdf");
        OutputStream out = response.getOutputStream();
        Date date = new Date();

        float left = 36;
        float right = 36;
        float top = 90;
        float bottom = 36;
        List<BaseColor> listaColores = new ArrayList<BaseColor>();
        listaColores.add(new BaseColor(91, 219, 255));
        listaColores.add(new BaseColor(78, 189, 219));
        listaColores.add(new BaseColor(93, 154, 208));
        listaColores.add(new BaseColor(61, 105, 152));
        listaColores.add(new BaseColor(102, 107, 201));
        listaColores.add(new BaseColor(103, 94, 147));
        Document documento = new Document(PageSize.A4.rotate(), left, right, top, bottom);
        Integer contadorColor = null;

        // add header and footer
        HeaderFooterPageEvent event = new HeaderFooterPageEvent();

        try {
            PdfWriter writer = PdfWriter.getInstance(documento, out);

            int weeks;

            Font fontNormal = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.BLACK);
            Font fontNormalWhite = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.WHITE);
            PdfPTable tabla = null;

            WebServiceSvc_Service service = new WebServiceSvc_Service();
            Empresa e;
            BaseColor lightGrey = new BaseColor(233, 233, 233);
            Calendar fechaInit = Calendar.getInstance();
            Calendar fechaEnd = Calendar.getInstance();
            if (request.getParameter("txtBuscar") != null && !request.getParameter("txtBuscar").toString().isEmpty()) {
                Proyecto p;
                p = service.getWebServiceSvcPort().listarProyectoPorId(Integer.parseInt(request.getParameter("txtBuscar").toString()));
                e = service.getWebServiceSvcPort().listarEmpresaPorId(p.getEmpresa());

                event.e = e;
                event.p = p;
                writer.setPageEvent(event);
                documento.open();
                documento.setMargins(left, right, top, bottom);
                LocalDate startDate = LocalDate.of(p.getFechaInicio().getYear(), p.getFechaInicio().getMonth(), p.getFechaInicio().getDay());
                LocalDate endDate = LocalDate.of(p.getFechaFin().getYear(), p.getFechaFin().getMonth(), p.getFechaFin().getDay());
                Long semanas = ChronoUnit.WEEKS.between(startDate, endDate);
                weeks = semanas.intValue();
                tabla = new PdfPTable(weeks + 1);
                PdfPCell celda1 = new PdfPCell(new Paragraph("", fontNormal));
                celda1.setBackgroundColor(BaseColor.WHITE);
                celda1.setBorderColor(BaseColor.WHITE);
                celda1.setBorder(Rectangle.BOX);
                celda1.setBorderWidth(2F);
                PdfPCell celdaDinamica;
                tabla.addCell(celda1);

                for (Integer i = 1; i <= weeks; i++) {
                    celdaDinamica = new PdfPCell(new Paragraph("Semana " + i.toString(), fontNormal));
                    celdaDinamica.setBackgroundColor(lightGrey);
                    celdaDinamica.setBorderColor(BaseColor.WHITE);
                    celdaDinamica.setBorder(Rectangle.BOX);
                    celdaDinamica.setBorderWidth(2F);
                    celdaDinamica.setPadding(5f);
                    celdaDinamica.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabla.addCell(celdaDinamica);
                }

                List<Tarea> listTareas = service.getWebServiceSvcPort().listarTareasPorProyecto(p.getIdProyecto());

                for (Tarea t : listTareas) {
                    PdfPCell celdaTituloTarea = new PdfPCell(new Paragraph(t.getTitulo().toUpperCase(), fontNormalWhite));
                    BaseColor darkBlue = new BaseColor(8, 64, 115);
                    celdaTituloTarea.setBackgroundColor(darkBlue);
                    celdaTituloTarea.setBorderColor(BaseColor.WHITE);
                    celdaTituloTarea.setBorder(Rectangle.BOX);
                    celdaTituloTarea.setBorderWidth(2F);

                    celdaTituloTarea.setPadding(5f);
                    celdaTituloTarea.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabla.addCell(celdaTituloTarea);
                    for (Integer i = 1; i <= weeks; i++) {
                        PdfPCell celdaBlanca = new PdfPCell(new Paragraph("", fontNormal));
                        celdaBlanca.setBackgroundColor(BaseColor.WHITE);
                        celdaBlanca.setBorder(Rectangle.NO_BORDER);
                        tabla.addCell(celdaBlanca);
                    }
                    List<Actividad> listActividad = service.getWebServiceSvcPort().listarActividadesPorTarea(t.getIdTarea());
                    for (Actividad a : listActividad) {
                        PdfPCell celdaTituloActividad = new PdfPCell(new Paragraph(a.getTitulo(), fontNormal));
                        BaseColor blueGrey = new BaseColor(220, 229, 236);
                        celdaTituloActividad.setBackgroundColor(blueGrey);
                        celdaTituloActividad.setBorderColor(BaseColor.WHITE);
                        celdaTituloActividad.setBorder(Rectangle.BOX);
                        celdaTituloActividad.setBorderWidth(2F);
                        celdaTituloActividad.setPadding(5f);
                        celdaTituloActividad.setHorizontalAlignment(Element.ALIGN_CENTER);
                        tabla.addCell(celdaTituloActividad);
                        for (Integer i = 1; i <= weeks; i++) {
                            if (i == 1) {
                                contadorColor = 0;
                                fechaInit.setTime(p.getFechaInicio().toGregorianCalendar().getTime());
                                fechaEnd.setTime(p.getFechaInicio().toGregorianCalendar().getTime());
                                fechaEnd.add(Calendar.DAY_OF_YEAR, 7);
                            } else {
                                fechaInit.add(Calendar.DAY_OF_YEAR, 7);
                                fechaEnd.add(Calendar.DAY_OF_YEAR, 7);
                            }
                            PdfPCell celdaBlanca = new PdfPCell(new Paragraph("", fontNormal));
                            if (a.getFechaInicio().toGregorianCalendar().getTime().getTime() >= fechaInit.getTimeInMillis()
                                    && a.getFechaFin().toGregorianCalendar().getTimeInMillis() <= fechaEnd.getTimeInMillis()) {
                                celdaBlanca.setBackgroundColor(listaColores.get(contadorColor));
                                celdaBlanca.setBorderColor(BaseColor.WHITE);
                                celdaBlanca.setBorder(Rectangle.BOX);
                                celdaBlanca.setBorderWidth(2F);
                                tabla.addCell(celdaBlanca);

                            } else {
                                celdaBlanca.setBackgroundColor(lightGrey);
                                celdaBlanca.setBorderColor(BaseColor.WHITE);
                                celdaBlanca.setBorder(Rectangle.BOX);
                                celdaBlanca.setBorderWidth(2F);
                                tabla.addCell(celdaBlanca);
                            }
                            contadorColor++;
                            if (contadorColor == 6) {
                                contadorColor = 0;
                            }
                        }
                    }
                }
                documento.add(tabla);

            } else {
                List<Proyecto> listProyecto = new ArrayList<Proyecto>();
                listProyecto = service.getWebServiceSvcPort().listarProyectos();
                for (Proyecto p : listProyecto) {
                    e = service.getWebServiceSvcPort().listarEmpresaPorId(p.getEmpresa());

                    event.e = e;
                    event.p = p;
                    writer.setPageEvent(event);
                    documento.open();
                    documento.setMargins(left, right, top, bottom);

                    LocalDate startDate = LocalDate.of(p.getFechaInicio().getYear(), p.getFechaInicio().getMonth(), p.getFechaInicio().getDay());
                    LocalDate endDate = LocalDate.of(p.getFechaFin().getYear(), p.getFechaFin().getMonth(), p.getFechaFin().getDay());
                    Long semanas = ChronoUnit.WEEKS.between(startDate, endDate);
                    weeks = semanas.intValue();
                    System.out.println("weeks -" + weeks);
                    tabla = new PdfPTable(weeks + 1);
                    PdfPCell celda1 = new PdfPCell(new Paragraph("", fontNormal));
                    celda1.setBackgroundColor(BaseColor.WHITE);
                    celda1.setBorderColor(BaseColor.WHITE);
                    celda1.setBorder(Rectangle.BOX);
                    celda1.setBorderWidth(2F);
                    PdfPCell celdaDinamica;
                    tabla.addCell(celda1);
                    for (Integer i = 1; i <= weeks; i++) {
                        celdaDinamica = new PdfPCell(new Paragraph("Semana " + i.toString(), fontNormal));
                        celdaDinamica.setBackgroundColor(lightGrey);
                        celdaDinamica.setBorderColor(BaseColor.WHITE);
                        celdaDinamica.setBorder(Rectangle.BOX);
                        celdaDinamica.setBorderWidth(2F);
                        celdaDinamica.setPadding(5f);
                        celdaDinamica.setHorizontalAlignment(Element.ALIGN_CENTER);
                        tabla.addCell(celdaDinamica);
                    }

                    List<Tarea> listTareas = service.getWebServiceSvcPort().listarTareasPorProyecto(p.getIdProyecto());
                    for (Tarea t : listTareas) {
                        PdfPCell celdaTituloTarea = new PdfPCell(new Paragraph(t.getTitulo().toUpperCase(), fontNormalWhite));
                        BaseColor darkBlue = new BaseColor(8, 64, 115);
                        celdaTituloTarea.setBackgroundColor(darkBlue);
                        celdaTituloTarea.setBorderColor(BaseColor.WHITE);
                        celdaTituloTarea.setBorder(Rectangle.BOX);
                        celdaTituloTarea.setBorderWidth(2F);

                        celdaTituloTarea.setPadding(5f);
                        celdaTituloTarea.setHorizontalAlignment(Element.ALIGN_CENTER);
                        tabla.addCell(celdaTituloTarea);
                        for (Integer i = 1; i <= weeks; i++) {
                            PdfPCell celdaBlanca = new PdfPCell(new Paragraph("", fontNormal));
                            celdaBlanca.setBackgroundColor(BaseColor.WHITE);
                            celdaBlanca.setBorder(Rectangle.NO_BORDER);
                            tabla.addCell(celdaBlanca);
                        }
                        List<Actividad> listActividad = service.getWebServiceSvcPort().listarActividadesPorTarea(t.getIdTarea());
                        for (Actividad a : listActividad) {
                            PdfPCell celdaTituloActividad = new PdfPCell(new Paragraph(a.getTitulo(), fontNormal));
                            BaseColor blueGrey = new BaseColor(220, 229, 236);
                            celdaTituloActividad.setBackgroundColor(blueGrey);
                            celdaTituloActividad.setBorderColor(BaseColor.WHITE);
                            celdaTituloActividad.setBorder(Rectangle.BOX);
                            celdaTituloActividad.setBorderWidth(2F);
                            celdaTituloActividad.setPadding(5f);
                            celdaTituloActividad.setHorizontalAlignment(Element.ALIGN_CENTER);
                            tabla.addCell(celdaTituloActividad);
                            for (Integer i = 1; i <= weeks; i++) {
                                if (i == 1) {
                                    contadorColor = 0;
                                    fechaInit.setTime(p.getFechaInicio().toGregorianCalendar().getTime());
                                    fechaEnd.setTime(p.getFechaInicio().toGregorianCalendar().getTime());
                                    fechaEnd.add(Calendar.DAY_OF_YEAR, 7);
                                } else {
                                    fechaInit.add(Calendar.DAY_OF_YEAR, 7);
                                    fechaEnd.add(Calendar.DAY_OF_YEAR, 7);
                                }
                                PdfPCell celdaBlanca = new PdfPCell(new Paragraph("", fontNormal));
                                if (a.getFechaInicio().toGregorianCalendar().getTime().getTime() >= fechaInit.getTimeInMillis()
                                        && a.getFechaFin().toGregorianCalendar().getTimeInMillis() <= fechaEnd.getTimeInMillis()) {
                                    celdaBlanca.setBackgroundColor(listaColores.get(contadorColor));
                                    celdaBlanca.setBorderColor(BaseColor.WHITE);
                                    celdaBlanca.setBorder(Rectangle.BOX);
                                    celdaBlanca.setBorderWidth(2F);
                                    tabla.addCell(celdaBlanca);

                                } else {
                                    celdaBlanca.setBackgroundColor(lightGrey);
                                    celdaBlanca.setBorderColor(BaseColor.WHITE);
                                    celdaBlanca.setBorder(Rectangle.BOX);
                                    celdaBlanca.setBorderWidth(2F);
                                    tabla.addCell(celdaBlanca);
                                }
                                contadorColor++;
                                if (contadorColor == 6) {
                                    contadorColor = 0;
                                }
                            }
                        }
                    }
                    documento.add(tabla);
                    writer.setPageEmpty(false);
                    documento.newPage();
                }

            }

            documento.close();

        } catch (DocumentException ex) {
            Logger.getLogger(SrvReporteGantt.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException_Exception ex) {
            Logger.getLogger(SrvReporteGantt.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
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
