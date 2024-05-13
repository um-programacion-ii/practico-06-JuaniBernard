package daos;

import daos.interfaces.PedidoDAO;
import entities.Medicamento;
import entities.Pedido;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PedidoDAOImpl implements PedidoDAO {
    private Map<Integer, Pedido> pedidos;

    public PedidoDAOImpl() {
        pedidos = new HashMap<>();
    }

    @Override
    public String agregarPedido(Pedido pedido) {
        pedidos.put(pedido.getId(), pedido);
        return "Pedido agregado con exito";
    }

    @Override
    public Pedido obtenerPedido(int id) {
        return pedidos.get(id);
    }

    @Override
    public List<Pedido> listarPedidos() {
        return new ArrayList<>(pedidos.values());
    }

    @Override
    public String verEstado(int id) {
        Pedido pedido = pedidos.get(id);
        boolean estado = pedido.getEstado();
        String result = null;
        if (estado) {
            result = "Pedido finalizado";
        }
        else {
            result = "Pedido en proceso";
        }
        return result;
    }

    @Override
    public Medicamento mostrarMedicamento(int id) {
        Pedido pedido = pedidos.get(id);
        return pedido.getMedicamento();
    }
}
