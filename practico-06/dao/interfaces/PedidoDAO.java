package dao.interfaces;

import entity.Medicamento;
import entity.Pedido;

import java.util.List;

public interface PedidoDAO {
    String agregarPedido(Pedido pedido);
    Pedido obtenerPedido(int id);
    List<Pedido> listarPedidos();
    String verEstado(int id);
//    List<Medicamento> mostrarMedicamentos();
}
