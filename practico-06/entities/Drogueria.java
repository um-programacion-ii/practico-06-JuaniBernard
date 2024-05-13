package entities;

import services.Contenedor;

public class Drogueria {

    private Contenedor contenedor;

    public Drogueria() {
        contenedor = Contenedor.getInstancia();
    }

    // Método para entregar el stock
    public int entregarStock(int idPedido) {
        Pedido pedido = contenedor.getPedidoDAO().obtenerPedido(idPedido);
        return pedido.getCantidad();
    }
}
