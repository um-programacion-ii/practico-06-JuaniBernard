package entities;

public class Drogueria {

    public Drogueria() {
    }

    // Método para entregar el stock, simulando ser infinito
    public int entregarStock(Pedido pedido) {
        return pedido.getCantidad();
    }
}
