package br.com.fiap.application.gateway;

public interface RetirarProdutoEstoqueGateway {
    boolean retirarProdutoEstoque(Long idProduto, Integer quantidade);
}
