package br.com.fiap.application.gateway.pedido;

public interface VerificarPagamentoGateway {
    boolean verificarPagamento(Long idPedido);
}
