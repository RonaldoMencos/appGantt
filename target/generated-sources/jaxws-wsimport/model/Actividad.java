
package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para actividad complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="actividad">
 *   &lt;complexContent>
 *     &lt;extension base="{http://services/}datosGenerales">
 *       &lt;sequence>
 *         &lt;element name="idActividad" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="tarea" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "actividad", propOrder = {
    "idActividad",
    "tarea"
})
public class Actividad
    extends DatosGenerales
{

    protected int idActividad;
    protected int tarea;

    /**
     * Obtiene el valor de la propiedad idActividad.
     * 
     */
    public int getIdActividad() {
        return idActividad;
    }

    /**
     * Define el valor de la propiedad idActividad.
     * 
     */
    public void setIdActividad(int value) {
        this.idActividad = value;
    }

    /**
     * Obtiene el valor de la propiedad tarea.
     * 
     */
    public int getTarea() {
        return tarea;
    }

    /**
     * Define el valor de la propiedad tarea.
     * 
     */
    public void setTarea(int value) {
        this.tarea = value;
    }

}
