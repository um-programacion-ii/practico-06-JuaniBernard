package services;

import entities.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Inicializador {

    private static Inicializador instancia;
    private Contenedor contenedor;
    private Random random;

    private Inicializador() {
        contenedor = Contenedor.getInstancia();
        random = new Random();
    }

    public static Inicializador getInstancia() {
        if (instancia == null) {
            instancia = new Inicializador();
        }
        return instancia;
    }

    public void inicializarDatos() {
        // Inicializar Obras Sociales
        List<ObraSocial> obraSociales = new ArrayList<>();
        obraSociales.add(new ObraSocial("OSDE"));
        obraSociales.add(new ObraSocial("Swiss Medical"));
        obraSociales.forEach(os -> contenedor.getObraSocialDAO().agregarObraSocial(os));

        // Inicializar Especialidades
        List<Especialidad> especialidades = new ArrayList<>();
        especialidades.add(new Especialidad("Cardiología"));
        especialidades.add(new Especialidad("Traumatología"));
        especialidades.add(new Especialidad("Pediatría"));
        especialidades.add(new Especialidad("Dermatología"));
        especialidades.forEach(e -> contenedor.getEspecialidadDAO().agregarEspecialidad(e));

        // Inicializar Médicos
        int j = 0;
        for (ObraSocial obraSocial : obraSociales) {
            for (int i = 0; i < 4; i++) {
                Especialidad especialidad = obtenerEspecialidadAleatoria();
                Medico medico = new Medico("Medico " + (j + 1), 1000 + j, especialidad, new ArrayList<>(List.of(obraSocial)), random.nextBoolean());
                contenedor.getMedicoDAO().agregarMedico(medico);
                j = j + 1;
            }
        }

        // Inicializar Medicamentos
        List<Medicamento> medicamentos = new ArrayList<>();
        medicamentos.add(new Medicamento(1, "Ibuprofeno"));
        medicamentos.add(new Medicamento(2, "Paracetamol"));
        medicamentos.add(new Medicamento(3, "Amoxicilina"));
        medicamentos.add(new Medicamento(4, "Diclofenac"));
        medicamentos.forEach(m -> contenedor.getMedicamentoDAO().agregarMedicamento(m));

        // Inicializar Pacientes
        for (int i = 0; i < 10; i++) {
            ObraSocial obraSocial = obtenerObraSocialAleatoria();
            Paciente paciente = new Paciente("Paciente " + (i + 1), 2000 + i, obraSocial);
            contenedor.getPacienteDAO().agregarPaciente(paciente);
        }

        // Inicializar Farmacia con stock
        inicializarFarmacia(medicamentos);

        // Inicializar Drogueria (no necesita stock, es infinito)
        Drogueria drogueria = Drogueria.getInstancia();
    }

    private void inicializarFarmacia(List<Medicamento> medicamentos) {
        Farmacia farmacia = Farmacia.getInstancia();
        for (Medicamento medicamento : medicamentos) {
            farmacia.agregarStock(medicamento, random.nextInt(100) + 1); // Stock aleatorio de 1 a 100
        }
    }

    public void listarPacientesYMedicos() {
        List<Paciente> pacientes = contenedor.getPacienteDAO().listarPacientes();
        System.out.println("Pacientes:");
        pacientes.forEach(p -> System.out.println(p.getNombre() + " - DNI: " + p.getDocumento() +
                " - Obra Social: " + p.getObraSocial().getNombre()));

        List<Medico> medicos = contenedor.getMedicoDAO().listarMedicos();
        System.out.println("\nMédicos:");
        medicos.forEach(m -> {
            System.out.println(m.getNombre() + " - DNI: " + m.getDocumento() +
                    " - Especialidad: " + m.getEspecialidad().getNombre() +
                    " - Obra Social(es): " +
                    m.getObrasSociales().stream()
                            .map(ObraSocial::getNombre)
                            .collect(Collectors.joining(", ")));
        });
    }

    public void mostrarStockFarmacia() {
        Farmacia farmacia = Farmacia.getInstancia();
        System.out.println("\nStock de la Farmacia:");
        farmacia.getStock().forEach((medicamento, cantidad) -> {
            System.out.println(medicamento.getNombre() + ": " + cantidad);
        });
    }

    private Especialidad obtenerEspecialidadAleatoria() {
        List<Especialidad> especialidades = contenedor.getEspecialidadDAO().listarEspecialidades();
        int indice = random.nextInt(especialidades.size());
        return especialidades.get(indice);
    }

    private ObraSocial obtenerObraSocialAleatoria() {
        List<ObraSocial> obraSociales = contenedor.getObraSocialDAO().listarObrasSociales();
        int indice = random.nextInt(obraSociales.size());
        return obraSociales.get(indice);
    }
}
