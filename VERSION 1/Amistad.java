
/**
 * en esta clase se manejan los datos de una amistad entre dos usuarios.
 * 
 * @author Samuel Lopera Torres,Samuel Acosta Aristizabal,Nicolas Moreno Lopez
 *  
 * @version versión 1.00
 */

public class Amistad
{
    /**
     * String que guarda el primer usuario relacionado en una amistad dada
     */
    private String usuario1;
    /**
     * String que guarda el segundo usuario relacionado en una amistad dada
     */
    private String usuario2;
    
    /** 
    *Constructor de la clase, asigna los valores de usuario1 y usuario2
    * @param usuario1 String que contiene el usuario a asignar en usuario1
    * @param usuario2 String que contiene el usuario a asignar en usuario2
    */
    public Amistad(String usuario1, String usuario2) {
        this.usuario1 = usuario1;
        this.usuario2 = usuario2;
    }
    /**
     * retorna un String con el usuario1
     */
    public String getUsuario1() {
        return usuario1;
    }
    /**
     * retorna un String con el usuario2
     */
    public String getUsuario2() {
        return usuario2;
    }
}
