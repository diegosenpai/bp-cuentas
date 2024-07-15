package ec.com.orion.gestioncuentas.servicio;

import org.springframework.stereotype.Service;

import ec.com.orion.gestioncuentas.cliente.ClientesProxy;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClienteServicio {

    private ClientesProxy clientesProxy;

    public void obtenerClientePorId(Long idCliente){
         clientesProxy.consultarClientePorId(idCliente).subscribe(System.out :: println);
    }




}
