package services;

import entities.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.Contenedor;
import services.GestionFarmaciaService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GestionFarmaciaServiceTest {

    private GestionFarmaciaService gestionFarmaciaService;
    private Contenedor contenedor;
    private Farmacia farmacia;

    @BeforeEach
    void setUp() {
        contenedor = Contenedor.getInstancia();
        gestionFarmaciaService = GestionFarmaciaService.getInstancia();
        farmacia = Farmacia.getInstancia();

        // Agregar datos de prueba
        Medicamento medicamento1 = new Medicamento(1, "Paracetamol");
        Medicamento medicamento2 = new Medicamento(2, "Ibuprofeno");
        Medicamento medicamento3 = new Medicamento(3, "Fluoxetina");
        contenedor.getMedicamentoDAO().agregarMedicamento(medicamento1);
        contenedor.getMedicamentoDAO().agregarMedicamento(medicamento2);
        contenedor.getMedicamentoDAO().agregarMedicamento(medicamento3);

        // Agregar stock inicial a la farmacia
        farmacia.agregarStock(medicamento1, 2);
        farmacia.agregarStock(medicamento2, 3);
        farmacia.agregarStock(medicamento3, 0);

        // Limpiar los DAOs del contenedor
        contenedor.getCompraDAO().limpiarDatos();
        contenedor.getPedidoDAO().limpiarDatos();
    }

    @Test
    void iniciarCompra() {
        Paciente paciente = new Paciente("Juan Perez", 12345678, null);
        Medico medico = new Medico("Ana García", 87654321, null, null, true);
        List<Medicamento> medicamentos = new ArrayList<>();
        medicamentos.add(contenedor.getMedicamentoDAO().obtenerMedicamento(1));
        medicamentos.add(contenedor.getMedicamentoDAO().obtenerMedicamento(2));
        Receta receta = new Receta(1, medicamentos, paciente, medico);
        String resultado = gestionFarmaciaService.iniciarCompra(paciente, receta);
        assertEquals("Compra agregada con exito", resultado);
    }

    @Test
    void finalizarCompra() {
        Paciente paciente = new Paciente("Juan Perez", 12345678, null);
        Medico medico = new Medico("Ana García", 87654321, null, null, true);
        List<Medicamento> medicamentos = new ArrayList<>();
        medicamentos.add(contenedor.getMedicamentoDAO().obtenerMedicamento(1));
        medicamentos.add(contenedor.getMedicamentoDAO().obtenerMedicamento(2));
        Receta receta = new Receta(1, medicamentos, paciente, medico);
        Compra compra = new Compra(1, paciente, receta);
        contenedor.getCompraDAO().agregarCompra(compra);
        String resultado = gestionFarmaciaService.finalizarCompra(1);
        assertEquals("Compra finalizada", resultado);
    }

    @Test
    void reducirStockFarmacia() {
        Paciente paciente = new Paciente("Juan Perez", 12345678, null);
        Medico medico = new Medico("Ana García", 87654321, null, null, true);
        Medicamento medicamento1 = contenedor.getMedicamentoDAO().obtenerMedicamento(1);
        Medicamento medicamento2 = contenedor.getMedicamentoDAO().obtenerMedicamento(2);
        Medicamento medicamento3 = contenedor.getMedicamentoDAO().obtenerMedicamento(3);

        // Crear receta con dos medicamentos
        List<Medicamento> medicamentos = new ArrayList<>();
        medicamentos.add(medicamento1);
        medicamentos.add(medicamento2);
        medicamentos.add(medicamento3);
        Receta receta = new Receta(1, medicamentos, paciente, medico);

        // Ejecutar el método bajo prueba
        gestionFarmaciaService.reducirStockFarmacia(receta);

        // Verificar el stock de la farmacia
        assertEquals(1, farmacia.getStock().get(medicamento1));
        assertEquals(2, farmacia.getStock().get(medicamento2));

        // Verificar que se realizó un pedido a la droguería
        List<Pedido> pedidos = contenedor.getPedidoDAO().listarPedidos();
        assertEquals(1, pedidos.size());
    }

    @Test
    void solicitarMedicamentoADrogueria() {
        Medicamento medicamento3 = contenedor.getMedicamentoDAO().obtenerMedicamento(3);

        // Ejecutar el método bajo prueba
        gestionFarmaciaService.solicitarMedicamentoADrogueria(medicamento3);

        // Verificar que se realizó un pedido a la droguería
        List<Pedido> pedidos = contenedor.getPedidoDAO().listarPedidos();
        System.out.println(pedidos);
        assertEquals(1, pedidos.size());
        assertEquals(medicamento3, pedidos.get(0).getMedicamento());
        assertEquals(5, pedidos.get(0).getCantidad());

        // Verificar que el stock de la farmacia se actualizó
        assertEquals(5, farmacia.getStock().get(medicamento3)); // 0 inicial + 5 del pedido
    }
}
