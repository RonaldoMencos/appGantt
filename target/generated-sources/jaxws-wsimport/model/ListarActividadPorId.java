
package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para listarActividadPorId complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="listarActividadPorId">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idActividad" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listarActividadPorId", propOrder = {
    "idActividad"
})
public class ListarActividadPorId {

    protected int idActividad;

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

}
