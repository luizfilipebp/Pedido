package br.com.fiap.infrastructure.exemplo;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@Log4j2
public class TesteController {
    private final EstoquePedidoGateway estoquePedidoGateway;


    @GetMapping("/teste/{id}")
    public void teste(@PathVariable Long id) {
//        var estoqueDTO = estoquePedidoGateway.removerEstoque(new GenericMessage<>(new EstoqueDTO(1L, 1L, 1)));

//        Message<String> requestMessage = MessageBuilder.withPayload("l"). setHeader("id", 1L).build();
        Message<EstoqueDTO> estoqueDTOMessage = estoquePedidoGateway.removerEstoque(id.toString());
//        ResponseEntity<?> payload = (ResponseEntity<?>) message.getPayload();

        log.info(estoqueDTOMessage.getHeaders().get("http_statusCode"));
    }
}
