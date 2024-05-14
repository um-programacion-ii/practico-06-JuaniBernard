package tests;

import entities.Medico;
import entities.Paciente;
import entities.Receta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.Contenedor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RecetaDAOImplTest {

    private Contenedor contenedor;

    @BeforeEach
    void setUp() {
        contenedor = Contenedor.getInstancia();
    }

    @Test
    void agregarReceta() {
        Paciente paciente = new Paciente("Juan Perez", 12345678, null);
        Medico medico = new Medico("Ana García", 87654321, null, true);
        Receta receta = new Receta(1, null, paciente, medico);
        String resultado = contenedor.getRecetaDAO().agregarReceta(receta);
        assertEquals("Receta agregada con exito", resultado);
    }

    @Test
    void obtenerReceta() {
        Paciente paciente = new Paciente("Juan Perez", 12345678, null);
        Medico medico = new Medico("Ana García", 87654321, null, true);
        Receta receta = new Receta(1, null, paciente, medico);
        contenedor.getRecetaDAO().agregarReceta(receta);
        Receta recetaObtenida = contenedor.getRecetaDAO().obtenerReceta(1);
        assertEquals(receta, recetaObtenida);
    }

    @Test
    void listarRecetas() {
        Paciente paciente = new Paciente("Juan Perez", 12345678, null);
        Medico medico = new Medico("Ana García", 87654321, null, true);
        Receta receta1 = new Receta(1, null, paciente, medico);
        Receta receta2 = new Receta(2, null, paciente, medico);
        contenedor.getRecetaDAO().agregarReceta(receta1);
        contenedor.getRecetaDAO().agregarReceta(receta2);
        List<Receta> recetas = contenedor.getRecetaDAO().listarRecetas();
        assertEquals(2, recetas.size());
    }
}
