package tests;

import entities.Medicamento;
import entities.Pedido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.Contenedor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoDAOImplTest {

    private Contenedor contenedor;

    @BeforeEach
    void setUp() {
        contenedor = Contenedor.getInstancia();
    }

    @Test
    void agregarPedido() {
        Medicamento medicamento = new Medicamento(1, "Paracetamol");
        Pedido pedido = new Pedido(1, medicamento, 5);
        String resultado = contenedor.getPedidoDAO().agregarPedido(pedido);
        assertEquals("Pedido agregado con exito", resultado);
    }

    @Test
    void obtenerPedido() {
        Medicamento medicamento = new Medicamento(1, "Paracetamol");
        Pedido pedido = new Pedido(1, medicamento, 5);
        contenedor.getPedidoDAO().agregarPedido(pedido);
        Pedido pedidoObtenido = contenedor.getPedidoDAO().obtenerPedido(1);
        assertEquals(pedido, pedidoObtenido);
    }

    @Test
    void listarPedidos() {
        Medicamento medicamento1 = new Medicamento(1, "Paracetamol");
        Medicamento medicamento2 = new Medicamento(2, "Ibuprofeno");
        Pedido pedido1 = new Pedido(1, medicamento1, 5);
        Pedido pedido2 = new Pedido(2, medicamento2, 10);
        contenedor.getPedidoDAO().agregarPedido(pedido1);
        contenedor.getPedidoDAO().agregarPedido(pedido2);
        List<Pedido> pedidos = contenedor.getPedidoDAO().listarPedidos();
        assertEquals(2, pedidos.size());
    }

    @Test
    void verEstado() {
        Medicamento medicamento = new Medicamento(1, "Paracetamol");
        Pedido pedido = new Pedido(1, medicamento, 5);
        contenedor.getPedidoDAO().agregarPedido(pedido);
        String estado = contenedor.getPedidoDAO().verEstado(1);
        assertEquals("Pedido en proceso", estado);
    }

    @Test
    void mostrarMedicamento() {
        Medicamento medicamento = new Medicamento(1, "Paracetamol");
        Pedido pedido = new Pedido(1, medicamento, 5);
        contenedor.getPedidoDAO().agregarPedido(pedido);
        Medicamento medicamentoObtenido = contenedor.getPedidoDAO().mostrarMedicamento(1);
        assertEquals(medicamento, medicamentoObtenido);
    }

    @Test
    void limpiarDatos() {
        Medicamento medicamento = new Medicamento(1, "Paracetamol");
        Pedido pedido = new Pedido(1, medicamento, 5);
        contenedor.getPedidoDAO().agregarPedido(pedido);
        assertFalse(contenedor.getPedidoDAO().listarPedidos().isEmpty());
        String resultado = contenedor.getPedidoDAO().limpiarDatos();
        assertEquals("Pedidos eliminados con exito", resultado);
        assertTrue(contenedor.getPedidoDAO().listarPedidos().isEmpty());
    }
}
