
/**
 * coleccion donde se manejan las publicaciones creadas por los usuarios.
 * 
 * @author Samuel Lopera Torres,Samuel Acosta Aristizabal,Nicolas Moreno Lopez
 *  
 * @version versión 1.00
 */
import java.util.ArrayList;
import java.io.*;

public class ColeccionPublicaciones
{
    /**
     * creacion del arraylist que guardará las publicaciones de todos los usuarios
     */
    ArrayList<Publicacion> publicaciones;
    /**
     * constructor de la clase, asignacion de memoria para el ArrayList publicaciones
     */
    public ColeccionPublicaciones() {
        publicaciones = new ArrayList<>();
    }
    /**
     * agrega una publicacion a la coleccion de publicaciones
     */
    public boolean agregarPublicacion(Publicacion p) {
        return publicaciones.add(p);
    }
    /**
     * retorna un arraylist con las publicaciones de un usuario dado
     * 
     * @param usuario, usuario del que se requieren las publicaciones
     */
    public ArrayList<Publicacion> getPublicacionesDeUnUsuario(String usuario) {
        ArrayList<Publicacion> seleccionadas = new ArrayList<>();
        for(Publicacion p: publicaciones) {
            if(p.getUsuario().equals(usuario)) {
                seleccionadas.add(p);
            }
        }
        return seleccionadas;
    }
}
