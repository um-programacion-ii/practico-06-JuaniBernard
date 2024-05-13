package daos.interfaces;

import entities.Medicamento;
import entities.Pedido;

import java.util.List;

public interface PedidoDAO {
    String agregarPedido(Pedido pedido);
    Pedido obtenerPedido(int id);
    List<Pedido> listarPedidos();
    String verEstado(int id);
    Medicamento mostrarMedicamento(int id);
}
