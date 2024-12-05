package br.com.fiap.usecase.pedido;

import br.com.fiap.core.model.Pedido;

import java.time.LocalDateTime;
import java.util.Optional;

public interface BuscarPedidoUseCase {
    Optional<Pedido> buscarPedido(Long idUsuario, LocalDateTime dataPedido);

    Optional<Pedido> buscarPedidoPeloId(Long idPedido);
}
