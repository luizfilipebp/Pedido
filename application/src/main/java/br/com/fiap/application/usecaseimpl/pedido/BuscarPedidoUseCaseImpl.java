package br.com.fiap.application.usecaseimpl.pedido;

import br.com.fiap.application.gateway.pedido.BuscarPedidoGateway;
import br.com.fiap.core.model.Pedido;
import br.com.fiap.usecase.pedido.BuscarPedidoUseCase;

import java.time.LocalDateTime;
import java.util.Optional;

public class BuscarPedidoUseCaseImpl implements BuscarPedidoUseCase {
    private final BuscarPedidoGateway buscarPedidoGateway;

    public BuscarPedidoUseCaseImpl(BuscarPedidoGateway buscarPedidoGateway) {
        this.buscarPedidoGateway = buscarPedidoGateway;
    }

    @Override
    public Optional<Pedido> buscarPedido(Long idUsuario, LocalDateTime dataPedido) {
        return buscarPedidoGateway.buscarPedido(idUsuario, dataPedido);
    }

    @Override
    public Optional<Pedido> buscarPedidoPeloId(Long idPedido) {
        return buscarPedidoGateway.buscarPedidoPeloId(idPedido);
    }
}
