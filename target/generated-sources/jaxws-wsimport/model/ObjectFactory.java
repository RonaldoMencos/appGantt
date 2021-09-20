
package model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the model package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ActualizarActividad_QNAME = new QName("http://services/", "actualizarActividad");
    private final static QName _ListarUsuarios_QNAME = new QName("http://services/", "listarUsuarios");
    private final static QName _ListarUsuariosResponse_QNAME = new QName("http://services/", "listarUsuariosResponse");
    private final static QName _EliminarActividad_QNAME = new QName("http://services/", "eliminarActividad");
    private final static QName _EliminarProyectoResponse_QNAME = new QName("http://services/", "eliminarProyectoResponse");
    private final static QName _ListarUsuarioPorId_QNAME = new QName("http://services/", "listarUsuarioPorId");
    private final static QName _InsertarProyecto_QNAME = new QName("http://services/", "insertarProyecto");
    private final static QName _ActualizarActividadResponse_QNAME = new QName("http://services/", "actualizarActividadResponse");
    private final static QName _ListarActividadPorIdResponse_QNAME = new QName("http://services/", "listarActividadPorIdResponse");
    private final static QName _EliminarUsuarioResponse_QNAME = new QName("http://services/", "eliminarUsuarioResponse");
    private final static QName _ListarActividadPorId_QNAME = new QName("http://services/", "listarActividadPorId");
    private final static QName _InsertarUsuarioResponse_QNAME = new QName("http://services/", "insertarUsuarioResponse");
    private final static QName _InsertarProyectoResponse_QNAME = new QName("http://services/", "insertarProyectoResponse");
    private final static QName _EliminarActividadResponse_QNAME = new QName("http://services/", "eliminarActividadResponse");
    private final static QName _InsertarEmpresaResponse_QNAME = new QName("http://services/", "insertarEmpresaResponse");
    private final static QName _ListarActividades_QNAME = new QName("http://services/", "listarActividades");
    private final static QName _InsertarEmpresa_QNAME = new QName("http://services/", "insertarEmpresa");
    private final static QName _ParseException_QNAME = new QName("http://services/", "ParseException");
    private final static QName _InsertarUsuario_QNAME = new QName("http://services/", "insertarUsuario");
    private final static QName _EliminarProyecto_QNAME = new QName("http://services/", "eliminarProyecto");
    private final static QName _InsertarActividadResponse_QNAME = new QName("http://services/", "insertarActividadResponse");
    private final static QName _ActualizarProyectoResponse_QNAME = new QName("http://services/", "actualizarProyectoResponse");
    private final static QName _InsertarActividad_QNAME = new QName("http://services/", "insertarActividad");
    private final static QName _ActualizarEmpresaResponse_QNAME = new QName("http://services/", "actualizarEmpresaResponse");
    private final static QName _AutenticarUsuarioResponse_QNAME = new QName("http://services/", "autenticarUsuarioResponse");
    private final static QName _EliminarEmpresaResponse_QNAME = new QName("http://services/", "eliminarEmpresaResponse");
    private final static QName _ActualizarUsuario_QNAME = new QName("http://services/", "actualizarUsuario");
    private final static QName _EliminarEmpresa_QNAME = new QName("http://services/", "eliminarEmpresa");
    private final static QName _ActualizarUsuarioResponse_QNAME = new QName("http://services/", "actualizarUsuarioResponse");
    private final static QName _ActualizarEmpresa_QNAME = new QName("http://services/", "actualizarEmpresa");
    private final static QName _AutenticarUsuario_QNAME = new QName("http://services/", "autenticarUsuario");
    private final static QName _EliminarUsuario_QNAME = new QName("http://services/", "eliminarUsuario");
    private final static QName _ActualizarProyecto_QNAME = new QName("http://services/", "actualizarProyecto");
    private final static QName _ListarUsuarioPorIdResponse_QNAME = new QName("http://services/", "listarUsuarioPorIdResponse");
    private final static QName _ListarActividadesResponse_QNAME = new QName("http://services/", "listarActividadesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InsertarEmpresa }
     * 
     */
    public InsertarEmpresa createInsertarEmpresa() {
        return new InsertarEmpresa();
    }

    /**
     * Create an instance of {@link InsertarEmpresaResponse }
     * 
     */
    public InsertarEmpresaResponse createInsertarEmpresaResponse() {
        return new InsertarEmpresaResponse();
    }

    /**
     * Create an instance of {@link ListarActividades }
     * 
     */
    public ListarActividades createListarActividades() {
        return new ListarActividades();
    }

    /**
     * Create an instance of {@link EliminarUsuarioResponse }
     * 
     */
    public EliminarUsuarioResponse createEliminarUsuarioResponse() {
        return new EliminarUsuarioResponse();
    }

    /**
     * Create an instance of {@link ListarActividadPorId }
     * 
     */
    public ListarActividadPorId createListarActividadPorId() {
        return new ListarActividadPorId();
    }

    /**
     * Create an instance of {@link ListarActividadPorIdResponse }
     * 
     */
    public ListarActividadPorIdResponse createListarActividadPorIdResponse() {
        return new ListarActividadPorIdResponse();
    }

    /**
     * Create an instance of {@link EliminarActividadResponse }
     * 
     */
    public EliminarActividadResponse createEliminarActividadResponse() {
        return new EliminarActividadResponse();
    }

    /**
     * Create an instance of {@link InsertarUsuarioResponse }
     * 
     */
    public InsertarUsuarioResponse createInsertarUsuarioResponse() {
        return new InsertarUsuarioResponse();
    }

    /**
     * Create an instance of {@link InsertarProyectoResponse }
     * 
     */
    public InsertarProyectoResponse createInsertarProyectoResponse() {
        return new InsertarProyectoResponse();
    }

    /**
     * Create an instance of {@link InsertarProyecto }
     * 
     */
    public InsertarProyecto createInsertarProyecto() {
        return new InsertarProyecto();
    }

    /**
     * Create an instance of {@link EliminarActividad }
     * 
     */
    public EliminarActividad createEliminarActividad() {
        return new EliminarActividad();
    }

    /**
     * Create an instance of {@link EliminarProyectoResponse }
     * 
     */
    public EliminarProyectoResponse createEliminarProyectoResponse() {
        return new EliminarProyectoResponse();
    }

    /**
     * Create an instance of {@link ListarUsuarioPorId }
     * 
     */
    public ListarUsuarioPorId createListarUsuarioPorId() {
        return new ListarUsuarioPorId();
    }

    /**
     * Create an instance of {@link ActualizarActividadResponse }
     * 
     */
    public ActualizarActividadResponse createActualizarActividadResponse() {
        return new ActualizarActividadResponse();
    }

    /**
     * Create an instance of {@link ListarUsuariosResponse }
     * 
     */
    public ListarUsuariosResponse createListarUsuariosResponse() {
        return new ListarUsuariosResponse();
    }

    /**
     * Create an instance of {@link ActualizarActividad }
     * 
     */
    public ActualizarActividad createActualizarActividad() {
        return new ActualizarActividad();
    }

    /**
     * Create an instance of {@link ListarUsuarios }
     * 
     */
    public ListarUsuarios createListarUsuarios() {
        return new ListarUsuarios();
    }

    /**
     * Create an instance of {@link ActualizarProyecto }
     * 
     */
    public ActualizarProyecto createActualizarProyecto() {
        return new ActualizarProyecto();
    }

    /**
     * Create an instance of {@link ListarUsuarioPorIdResponse }
     * 
     */
    public ListarUsuarioPorIdResponse createListarUsuarioPorIdResponse() {
        return new ListarUsuarioPorIdResponse();
    }

    /**
     * Create an instance of {@link ListarActividadesResponse }
     * 
     */
    public ListarActividadesResponse createListarActividadesResponse() {
        return new ListarActividadesResponse();
    }

    /**
     * Create an instance of {@link EliminarEmpresa }
     * 
     */
    public EliminarEmpresa createEliminarEmpresa() {
        return new EliminarEmpresa();
    }

    /**
     * Create an instance of {@link ActualizarUsuarioResponse }
     * 
     */
    public ActualizarUsuarioResponse createActualizarUsuarioResponse() {
        return new ActualizarUsuarioResponse();
    }

    /**
     * Create an instance of {@link ActualizarUsuario }
     * 
     */
    public ActualizarUsuario createActualizarUsuario() {
        return new ActualizarUsuario();
    }

    /**
     * Create an instance of {@link ActualizarEmpresa }
     * 
     */
    public ActualizarEmpresa createActualizarEmpresa() {
        return new ActualizarEmpresa();
    }

    /**
     * Create an instance of {@link AutenticarUsuario }
     * 
     */
    public AutenticarUsuario createAutenticarUsuario() {
        return new AutenticarUsuario();
    }

    /**
     * Create an instance of {@link EliminarUsuario }
     * 
     */
    public EliminarUsuario createEliminarUsuario() {
        return new EliminarUsuario();
    }

    /**
     * Create an instance of {@link InsertarActividadResponse }
     * 
     */
    public InsertarActividadResponse createInsertarActividadResponse() {
        return new InsertarActividadResponse();
    }

    /**
     * Create an instance of {@link ActualizarProyectoResponse }
     * 
     */
    public ActualizarProyectoResponse createActualizarProyectoResponse() {
        return new ActualizarProyectoResponse();
    }

    /**
     * Create an instance of {@link InsertarActividad }
     * 
     */
    public InsertarActividad createInsertarActividad() {
        return new InsertarActividad();
    }

    /**
     * Create an instance of {@link EliminarProyecto }
     * 
     */
    public EliminarProyecto createEliminarProyecto() {
        return new EliminarProyecto();
    }

    /**
     * Create an instance of {@link EliminarEmpresaResponse }
     * 
     */
    public EliminarEmpresaResponse createEliminarEmpresaResponse() {
        return new EliminarEmpresaResponse();
    }

    /**
     * Create an instance of {@link ActualizarEmpresaResponse }
     * 
     */
    public ActualizarEmpresaResponse createActualizarEmpresaResponse() {
        return new ActualizarEmpresaResponse();
    }

    /**
     * Create an instance of {@link AutenticarUsuarioResponse }
     * 
     */
    public AutenticarUsuarioResponse createAutenticarUsuarioResponse() {
        return new AutenticarUsuarioResponse();
    }

    /**
     * Create an instance of {@link InsertarUsuario }
     * 
     */
    public InsertarUsuario createInsertarUsuario() {
        return new InsertarUsuario();
    }

    /**
     * Create an instance of {@link ParseException }
     * 
     */
    public ParseException createParseException() {
        return new ParseException();
    }

    /**
     * Create an instance of {@link Actividad }
     * 
     */
    public Actividad createActividad() {
        return new Actividad();
    }

    /**
     * Create an instance of {@link DatosGenerales }
     * 
     */
    public DatosGenerales createDatosGenerales() {
        return new DatosGenerales();
    }

    /**
     * Create an instance of {@link Usuario }
     * 
     */
    public Usuario createUsuario() {
        return new Usuario();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActualizarActividad }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "actualizarActividad")
    public JAXBElement<ActualizarActividad> createActualizarActividad(ActualizarActividad value) {
        return new JAXBElement<ActualizarActividad>(_ActualizarActividad_QNAME, ActualizarActividad.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarUsuarios }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "listarUsuarios")
    public JAXBElement<ListarUsuarios> createListarUsuarios(ListarUsuarios value) {
        return new JAXBElement<ListarUsuarios>(_ListarUsuarios_QNAME, ListarUsuarios.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarUsuariosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "listarUsuariosResponse")
    public JAXBElement<ListarUsuariosResponse> createListarUsuariosResponse(ListarUsuariosResponse value) {
        return new JAXBElement<ListarUsuariosResponse>(_ListarUsuariosResponse_QNAME, ListarUsuariosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminarActividad }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "eliminarActividad")
    public JAXBElement<EliminarActividad> createEliminarActividad(EliminarActividad value) {
        return new JAXBElement<EliminarActividad>(_EliminarActividad_QNAME, EliminarActividad.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminarProyectoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "eliminarProyectoResponse")
    public JAXBElement<EliminarProyectoResponse> createEliminarProyectoResponse(EliminarProyectoResponse value) {
        return new JAXBElement<EliminarProyectoResponse>(_EliminarProyectoResponse_QNAME, EliminarProyectoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarUsuarioPorId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "listarUsuarioPorId")
    public JAXBElement<ListarUsuarioPorId> createListarUsuarioPorId(ListarUsuarioPorId value) {
        return new JAXBElement<ListarUsuarioPorId>(_ListarUsuarioPorId_QNAME, ListarUsuarioPorId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertarProyecto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "insertarProyecto")
    public JAXBElement<InsertarProyecto> createInsertarProyecto(InsertarProyecto value) {
        return new JAXBElement<InsertarProyecto>(_InsertarProyecto_QNAME, InsertarProyecto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActualizarActividadResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "actualizarActividadResponse")
    public JAXBElement<ActualizarActividadResponse> createActualizarActividadResponse(ActualizarActividadResponse value) {
        return new JAXBElement<ActualizarActividadResponse>(_ActualizarActividadResponse_QNAME, ActualizarActividadResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarActividadPorIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "listarActividadPorIdResponse")
    public JAXBElement<ListarActividadPorIdResponse> createListarActividadPorIdResponse(ListarActividadPorIdResponse value) {
        return new JAXBElement<ListarActividadPorIdResponse>(_ListarActividadPorIdResponse_QNAME, ListarActividadPorIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminarUsuarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "eliminarUsuarioResponse")
    public JAXBElement<EliminarUsuarioResponse> createEliminarUsuarioResponse(EliminarUsuarioResponse value) {
        return new JAXBElement<EliminarUsuarioResponse>(_EliminarUsuarioResponse_QNAME, EliminarUsuarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarActividadPorId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "listarActividadPorId")
    public JAXBElement<ListarActividadPorId> createListarActividadPorId(ListarActividadPorId value) {
        return new JAXBElement<ListarActividadPorId>(_ListarActividadPorId_QNAME, ListarActividadPorId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertarUsuarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "insertarUsuarioResponse")
    public JAXBElement<InsertarUsuarioResponse> createInsertarUsuarioResponse(InsertarUsuarioResponse value) {
        return new JAXBElement<InsertarUsuarioResponse>(_InsertarUsuarioResponse_QNAME, InsertarUsuarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertarProyectoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "insertarProyectoResponse")
    public JAXBElement<InsertarProyectoResponse> createInsertarProyectoResponse(InsertarProyectoResponse value) {
        return new JAXBElement<InsertarProyectoResponse>(_InsertarProyectoResponse_QNAME, InsertarProyectoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminarActividadResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "eliminarActividadResponse")
    public JAXBElement<EliminarActividadResponse> createEliminarActividadResponse(EliminarActividadResponse value) {
        return new JAXBElement<EliminarActividadResponse>(_EliminarActividadResponse_QNAME, EliminarActividadResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertarEmpresaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "insertarEmpresaResponse")
    public JAXBElement<InsertarEmpresaResponse> createInsertarEmpresaResponse(InsertarEmpresaResponse value) {
        return new JAXBElement<InsertarEmpresaResponse>(_InsertarEmpresaResponse_QNAME, InsertarEmpresaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarActividades }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "listarActividades")
    public JAXBElement<ListarActividades> createListarActividades(ListarActividades value) {
        return new JAXBElement<ListarActividades>(_ListarActividades_QNAME, ListarActividades.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertarEmpresa }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "insertarEmpresa")
    public JAXBElement<InsertarEmpresa> createInsertarEmpresa(InsertarEmpresa value) {
        return new JAXBElement<InsertarEmpresa>(_InsertarEmpresa_QNAME, InsertarEmpresa.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParseException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "ParseException")
    public JAXBElement<ParseException> createParseException(ParseException value) {
        return new JAXBElement<ParseException>(_ParseException_QNAME, ParseException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertarUsuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "insertarUsuario")
    public JAXBElement<InsertarUsuario> createInsertarUsuario(InsertarUsuario value) {
        return new JAXBElement<InsertarUsuario>(_InsertarUsuario_QNAME, InsertarUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminarProyecto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "eliminarProyecto")
    public JAXBElement<EliminarProyecto> createEliminarProyecto(EliminarProyecto value) {
        return new JAXBElement<EliminarProyecto>(_EliminarProyecto_QNAME, EliminarProyecto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertarActividadResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "insertarActividadResponse")
    public JAXBElement<InsertarActividadResponse> createInsertarActividadResponse(InsertarActividadResponse value) {
        return new JAXBElement<InsertarActividadResponse>(_InsertarActividadResponse_QNAME, InsertarActividadResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActualizarProyectoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "actualizarProyectoResponse")
    public JAXBElement<ActualizarProyectoResponse> createActualizarProyectoResponse(ActualizarProyectoResponse value) {
        return new JAXBElement<ActualizarProyectoResponse>(_ActualizarProyectoResponse_QNAME, ActualizarProyectoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertarActividad }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "insertarActividad")
    public JAXBElement<InsertarActividad> createInsertarActividad(InsertarActividad value) {
        return new JAXBElement<InsertarActividad>(_InsertarActividad_QNAME, InsertarActividad.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActualizarEmpresaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "actualizarEmpresaResponse")
    public JAXBElement<ActualizarEmpresaResponse> createActualizarEmpresaResponse(ActualizarEmpresaResponse value) {
        return new JAXBElement<ActualizarEmpresaResponse>(_ActualizarEmpresaResponse_QNAME, ActualizarEmpresaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AutenticarUsuarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "autenticarUsuarioResponse")
    public JAXBElement<AutenticarUsuarioResponse> createAutenticarUsuarioResponse(AutenticarUsuarioResponse value) {
        return new JAXBElement<AutenticarUsuarioResponse>(_AutenticarUsuarioResponse_QNAME, AutenticarUsuarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminarEmpresaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "eliminarEmpresaResponse")
    public JAXBElement<EliminarEmpresaResponse> createEliminarEmpresaResponse(EliminarEmpresaResponse value) {
        return new JAXBElement<EliminarEmpresaResponse>(_EliminarEmpresaResponse_QNAME, EliminarEmpresaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActualizarUsuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "actualizarUsuario")
    public JAXBElement<ActualizarUsuario> createActualizarUsuario(ActualizarUsuario value) {
        return new JAXBElement<ActualizarUsuario>(_ActualizarUsuario_QNAME, ActualizarUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminarEmpresa }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "eliminarEmpresa")
    public JAXBElement<EliminarEmpresa> createEliminarEmpresa(EliminarEmpresa value) {
        return new JAXBElement<EliminarEmpresa>(_EliminarEmpresa_QNAME, EliminarEmpresa.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActualizarUsuarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "actualizarUsuarioResponse")
    public JAXBElement<ActualizarUsuarioResponse> createActualizarUsuarioResponse(ActualizarUsuarioResponse value) {
        return new JAXBElement<ActualizarUsuarioResponse>(_ActualizarUsuarioResponse_QNAME, ActualizarUsuarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActualizarEmpresa }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "actualizarEmpresa")
    public JAXBElement<ActualizarEmpresa> createActualizarEmpresa(ActualizarEmpresa value) {
        return new JAXBElement<ActualizarEmpresa>(_ActualizarEmpresa_QNAME, ActualizarEmpresa.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AutenticarUsuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "autenticarUsuario")
    public JAXBElement<AutenticarUsuario> createAutenticarUsuario(AutenticarUsuario value) {
        return new JAXBElement<AutenticarUsuario>(_AutenticarUsuario_QNAME, AutenticarUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminarUsuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "eliminarUsuario")
    public JAXBElement<EliminarUsuario> createEliminarUsuario(EliminarUsuario value) {
        return new JAXBElement<EliminarUsuario>(_EliminarUsuario_QNAME, EliminarUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActualizarProyecto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "actualizarProyecto")
    public JAXBElement<ActualizarProyecto> createActualizarProyecto(ActualizarProyecto value) {
        return new JAXBElement<ActualizarProyecto>(_ActualizarProyecto_QNAME, ActualizarProyecto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarUsuarioPorIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "listarUsuarioPorIdResponse")
    public JAXBElement<ListarUsuarioPorIdResponse> createListarUsuarioPorIdResponse(ListarUsuarioPorIdResponse value) {
        return new JAXBElement<ListarUsuarioPorIdResponse>(_ListarUsuarioPorIdResponse_QNAME, ListarUsuarioPorIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarActividadesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "listarActividadesResponse")
    public JAXBElement<ListarActividadesResponse> createListarActividadesResponse(ListarActividadesResponse value) {
        return new JAXBElement<ListarActividadesResponse>(_ListarActividadesResponse_QNAME, ListarActividadesResponse.class, null, value);
    }

}
