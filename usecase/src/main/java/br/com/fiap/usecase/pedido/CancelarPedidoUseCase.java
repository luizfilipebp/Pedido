package br.com.fiap.usecase.pedido;

import br.com.fiap.core.model.Pedido;

public interface CancelarPedidoUseCase {
    Pedido cancelarPedido(Long idPedido);
}
