package ec.com.orion.gestioncuentas.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteTo {

    private String identificacion;
    private String nombre;
    private String idCliente;
    private Long id;
    private boolean estado;
}
