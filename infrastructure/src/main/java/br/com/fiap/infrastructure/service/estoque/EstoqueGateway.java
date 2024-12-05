package br.com.fiap.infrastructure.service.estoque;

import br.com.fiap.infrastructure.exemplo.EstoqueDTO;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

@MessagingGateway
public interface EstoqueGateway {

    @Gateway(requestChannel = "verificarEstoqueChannel")
    Message<EstoqueDTO> verificarEstoque(Long idProduto);

    @Gateway(requestChannel = "retirarEstoqueChannel")
    Message<EstoqueDTO> retirarEstoque(Long idProduto, Integer quantidade);
}
