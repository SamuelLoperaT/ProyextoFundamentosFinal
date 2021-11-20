/**
 * En esta clase se manejan los datos referentes a un usuario dado.
 * 
 * @author Samuel Lopera Torres,Samuel Acosta Aristizabal,Nicolas Moreno Lopez
 *  
 * @version versión 1.00
 */
public class Usuario
{
    /** 
     * String donde se guarda el usuario para el inicio de sesión
    */
    private String usuario;
    /** 
     * String donde se guarda la clave para el inicio de sesión
    */
    private String clave;
     /** 
     * String donde se guarda el nombre del usuario, con el que se le va a referir
    */
    private String nombreCompleto;
     /** 
     * Constructor de la clase
     * @param usuario asignacion del usuario para el inicio de sesión
     * @param clave asignacion de la clave para el inicio de sesión
     * @param nombreCompleto asignacion del nombre de referencia para el usuario
    */
    public Usuario(String usuario, String clave, String nombreCompleto) {
        this.usuario = usuario;
        this.clave = clave;
        this.nombreCompleto = nombreCompleto;
    }
    /**
     * metodo que retorna un String con el usuario
     */
    public String getUsuario() {
        return usuario;
    }
    /**
     * metodo que retorna un String con la clave
     */
    public String getClave() {
        return clave;
    }
    /**
     * metodo que retorna un String con el nombre
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }
}
