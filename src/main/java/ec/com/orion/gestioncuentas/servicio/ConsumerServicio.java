package ec.com.orion.gestioncuentas.servicio;

import org.springframework.stereotype.Service;

import ec.com.orion.gestioncuentas.modelo.ClienteTo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class ConsumerServicio {

    public void consumirAsync(ClienteTo cliente){
        log.info("y el iris los cambios");
        log.info(cliente.toString());
    }

}
