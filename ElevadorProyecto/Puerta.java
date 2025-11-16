package ElevadorProyecto;

public class Puerta {
    private boolean abierta;
    private Thread autoCerrarThread;

    public Puerta() {
        this.abierta = false;
    }

    public void abrir() {
        abierta = true;
        System.out.println("Puerta abierta.");
        // Iniciar hilo para cerrar automáticamente después de 3 segundos
        if (autoCerrarThread != null && autoCerrarThread.isAlive()) {
            autoCerrarThread.interrupt();
        }
        autoCerrarThread = new Thread(() -> {
            try {
                Thread.sleep(3000); // 3 segundos
                if (abierta) { // Verificar si aún está abierta
                    cerrar();
                }
            } catch (InterruptedException e) {
                // Hilo interrumpido, no cerrar
            }
        });
        autoCerrarThread.start();
    }

    public void cerrar() {
        abierta = false;
        System.out.println("Puerta cerrada.");
        if (autoCerrarThread != null) {
            autoCerrarThread.interrupt();
        }
    }

    public boolean isAbierta() {
        return abierta;
    }
}