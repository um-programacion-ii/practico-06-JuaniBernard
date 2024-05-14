package tests;

import entities.Medicamento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.Contenedor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MedicamentoDAOImplTest {

    private Contenedor contenedor;

    @BeforeEach
    void setUp() {
        contenedor = Contenedor.getInstancia();
    }

    @Test
    void agregarMedicamento() {
        Medicamento medicamento = new Medicamento(1, "Paracetamol");
        String resultado = contenedor.getMedicamentoDAO().agregarMedicamento(medicamento);
        assertEquals("Medicamento agregado con exito", resultado);
    }

    @Test
    void obtenerMedicamento() {
        Medicamento medicamento = new Medicamento(1, "Paracetamol");
        contenedor.getMedicamentoDAO().agregarMedicamento(medicamento);
        Medicamento medicamentoObtenido = contenedor.getMedicamentoDAO().obtenerMedicamento(1);
        assertEquals(medicamento, medicamentoObtenido);
    }

    @Test
    void listarMedicamentos() {
        Medicamento medicamento1 = new Medicamento(1, "Paracetamol");
        Medicamento medicamento2 = new Medicamento(2, "Ibuprofeno");
        contenedor.getMedicamentoDAO().agregarMedicamento(medicamento1);
        contenedor.getMedicamentoDAO().agregarMedicamento(medicamento2);
        List<Medicamento> medicamentos = contenedor.getMedicamentoDAO().listarMedicamentos();
        assertEquals(2, medicamentos.size());
    }

    @Test
    void eliminarMedicamento() {
        Medicamento medicamento = new Medicamento(1, "Paracetamol");
        contenedor.getMedicamentoDAO().agregarMedicamento(medicamento);
        String resultado = contenedor.getMedicamentoDAO().eliminarMedicamento(1);
        assertEquals("Medicamento eliminado con exito", resultado);
        assertNull(contenedor.getMedicamentoDAO().obtenerMedicamento(1));
    }

    @Test
    void actualizarMedicamento() {
        Medicamento medicamento = new Medicamento(1, "Paracetamol");
        contenedor.getMedicamentoDAO().agregarMedicamento(medicamento);
        medicamento.setNombre("Paracetamol 500mg");
        String resultado = contenedor.getMedicamentoDAO().actualizarMedicamento(medicamento);
        assertEquals("Medicamento actualizado con exito", resultado);
        Medicamento medicamentoActualizado = contenedor.getMedicamentoDAO().obtenerMedicamento(1);
        assertEquals("Paracetamol 500mg", medicamentoActualizado.getNombre());
    }
}
