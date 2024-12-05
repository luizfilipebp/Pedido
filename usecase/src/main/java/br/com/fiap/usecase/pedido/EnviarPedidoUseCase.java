package br.com.fiap.usecase.pedido;

import br.com.fiap.core.model.Pedido;

public interface EnviarPedidoUseCase {
    Pedido enviarPedido(Long idPedido);
}
