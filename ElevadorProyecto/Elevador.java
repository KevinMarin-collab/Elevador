package ProyectoElevador;

// Esta es la clase principal del elevador, como el cerebro que controla todo.
// Maneja dónde estamos, cuántos pisos hay, y coordina con las puertas y el tablero.
public class Elevador {
    // Estos son los datos internos del elevador: dónde estamos ahora, cuántos pisos totales,
    // y referencias a las puertas y el tablero para mostrar info.
    private int pisoActual;
    private int numeroPisos;
    private Puerta puertaElevador;
    private Tablero tablero;

    // Constructor: ¡Bienvenido al elevador! Lo configuramos con el número de pisos y empezamos en el 1.
    public Elevador(int numeroPisos) {
        this.numeroPisos = numeroPisos;
        this.pisoActual = 1; // Siempre empezamos en el primer piso, como en la vida real.
        this.puertaElevador = new Puerta(); // Creamos las puertas.
        this.tablero = new Tablero(pisoActual); // Y el tablero para mostrar el estado.
    }

    // ¡Vamos arriba! Este método sube un piso, pero solo si las puertas están cerradas y no estamos en el último.
    public void subir() {
        if (!puertaElevador.isAbierta()) {
            if (pisoActual < numeroPisos) {
                moverAPiso(pisoActual + 1, "Subiendo");
            } else {
                System.out.println("Ya estás en el último piso."); // ¡No podemos ir más arriba!
            }
        } else {
            System.out.println("No se puede mover: las puertas están abiertas."); // Seguridad primero, amigo.
        }
    }

    // ¡Vamos abajo! Similar a subir, pero bajando, y solo si no estamos en el primero.
    public void bajar() {
        if (!puertaElevador.isAbierta()) {
            if (pisoActual > 1) {
                moverAPiso(pisoActual - 1, "Bajando");
            } else {
                System.out.println("Ya estás en el primer piso."); // ¡No hay más abajo!
            }
        } else {
            System.out.println("No se puede mover: las puertas están abiertas."); // Puertas abiertas = no moverse.
        }
    }

    // ¡Vamos directo a un piso! El usuario elige uno, y nos movemos ahí, pero con las mismas reglas de seguridad.
    public void irAPiso(int piso) {
        if (!puertaElevador.isAbierta()) {
            if (piso >= 1 && piso <= numeroPisos) {
                String direccion = (piso > pisoActual) ? "Subiendo" : (piso < pisoActual) ? "Bajando" : "Estacionado";
                moverAPiso(piso, direccion);
            } else {
                System.out.println("Piso inválido."); // ¡Ese piso no existe en este edificio!
            }
        } else {
            System.out.println("No se puede mover: las puertas están abiertas."); // Regla de oro: puertas cerradas para mover.
        }
    }

    // Método privado y mágico: Simula el viaje piso por piso, con pausas para que parezca real.
    // Muestra mensajes mientras viaja y abre puertas al llegar.
    private void moverAPiso(int pisoDestino, String direccion) {
        int paso = (pisoDestino > pisoActual) ? 1 : -1; // Decidimos si subimos o bajamos.
        while (pisoActual != pisoDestino) {
            // Primero mostramos dónde estamos y adónde vamos, antes de "movernos".
            tablero.mostrarEstado(pisoActual, direccion + " al piso " + pisoDestino);
            try {
                Thread.sleep(2000); // ¡Pausa de 2 segundos! Como si el viaje tomara tiempo.
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Si algo interrumpe, lo manejamos.
            }
            // Ahora sí, avanzamos al siguiente piso.
            pisoActual += paso;
        }
        // ¡Llegamos! Avisamos y abrimos puertas automáticamente.
        System.out.println("Piso " + pisoActual + ", abriendo puertas.");
        abrirPuerta();
    }

    // Métodos simples para las puertas: abrir y cerrar, delegando a la clase Puerta.
    public void abrirPuerta() {
        puertaElevador.abrir();
    }

    public void cerrarPuerta() {
        puertaElevador.cerrar();
    }

    // Solo para saber en qué piso estamos ahora.
    public int getPisoActual() {
        return pisoActual;
    }
}