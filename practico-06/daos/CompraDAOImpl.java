package daos;

import daos.interfaces.CompraDAO;
import entities.Compra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompraDAOImpl implements CompraDAO {
    private Map<Integer, Compra> compras;

    public CompraDAOImpl() {
        compras = new HashMap<>();
    }

    @Override
    public String agregarCompra(Compra compra) {
        compras.put(compra.getId(), compra);
        return "Compra agregada con exito";
    }

    @Override
    public Compra obtenerCompra(int id) {
        return compras.get(id);
    }

    @Override
    public List<Compra> listarCompras() {
        return new ArrayList<>(compras.values());
    }

    @Override
    public String verEstado(int id) {
        Compra compra = compras.get(id);
        boolean estado = compra.getEstado();
        String result = null;
        if (estado) {
            result = "Compra finalizada";
        }
        else {
            result = "Compra en proceso";
        }
        return result;
    }

    @Override
    public String limpiarDatos() {
        compras.clear();
        return "Compras eliminadas con exito";
    }
}
