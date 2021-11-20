
/**
 * Clase principal del programa. Desde aquí se le pregunta al usuario lo que
 * quiere hacer.
 * 
 * @author Samuel Lopera Torres,Samuel Acosta Aristizabal,Nicolas Moreno Lopez
 *  
 * @version versión 1.00
 */
import java.util.Scanner;
import java.util.ArrayList;

public class Principal {
    /**
     * instanciacion de la clase ColeccionUsuarios
     */
    static ColeccionUsuarios coleccionUsuarios;
    /**
     * instanciacion de la clase ColeccionPublicaciones
     */
    static ColeccionPublicaciones coleccionPublicaciones;
    /**
     * instanciacion de la clase ColeccionAmistades
     */
    static ColeccionAmistades coleccionAmistades;
    /**
     * instanciacion de la clase Usuario, para el usuario que esta activo en la
     * sesion actual
     */
    static Usuario usuarioActivo;
    static ColeccionSolicitudes coleccionSolicitudes;
    /**
     * creacion de una instancia de la clase Scanner para leer datos desde el
     * teclado
     */
    static Scanner in = new Scanner(System.in);

    /**
     * metodo que inicializa las instancias de las colecciones
     */
    public static void inicializarColecciones() {
        coleccionUsuarios = new ColeccionUsuarios();
        coleccionPublicaciones = new ColeccionPublicaciones();
        coleccionAmistades = new ColeccionAmistades();
        coleccionSolicitudes = new ColeccionSolicitudes();
    }

    /**
     * clase que presenta el menu principal para el usuario
     * 
     * esta clase recibe datos desde el teclado para decidir la creacion o el inicio
     * de sesion de un usuario
     * 
     * posee tambien un "acerca de" sobre el proyecto, indicando la direccion del
     * mismo
     */

    public static void menuPrincipal() {
        int opcion;
        do {
            in = new Scanner(System.in);
            System.out.println("========================");
            System.out.println("1. Crear usuario");
            System.out.println("2. Ingresar al sistema");
            System.out.println("3. Acerca de: ");
            System.out.println("9. Salir del sistema");
            System.out.println("Por favor digite su opción");
            opcion = in.nextInt();
            switch (opcion) {
            case 1:
                menuCrearUsuario();
                break;
            case 2:
                menuIngresar();
                break;
            case 3:
                System.out.println("prototipo de una pseudo red social, posee: " + "\n"
                        + "interaccion ligera entre usuarios" + "\n" + "poco mas, pero sigue siendo mejor que MySpace");
                break;
            default:
                System.out.println("Opcion fuera de los parametros");
                break;
            }
        } while (opcion != 9);
    }

    /**
     * metodo crearUsuario
     * 
     * indica a los usuarios las instrucciones para crear una cuenta, y recibe los
     * datos necesarios para ello
     * 
     * añade los usuarios creados a coleccionUsuarios
     */
    public static void menuCrearUsuario() {
        boolean exito = false;
        String usuario;
        String clave;
        String nombreCompleto;
        do {
            in = new Scanner(System.in);
            System.out.println("========================");
            System.out.println("Favor ingresar el nuevo usuario: (o fin para terminar)");
            usuario = in.nextLine();
            if (usuario.equals("fin"))
                return;
            if (coleccionUsuarios.buscarUsuario(usuario) != null) {
                System.out.println("Ese usuario ya existe");
            } else {
                exito = true;
            }
        } while (!exito);
        System.out.println("Favor ingresar la clave: ");
        clave = in.nextLine();
        System.out.println("Favor ingresar el nombre completo: ");
        nombreCompleto = in.nextLine();
        Usuario nuevoUsuario = new Usuario(usuario, clave, nombreCompleto);
        coleccionUsuarios.agregarUsuario(nuevoUsuario);
        System.out.println("Bienvenido(a) al sistema");
        return;
    }

