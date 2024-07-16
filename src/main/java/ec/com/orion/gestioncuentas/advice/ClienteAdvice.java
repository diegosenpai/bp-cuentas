package ec.com.orion.gestioncuentas.advice;

import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import ec.com.orion.gestioncuentas.excepcion.IntegracionClienteExcepcion;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class ClienteAdvice {

    

    @ExceptionHandler(IntegracionClienteExcepcion.class)
    public ProblemDetail gestionarExcepcionIntegracion(IntegracionClienteExcepcion ex){
        log.info("Deberia ingresar a capturar la excepcion");
        return ex.transformarAProblemDetail();
    }


}
