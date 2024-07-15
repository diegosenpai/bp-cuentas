package ec.com.orion.gestioncuentas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.com.orion.gestioncuentas.modelo.Movimiento;

public interface MovimientoRepositorio extends JpaRepository<Movimiento,Long> {

}
