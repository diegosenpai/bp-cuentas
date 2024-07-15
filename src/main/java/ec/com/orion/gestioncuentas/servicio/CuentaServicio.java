package ec.com.orion.gestioncuentas.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import ec.com.orion.gestioncuentas.modelo.CuentaRequest;
import ec.com.orion.gestioncuentas.modelo.CuentaResponse;
import ec.com.orion.gestioncuentas.repositorio.CuentaRepositorio;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CuentaServicio {

    private CuentaRepositorio cuentaRepositorio;
    private ClienteServicio clienteServicio;

    

    public List<CuentaResponse> obtenerTodasCuentas() {
        return cuentaRepositorio.findAll().stream().map(CuentaResponse::fromModel).toList();
    }

    public void registrarCuenta(CuentaRequest cuentaRequest) {
        clienteServicio.obtenerClientePorId(cuentaRequest.getIdCliente());
        cuentaRepositorio.save(cuentaRequest.convertirAModelo());
    }

}
