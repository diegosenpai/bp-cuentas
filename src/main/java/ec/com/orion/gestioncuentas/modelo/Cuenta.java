package ec.com.orion.gestioncuentas.modelo;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Getter
    @Setter
    private String numeroCuenta;
    @Getter
    @Setter
    private BigDecimal saldoInicial;
    @Getter
    @Setter
    private boolean estado;
    
    @Version
    @Getter
    @Setter
    private Long version;
    @Getter
    @Setter
    private TipoCuenta tipoCuenta;
    
    @OneToMany(mappedBy="cuenta")
    private List<Movimiento> movimientos;

    @Getter
    @Setter
    private Long idCliente;

    
    public List<Movimiento> getMovimientos(){
    	return Collections.unmodifiableList(movimientos);
    }
    
    public void addMovimiento(Movimiento unMovimiento) {
    	this.movimientos.add(unMovimiento);
    }

}
