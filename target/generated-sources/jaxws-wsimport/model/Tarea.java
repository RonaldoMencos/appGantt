
package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para tarea complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="tarea">
 *   &lt;complexContent>
 *     &lt;extension base="{http://services/}datosGenerales">
 *       &lt;sequence>
 *         &lt;element name="idTarea" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="proyecto" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tarea", propOrder = {
    "idTarea",
    "proyecto"
})
public class Tarea
    extends DatosGenerales
{

    protected int idTarea;
    protected int proyecto;

    /**
     * Obtiene el valor de la propiedad idTarea.
     * 
     */
    public int getIdTarea() {
        return idTarea;
    }

    /**
     * Define el valor de la propiedad idTarea.
     * 
     */
    public void setIdTarea(int value) {
        this.idTarea = value;
    }

    /**
     * Obtiene el valor de la propiedad proyecto.
     * 
     */
    public int getProyecto() {
        return proyecto;
    }

    /**
     * Define el valor de la propiedad proyecto.
     * 
     */
    public void setProyecto(int value) {
        this.proyecto = value;
    }

}
