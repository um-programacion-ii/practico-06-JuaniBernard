package services;


import entities.*;

public class GestionFarmaciaService {

    private static GestionFarmaciaService instancia;
    private Contenedor contenedor;
    private Farmacia farmacia;
    private Drogueria drogueria;

    private GestionFarmaciaService() {
        contenedor = Contenedor.getInstancia();
        farmacia = new Farmacia();
        drogueria = new Drogueria();
    }

    public static GestionFarmaciaService getInstancia() {
        if (instancia == null) {
            instancia = new GestionFarmaciaService();
        }
        return instancia;
    }

    public String iniciarCompra(Paciente paciente, Receta receta) {
        int idCompra = contenedor.getCompraDAO().listarCompras().size() + 1;
        Compra compra = new Compra(idCompra, paciente, receta);
        return contenedor.getCompraDAO().agregarCompra(compra);
    }

    public String finalizarCompra(int idCompra) {
        Compra compra = contenedor.getCompraDAO().obtenerCompra(idCompra);
        compra.setEstado(true);
        reducirStockFarmacia(compra.getReceta());
        return contenedor.getCompraDAO().verEstado(idCompra);
    }

    private void reducirStockFarmacia(Receta receta) {
        for (Medicamento medicamento : receta.getMedicamentos()) {
            boolean suficiente = farmacia.hayStockSuficiente(medicamento);
            if (suficiente) {
                farmacia.reducirStock(medicamento);
            } else {
                solicitarMedicamentoADrogueria(medicamento);
            }
        }
    }

    private void solicitarMedicamentoADrogueria(Medicamento medicamento) {
        int idPedido = contenedor.getPedidoDAO().listarPedidos().size() + 1;
        Pedido pedido = new Pedido(idPedido, medicamento, 5);
        contenedor.getPedidoDAO().agregarPedido(pedido);
        // Lógica para finalizar el pedido
        int stock = drogueria.entregarStock(pedido);
        pedido.setEstado(true);
        String estado = contenedor.getPedidoDAO().verEstado(idPedido);
        System.out.println(estado);
        // Actualizar el stock de la farmacia
        farmacia.agregarStock(medicamento, stock);
    }
}
