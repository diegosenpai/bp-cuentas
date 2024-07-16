package ec.com.orion.gestioncuentas.cliente;

import java.util.UUID;

import org.springframework.http.ProblemDetail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;

import ec.com.orion.gestioncuentas.excepcion.IntegracionClienteExcepcion;
import ec.com.orion.gestioncuentas.modelo.ClienteTo;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class ClientesProxy {

    private WebClient webClient;
    

    public ClientesProxy(@Value("${clientes.baseUrl}")String baseUrl){
         this.webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .filter(ExchangeFilterFunction.ofRequestProcessor(
                        request -> Mono.just(ClientRequest.from(request)
                                .header("X-Trace-Id", UUID.randomUUID().toString())
                                .build())
                        ))
                .build();
    }


    public Mono<ClienteTo> consultarClientePorId(Long idCliente){
        return this.webClient.get().uri(String.format("/%d",idCliente))
        .exchangeToMono(response -> !response.statusCode().isError() ? 
        response.bodyToMono(ClienteTo.class).filter(c -> c.isEstado()):
        response.bodyToMono(ProblemDetail.class).
        flatMap(problemDetail -> Mono.error(new IntegracionClienteExcepcion(problemDetail.getDetail()))));
    }

}