    /**
     * metodo menuIngresar
     * 
     * metodo que recibe los datos de inicio de sesion para proceder al menu de
     * usuario
     */
    public static void menuIngresar() {
        boolean exito = false;
        String usuario;
        String clave;
        do {
            in = new Scanner(System.in);
            System.out.println("========================");
            System.out.println("Favor ingresar su usuario: (fin para terminar)");
            usuario = in.nextLine();
            if (usuario.equals("fin"))
                return;
            System.out.println("Favor ingresar su clave: ");
            clave = in.nextLine();
            Principal.usuarioActivo = coleccionUsuarios.buscarUsuarioClave(usuario, clave);
            if (usuarioActivo == null) {
                System.out.println("Combinación usuario y clave inválida");
            } else {
                exito = true;
            }
        } while (!exito);
        System.out.println("Hola, " + Principal.usuarioActivo.getNombreCompleto());
        System.out.println("Estás en el sistema");
        menuUsuarioActivo();
    }

    /**
     * metodo menuUsuarioActivo
     * 
     * menu principal del usuario, permite acceder a el resto de funciones del
     * programa, tambien presenta un pequeño menu que indica que hace cada opcion
     */
    public static void menuUsuarioActivo() {
        int opcion;
        do {
            in = new Scanner(System.in);
            System.out.println("========================");
            System.out.println("1. Crear una publicación");
            System.out.println("2. Pedir una amistad");
            System.out.println("3. Ver mis Solicitudes");
            System.out.println("4. Ver las publicaciones de un(a) amigo(a)");
            System.out.println("5. Ver mis publicaciones");
            System.out.println("9. Regresar");
            System.out.println("Por favor digite su opción");
            opcion = in.nextInt();
            switch (opcion) {
            case 1:
                menuCrearPublicacion();
                break;
            case 2:
                menuPedirAmistad();
                break;
            case 3:
                menuVerSolicitudes();
                break;
            case 4:
                menuVerPublicacionesAmigo();
                break;
            case 5:
                menuVerPublicacionesPropias();
                break;
            default:
                System.out.println("Opcion fuera de los parametros");
                break;
            }
        } while (opcion != 9);
    }

    /**
     * metodo menuCrearPublicacion
     * 
     * permite crear una publicacion nueva, asociada con el usuario activo
     * 
     * en esta publicacion guarda el texto de la publicacion
     */
    public static void menuCrearPublicacion() {
        String texto;
        in = new Scanner(System.in);
        System.out.println("========================");
        System.out.println("Favor ingresar el texto de su publicación: ");
        texto = in.nextLine();
        Publicacion publicacion = new Publicacion(Principal.usuarioActivo.getUsuario(), texto);
        Principal.coleccionPublicaciones.agregarPublicacion(publicacion);
        System.out.println("La publicación ha sido agregada");
    }

    /**
     * metodo menuPedirAmistad
     * 
     * permite a el usuario solicitar una amistad a otro usuario
     * 
     * @version 1.0 ,las amistades se aceptan automaticamente, sin solicitar
     *          confirmacion del otro usuario
     * 
     *          las amistades se guardan en la coleccionAmistades
     */
    public static void menuPedirAmistad() {
        boolean exito = false;
        String usuario;
        Usuario amigo;
        do {
            in = new Scanner(System.in);
            System.out.println("========================");
            System.out.println("Favor ingresar el(la) amigo(a): (fin para terminar)");
            usuario = in.nextLine();
            if (usuario.equals("fin"))
                return;
            amigo = coleccionUsuarios.buscarUsuario(usuario);
            if (amigo == null) {
                System.out.println("Usuario(a) no existe en el sistema");
                continue;
            }
            if (Principal.coleccionAmistades.buscarAmistad(Principal.usuarioActivo.getUsuario(), usuario)) {
                System.out.println("La amistad ya existe");
                continue;
            }
            if (usuario.equals(Principal.usuarioActivo.getUsuario())) {
                System.out.println("No tiene sentido que te pidas amistad a tí mismo(a)");
                continue;
            }
            Solicitud solicitud = new Solicitud(Principal.usuarioActivo.getUsuario(), amigo.getUsuario());
            coleccionSolicitudes.agregarSolicitud(solicitud);
            System.out.print(Principal.usuarioActivo.getNombreCompleto() + ", ");
            System.out.println("Se ha creado la solicitud de Amistad");
            exito = true;
        } while (!exito);
    }

