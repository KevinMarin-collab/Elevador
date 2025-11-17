package ProyectoElevador;
import java.util.Scanner;

// Esta clase arranca todo el programa del elevador.
// Crea las instancias y maneja el menú para que interactúes con el elevador.
public class ElevadorPrincipal {

  public static void main(String[] args) {
    // ¡Creamos el elevador con 4 pisos! Y también los botones para que puedas usarlos.
    Elevador elevador = new Elevador(4);
    
    // Botones de afuera: uno para subir desde el 1 y otro para bajar desde el 4.
    BotonExterior botonExteriorSubir = new BotonExterior(1, true);
    BotonExterior botonExteriorBajar = new BotonExterior(4, false);
    
    // Botones de adentro: uno por piso, del 1 al 4.
    BotonInterior botonInterior1 = new BotonInterior(1);
    BotonInterior botonInterior2 = new BotonInterior(2);
    BotonInterior botonInterior3 = new BotonInterior(3);
    BotonInterior botonInterior4 = new BotonInterior(4);
    
    // El tablero para mostrar el estado.
    Tablero tablero = new Tablero(elevador.getPisoActual());

    // ¡El menú interactivo! Te deja elegir qué hacer con el elevador.
    Scanner scanner = new Scanner(System.in);
    while (true) {
        System.out.println("\n--- Menú ---");
        System.out.println("1. Subir");
        System.out.println("2. Bajar");
        System.out.println("3. Ir a un piso específico");
        System.out.println("4. Abrir puerta");
        System.out.println("5. Cerrar puerta");
        System.out.println("6. Mostrar piso actual");
        System.out.println("7. Presionar botón interior");
        System.out.println("8. Presionar botón exterior");
        System.out.println("9. Salir");
        System.out.println("--- ---- ---");
        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                elevador.subir(); // ¡Arriba!
                break;
            case 2:
                elevador.bajar(); // ¡Abajo!
                break;
            case 3:
                System.out.println("Ingrese el piso al que desea ir (1-4):");
                int piso = scanner.nextInt();
                elevador.irAPiso(piso); // ¡Directo al piso!
                break;
            case 4:
                elevador.abrirPuerta(); // ¡Puertas abiertas!
                break;
            case 5:
                elevador.cerrarPuerta(); // ¡Puertas cerradas!
                break;
            case 6:
                System.out.println("Piso actual: " + elevador.getPisoActual()); // ¿Dónde estamos?
                break;
            case 7:
                // ¡Presiona un botón de adentro! Eliges piso y el elevador va ahí.
                System.out.println("Seleccione el piso para presionar botón interior (1-4):");
                int pisoInterior = scanner.nextInt();
                if (pisoInterior >= 1 && pisoInterior <= 4) {
                    BotonInterior botonSeleccionado = null;
                    switch (pisoInterior) {
                        case 1: botonSeleccionado = botonInterior1; break;
                        case 2: botonSeleccionado = botonInterior2; break;
                        case 3: botonSeleccionado = botonInterior3; break;
                        case 4: botonSeleccionado = botonInterior4; break;
                    }
                    if (botonSeleccionado != null) {
                        botonSeleccionado.presionar(); // ¡Presionado!
                        elevador.irAPiso(pisoInterior); // Y nos movemos.
                    }
                } else {
                    System.out.println("Piso inválido."); // ¡Ese no vale!
                }
                break;
            case 8:
                // ¡Presiona un botón de afuera! Eliges piso y dirección, y el elevador viene.
                System.out.println("Seleccione el piso para presionar botón exterior (1-4):");
                int pisoExterior = scanner.nextInt();
                System.out.println("Dirección: 1. Subir, 2. Bajar");
                int dir = scanner.nextInt();
                boolean subir = (dir == 1);
                if (pisoExterior >= 1 && pisoExterior <= 4) {
                    BotonExterior botonSeleccionado = (pisoExterior == 1 && subir) ? botonExteriorSubir : 
                                                     (pisoExterior == 4 && !subir) ? botonExteriorBajar : null;
                    if (botonSeleccionado != null) {
                        botonSeleccionado.presionar(); // ¡Llamando!
                        elevador.irAPiso(pisoExterior); // El elevador responde.
                    } else {
                        System.out.println("Botón exterior no disponible para ese piso/dirección."); // ¡No hay botón ahí!
                    }
                } else {
                    System.out.println("Piso inválido."); // ¡Piso malo!
                }
                break;
            case 9:
                System.out.println("Saliendo..."); // ¡Adiós!
                scanner.close();
                return;
            default:
                System.out.println("Opción inválida."); // ¡Elige bien!
            }
        }
    }
}