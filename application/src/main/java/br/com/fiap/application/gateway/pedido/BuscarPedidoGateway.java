package br.com.fiap.application.gateway.pedido;

import br.com.fiap.core.model.Pedido;

import java.time.LocalDateTime;
import java.util.Optional;

public interface BuscarPedidoGateway {
    Optional<Pedido> buscarPedido(Long idUsuario, LocalDateTime dataPedido);

    Optional<Pedido> buscarPedidoPeloId(Long idPedido);
}
