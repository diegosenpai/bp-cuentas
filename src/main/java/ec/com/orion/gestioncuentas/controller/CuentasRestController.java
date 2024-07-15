package ec.com.orion.gestioncuentas.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.com.orion.gestioncuentas.modelo.CuentaRequest;
import ec.com.orion.gestioncuentas.modelo.CuentaResponse;
import ec.com.orion.gestioncuentas.servicio.CuentaServicio;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/cuentas")
@AllArgsConstructor
public class CuentasRestController {

    private CuentaServicio cuentaServicio;
    
    


    @GetMapping
    public List<CuentaResponse> obtenerCuentas() {
        return cuentaServicio.obtenerTodasCuentas();
    }

     @PostMapping
     public void registrarCuenta(@RequestBody CuentaRequest cuenta){
        cuentaServicio.registrarCuenta(cuenta);
     }


}
