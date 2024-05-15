package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Pedido {
    private int id;
    private Medicamento medicamento;
    private int cantidad;
    private boolean estado;

    public Pedido(int id, Medicamento medicamento, int cantidad) {
        this.id = id;
        this.medicamento = medicamento;
        this.cantidad = cantidad;
        this.estado = false;
    }
}
