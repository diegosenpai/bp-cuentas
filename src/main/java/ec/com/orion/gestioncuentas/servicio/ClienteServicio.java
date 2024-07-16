package ec.com.orion.gestioncuentas.servicio;

import org.springframework.stereotype.Service;

import ec.com.orion.gestioncuentas.cliente.ClientesProxy;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class ClienteServicio {

    private ConsumerServicio consumerServicio;
    private ClientesProxy clientesProxy;

    public void obtenerClientePorId(Long idCliente){
        log.info(">>empezar porque si");  
         clientesProxy.consultarClientePorId(idCliente).subscribe(System.out :: println);
         log.info("el azul me da cielo");
    }




}