    /**
     * metodo menuVerPublicacionesAmigo
     * 
     * permite ver las publicaciones de alguien dentro de la lista de amigos, por
     * defecto, las mas recientes se imprimen primero
     */
    public static void menuVerPublicacionesAmigo() {
        for (Amistad a : coleccionAmistades.amistades) {
            if ((a.getUsuario1().equals(Principal.usuarioActivo.getUsuario()))) {
                ArrayList<Publicacion> seleccionadas = Principal.coleccionPublicaciones
                        .getPublicacionesDeUnUsuario(a.getUsuario2());
                System.out.println("Imprimiendo publicaciones de: " + a.getUsuario2());
                for (Publicacion p : seleccionadas) {
                    System.out.println(p.getTexto() + "\n");
                }
            }
            if ((a.getUsuario2().equals(Principal.usuarioActivo.getUsuario()))) {
                ArrayList<Publicacion> seleccionadas = Principal.coleccionPublicaciones
                        .getPublicacionesDeUnUsuario(a.getUsuario1());
                System.out.println("Imprimiendo publicaciones de: " + a.getUsuario1() + "\n");
                for (Publicacion p : seleccionadas) {
                    System.out.println(p.getFechaHora());
                    System.out.println(p.getTexto() + "\n");
                }
            }
        }
    }

    /**
     * metodo menuVerPublicacionesPropias
     * 
     * este permite al usuario ver las publicaciones que el mismo ha creado,
     * igualmente, las mas reciente se presentan primero
     */
    public static void menuVerPublicacionesPropias() {
        String usuario = Principal.usuarioActivo.getUsuario();
        ArrayList<Publicacion> seleccionadas = Principal.coleccionPublicaciones.getPublicacionesDeUnUsuario(usuario);
        System.out.println("Las publicaciones de " + Principal.usuarioActivo.getNombreCompleto() + ": ");
        for (Publicacion p : seleccionadas) {
            System.out.println(p.getTexto());
        }
    }

    public static void menuVerSolicitudes() {
        boolean exito = false;
        int indexOfFriendship = -1;
        for (Solicitud s : coleccionSolicitudes.solicitudes) {
            if ((s.getUsuario1().equals(Principal.usuarioActivo.getUsuario()))) {
                ArrayList<Solicitud> seleccionadas = Principal.coleccionSolicitudes
                        .getSolicitudesDeUnUsuario(s.getUsuario2());
                System.out.println("Imprimiendo Solicitudes");
                for (Solicitud se : seleccionadas) {
                    System.out.println(se.getUsuario2() + "\n");
                }
            }
            if ((s.getUsuario2().equals(Principal.usuarioActivo.getUsuario()))) {
                ArrayList<Solicitud> seleccionadas = Principal.coleccionSolicitudes
                        .getSolicitudesDeUnUsuario(s.getUsuario2());
                System.out.println("Imprimiendo Solicitudes");
                for (Solicitud se : seleccionadas) {
                    System.out.println(se.getUsuario1() + "\n");
                }
            }
        }
        System.out.println(
                "Si desea Aceptar alguna Solicitud, Escriba el nombre de quien quiere aceptar (escriba fin para regresar)");
        do {
            Scanner sin = new Scanner(System.in);
            String usuarioaceptar = sin.next();
            if (usuarioaceptar.equals("fin")) {
                exito = true;

            }
            for (Solicitud s : coleccionSolicitudes.solicitudes) {
                if ((s.getUsuario1().equals(usuarioaceptar))) {
                    Amistad amistad = new Amistad(usuarioaceptar, usuarioActivo.getUsuario());
                    coleccionAmistades.agregarAmistad(amistad);
                    indexOfFriendship = coleccionSolicitudes.solicitudes.indexOf(s);
                }
                if ((s.getUsuario2().equals(usuarioaceptar))) {
                    Amistad amistad = new Amistad(usuarioaceptar, usuarioActivo.getUsuario());
                    coleccionAmistades.agregarAmistad(amistad);
                    indexOfFriendship = coleccionSolicitudes.solicitudes.indexOf(s);
                }
            }
            if (coleccionSolicitudes.solicitudes.size() == 0) {
                continue;
            } else {
                coleccionSolicitudes.solicitudes.remove(indexOfFriendship);
            }
        } while (exito == false);

    }

    /**
     * metodo main del proyecto
     */
    public static void main(String[] args) {
        inicializarColecciones();
        menuPrincipal();

    }
}
