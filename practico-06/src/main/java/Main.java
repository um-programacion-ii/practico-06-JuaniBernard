import services.Inicializador;

public class Main {
    public static void main(String[] args) {
        Inicializador.getInstancia().inicializarDatos();
        Inicializador.getInstancia().listarPacientesYMedicos();
        Inicializador.getInstancia().mostrarStockFarmacia();
    }
}
