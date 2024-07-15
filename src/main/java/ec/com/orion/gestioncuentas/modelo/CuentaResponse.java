package ec.com.orion.gestioncuentas.modelo;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CuentaResponse {

    private String numeroCuenta;
    private boolean estado;
    private BigDecimal saldo;
    private TipoCuenta tipoCuenta;

    public static CuentaResponse fromModel(Cuenta cuenta) {
        return CuentaResponse.builder().numeroCuenta(cuenta.getNumeroCuenta()).estado(cuenta.isEstado()).saldo(cuenta.getSaldoInicial()).tipoCuenta(cuenta.getTipoCuenta()).build();
    }
}
