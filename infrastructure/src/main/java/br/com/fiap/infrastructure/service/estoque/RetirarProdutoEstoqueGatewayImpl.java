package br.com.fiap.infrastructure.service.estoque;

import br.com.fiap.application.gateway.RetirarProdutoEstoqueGateway;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class RetirarProdutoEstoqueGatewayImpl implements RetirarProdutoEstoqueGateway {

    private final EstoqueGateway estoqueGateway;

    @Override
    public boolean retirarProdutoEstoque(Long idProduto, Integer quantidade) {
        return Objects.equals(estoqueGateway.retirarEstoque(idProduto, quantidade).getHeaders().get("http_status"), HttpStatus.OK);
    }
}
