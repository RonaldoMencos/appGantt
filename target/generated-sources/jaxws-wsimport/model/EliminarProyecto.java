
package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para eliminarProyecto complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="eliminarProyecto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idProyecto" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "eliminarProyecto", propOrder = {
    "idProyecto"
})
public class EliminarProyecto {

    protected int idProyecto;

    /**
     * Obtiene el valor de la propiedad idProyecto.
     * 
     */
    public int getIdProyecto() {
        return idProyecto;
    }

    /**
     * Define el valor de la propiedad idProyecto.
     * 
     */
    public void setIdProyecto(int value) {
        this.idProyecto = value;
    }

}
