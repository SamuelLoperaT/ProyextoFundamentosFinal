import java.util.ArrayList;
import java.io.*;

public class ColeccionSolicitudes {
    ArrayList<Solicitud> solicitudes;
    ColeccionAmistades coleccionAmistades;

    public ColeccionSolicitudes(){
        solicitudes = new ArrayList<>();
        coleccionAmistades = new ColeccionAmistades();
    }
    public void agregarSolicitud(Solicitud solicitud) {
        solicitudes.add(solicitud);
   }
   public ArrayList<Solicitud> getSolicitudesDeUnUsuario(String usuario) {
        ArrayList<Solicitud> seleccionadas = new ArrayList<>();
        for(Solicitud s: solicitudes) {
            if(s.getUsuario1().equals(usuario)) {
                seleccionadas.add(s);
            }
            if(s.getUsuario2().equals(usuario)) {
                seleccionadas.add(s);
            }
        }
    return seleccionadas;
    }

}

