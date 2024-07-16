package ec.com.orion.gestioncuentas.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import ec.com.orion.gestioncuentas.cliente.ClientesProxy;
import ec.com.orion.gestioncuentas.modelo.CuentaRequest;
import ec.com.orion.gestioncuentas.modelo.CuentaResponse;
import ec.com.orion.gestioncuentas.repositorio.CuentaRepositorio;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class CuentaServicio {

    private CuentaRepositorio cuentaRepositorio;
    private ClientesProxy clientesProxy;

    public List<CuentaResponse> obtenerTodasCuentas() {
        return cuentaRepositorio.findAll().stream().map(CuentaResponse::fromModel).toList();
    }

    public void registrarCuenta(CuentaRequest cuentaRequest) {
        clientesProxy.consultarClientePorId(cuentaRequest.getIdCliente())
        .map(cliente -> cuentaRequest.convertirAModelo()).subscribe(cuenta -> cuentaRepositorio.save(cuenta));
    }

}
