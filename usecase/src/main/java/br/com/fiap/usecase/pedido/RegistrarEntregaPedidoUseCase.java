package br.com.fiap.usecase.pedido;

import br.com.fiap.core.model.Pedido;

public interface RegistrarEntregaPedidoUseCase {
    Pedido registrarEntregaPedido(Long idPedido);
}
