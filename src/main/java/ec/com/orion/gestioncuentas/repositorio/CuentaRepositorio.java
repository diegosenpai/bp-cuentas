package ec.com.orion.gestioncuentas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.com.orion.gestioncuentas.modelo.Cuenta;

public interface CuentaRepositorio extends JpaRepository<Cuenta,Long> {

}
