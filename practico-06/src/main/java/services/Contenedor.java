package services;

import daos.*;
import daos.interfaces.*;

public class Contenedor {

    private static Contenedor instancia;

    private ObraSocialDAO obraSocialDAO;
    private MedicoDAO medicoDAO;
    private EspecialidadDAO especialidadDAO;
    private PacienteDAO pacienteDAO;
    private TurnoDAO turnoDAO;
    private RecetaDAO recetaDAO;
    private CompraDAO compraDAO;
    private PedidoDAO pedidoDAO;
    private MedicamentoDAO medicamentoDAO;

    private Contenedor() {
        obraSocialDAO = new ObraSocialDAOImpl();
        medicoDAO = new MedicoDAOImpl();
        especialidadDAO = new EspecialidadDAOImpl();
        pacienteDAO = new PacienteDAOImpl();
        turnoDAO = new TurnoDAOImpl();
        recetaDAO = new RecetaDAOImpl();
        compraDAO = new CompraDAOImpl();
        pedidoDAO = new PedidoDAOImpl();
        medicamentoDAO = new MedicamentoDAOImpl();
    }

    public static Contenedor getInstancia() {
        if (instancia == null) {
            instancia = new Contenedor();
        }
        return instancia;
    }

    // Getters para los DAOs
    public ObraSocialDAO getObraSocialDAO() {
        return obraSocialDAO;
    }

    public MedicoDAO getMedicoDAO() {
        return medicoDAO;
    }

    public EspecialidadDAO getEspecialidadDAO() {
        return especialidadDAO;
    }

    public PacienteDAO getPacienteDAO() {
        return pacienteDAO;
    }

    public TurnoDAO getTurnoDAO() {
        return turnoDAO;
    }

    public RecetaDAO getRecetaDAO() {
        return recetaDAO;
    }

    public CompraDAO getCompraDAO() {
        return compraDAO;
    }

    public PedidoDAO getPedidoDAO() {
        return pedidoDAO;
    }

    public MedicamentoDAO getMedicamentoDAO() {
        return medicamentoDAO;
    }
}
