package ec.com.orion.gestioncuentas.modelo;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CuentaRequest {

    private String numeroCuenta;
    private TipoCuenta tipoCuenta;
    private BigDecimal saldoInicial;
    private boolean estado;
    private Long idCliente;

    public Cuenta convertirAModelo() {
        return Cuenta.builder().numeroCuenta(this.numeroCuenta).estado(this.estado).saldoInicial(this.saldoInicial).idCliente(this.idCliente).build();

    }
}
