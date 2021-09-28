
package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para proyecto complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="proyecto">
 *   &lt;complexContent>
 *     &lt;extension base="{http://services/}datosGenerales">
 *       &lt;sequence>
 *         &lt;element name="empresa" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idProyecto" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "proyecto", propOrder = {
    "empresa",
    "idProyecto"
})
public class Proyecto
    extends DatosGenerales
{

    protected int empresa;
    protected int idProyecto;

    /**
     * Obtiene el valor de la propiedad empresa.
     * 
     */
    public int getEmpresa() {
        return empresa;
    }

    /**
     * Define el valor de la propiedad empresa.
     * 
     */
    public void setEmpresa(int value) {
        this.empresa = value;
    }

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
