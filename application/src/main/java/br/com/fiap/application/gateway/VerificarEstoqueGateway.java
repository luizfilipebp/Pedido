package br.com.fiap.application.gateway;

public interface VerificarEstoqueGateway {
    boolean verificarEstoque(Long idProduto, Integer quantidade);
}
