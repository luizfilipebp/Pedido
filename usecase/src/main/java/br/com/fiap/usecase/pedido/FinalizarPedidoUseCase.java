package br.com.fiap.usecase.pedido;

import br.com.fiap.core.model.Pedido;

public interface FinalizarPedidoUseCase {
    Pedido finalizarPedido(Long idPedido);
}
