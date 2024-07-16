package ec.com.orion.gestioncuentas.excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class IntegracionClienteExcepcion extends RuntimeException {

    public IntegracionClienteExcepcion(String mensaje) {
        super(mensaje);
    }

    public ProblemDetail transformarAProblemDetail() {
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, getMessage());
    }
}
