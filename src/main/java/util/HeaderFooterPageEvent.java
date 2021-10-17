/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Empresa;
import model.Proyecto;

public class HeaderFooterPageEvent extends PdfPageEventHelper {

    private PdfTemplate t;
    private Image total;
    public Empresa e;
    public Proyecto p;
    SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
    public void onOpenDocument(PdfWriter writer, Document document) {
        t = writer.getDirectContent().createTemplate(30, 16);
        try {
            total = Image.getInstance(t);
            total.setRole(PdfName.ARTIFACT);
        } catch (DocumentException de) {
            throw new ExceptionConverter(de);
        }
    }

    @Override
    public void onEndPage(PdfWriter writer, Document document) {
        addHeader(writer);
        addFooter(writer);
    }

    private void addHeader(PdfWriter writer){
        PdfPTable header = new PdfPTable(3);
        try {
            // set defaults
            header.setWidths(new int[]{5, 24,10});
            header.setTotalWidth(770);
            header.setLockedWidth(true);
            header.getDefaultCell().setFixedHeight(60);
            header.getDefaultCell().setBorder(Rectangle.BOTTOM);
            header.getDefaultCell().setBorderColor(BaseColor.LIGHT_GRAY);

            // add image
//            System.out.println(HeaderFooterPageEvent.class.getResource("/memorynotfound-logo.jpg"));
            Image logo = Image.getInstance(HeaderFooterPageEvent.class.getResource("/Logo.jpg"));
            header.addCell(logo);
            // add text
            PdfPCell text = new PdfPCell();
            text.setPaddingBottom(15);
            text.setPaddingLeft(10);
            text.setBorder(Rectangle.BOTTOM);
            text.setBorderColor(BaseColor.LIGHT_GRAY);
            text.addElement(new Phrase("Proyecto: " + p.getTitulo() , new Font(Font.FontFamily.HELVETICA, 12)));
            text.addElement(new Phrase("Fecha Inicio: "+f.format(p.getFechaInicio().toGregorianCalendar().getTime()), new Font(Font.FontFamily.HELVETICA, 8)));
            text.addElement(new Phrase("Fecha Fin: "+f.format(p.getFechaFin().toGregorianCalendar().getTime()), new Font(Font.FontFamily.HELVETICA, 8)));
            
            header.addCell(text);
            PdfPCell text2 = new PdfPCell();
            text2.setPaddingBottom(15);
            text2.setPaddingLeft(10);
            text2.setBorder(Rectangle.BOTTOM);
            text2.setBorderColor(BaseColor.LIGHT_GRAY);
            header.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
            text2.addElement(new Phrase("Empresa: "+e.getNombre(), new Font(Font.FontFamily.HELVETICA, 12)));
            text2.addElement(new Phrase("Direccion: "+e.getDireccion(), new Font(Font.FontFamily.HELVETICA, 8)));
            text2.addElement(new Phrase("Telefono: "+e.getTelefono(), new Font(Font.FontFamily.HELVETICA, 8)));
            header.addCell(text2);
            
            // write content
            header.writeSelectedRows(0, -1, 35, 580, writer.getDirectContent());
        } catch(DocumentException de) {
            throw new ExceptionConverter(de);
        } catch (IOException ex) {
            Logger.getLogger(HeaderFooterPageEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void addFooter(PdfWriter writer){
        PdfPTable footer = new PdfPTable(2);
        try {
            // set defaults
            BaseColor darkBlue = new BaseColor(8, 64, 115);
            footer.setWidths(new int[]{24, 8});
            footer.setTotalWidth(770);
            footer.setLockedWidth(true);
            footer.getDefaultCell().setFixedHeight(40);
            footer.getDefaultCell().setBorder(Rectangle.TOP);
            footer.getDefaultCell().setBorderColor(BaseColor.LIGHT_GRAY);

            // add copyright    
            footer.addCell(new Phrase("\u00A9 Grupo 4", new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD)));

            footer.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
            Month mes = LocalDate.now().getMonth();

            String nombre = mes.getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
            Calendar cal = Calendar.getInstance();
            footer.addCell(new Phrase(String.format("Guatemala "+cal.get(Calendar.DAY_OF_MONTH) + " de "+ nombre + " del " + cal.get(Calendar.YEAR)  , writer.getPageNumber()), new Font(Font.FontFamily.HELVETICA, 8)));

            // add placeholder for total page count
           

            // write page
            PdfContentByte canvas = writer.getDirectContent();
            canvas.beginMarkedContentSequence(PdfName.ARTIFACT);
            footer.writeSelectedRows(0, -1, 34, 50, canvas);
            canvas.endMarkedContentSequence();
        } catch(DocumentException de) {
            throw new ExceptionConverter(de);
        }
    }

}
