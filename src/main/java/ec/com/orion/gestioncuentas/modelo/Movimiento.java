package ec.com.orion.gestioncuentas.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Getter
    @Setter
    private BigDecimal saldo;

    @Getter
    @Setter
    private BigDecimal valor;

    @Getter
    @Setter
    private LocalDateTime fechaMovimiento;

    @Getter
    @Setter
    private TipoMovimiento tipoMovimiento;

    @Version
    private Long version;

    @ManyToOne
    private Cuenta cuenta;

}
