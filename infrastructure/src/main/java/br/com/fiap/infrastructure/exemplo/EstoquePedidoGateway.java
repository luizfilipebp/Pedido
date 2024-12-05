package br.com.fiap.infrastructure.exemplo;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

@MessagingGateway
public interface EstoquePedidoGateway {

        @Gateway(requestChannel = "estoquePedidoChannel",
            requestTimeout = 5000
//            headers = @GatewayHeader(name = MessageHeaders.REPLY_CHANNEL, expression = "@nullChannel")
    )
//    @Gateway(requestChannel = "estoquePedidoChannel")
    Message<EstoqueDTO> removerEstoque(String idProduto);


}
