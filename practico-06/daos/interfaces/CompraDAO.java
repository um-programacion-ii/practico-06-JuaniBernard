package daos.interfaces;

import entities.Compra;

import java.util.List;

public interface CompraDAO {
    String agregarCompra(Compra compra);
    Compra obtenerCompra(int documento);
    List<Compra> listarCompras();
    String verEstado(int id);
}
