package ElevadorProyecto;
import java.util.Scanner;

public class ElevadorMain {

  public static void main(String[] args) {
    // Crea un elevador con 4 pisos 
    Elevador elevador = new Elevador(4);
    
    // Crea los botones de afuera
    @SuppressWarnings("unused")
    BotonExterior botonExteriorSubir = new BotonExterior(1, true); // Botón para subir
    @SuppressWarnings("unused")
    BotonExterior botonExteriorBajar = new BotonExterior(4, false); // Botón para bajar
    
    // Crea los botones interiores
    @SuppressWarnings("unused")
    BotonInterior botonInterior1 = new BotonInterior(1);
    @SuppressWarnings("unused")
    BotonInterior botonInterior2 = new BotonInterior(2);
    @SuppressWarnings("unused")
    BotonInterior botonInterior3 = new BotonInterior(3);
    @SuppressWarnings("unused")
    BotonInterior botonInterior4 = new BotonInterior(4);
    
    // Crea el tablero para mostrar el piso actual
    @SuppressWarnings("unused")
    Tablero tablero = new Tablero(elevador.getPisoActual());

    // Muestra el menú para interactuar con el elevador
    Scanner scanner = new Scanner(System.in);
    while (true) {
        System.out.println("\n--- Menú ---");
        System.out.println("1. Subir");
        System.out.println("2. Bajar");
        System.out.println("3. Ir a un piso específico");
        System.out.println("4. Abrir puerta");
        System.out.println("5. Cerrar puerta");
        System.out.println("6. Salir");
        System.out.println("--- ---- ---");
        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                elevador.subir();
                break;
            case 2:
                elevador.bajar();
                break;
            case 3:
                System.out.println("Ingrese el piso al que desea ir (1-4):");
                int piso = scanner.nextInt();
                elevador.irAPiso(piso);
                break;
            case 4:
                elevador.abrirPuerta();
                break;
            case 5:
                elevador.cerrarPuerta();
                break;
            case 6:
                System.out.println("Saliendo...");
                scanner.close();
                return;
            default:
                System.out.println("Opción inválida.");
            }
        }
    }
}