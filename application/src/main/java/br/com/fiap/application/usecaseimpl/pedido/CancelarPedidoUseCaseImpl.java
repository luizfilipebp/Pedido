package br.com.fiap.application.usecaseimpl.pedido;

import br.com.fiap.application.gateway.pedido.BuscarPedidoGateway;
import br.com.fiap.application.gateway.pedido.EditarPedidoGateway;
import br.com.fiap.core.model.Pedido;
import br.com.fiap.usecase.pedido.CancelarPedidoUseCase;

public class CancelarPedidoUseCaseImpl implements CancelarPedidoUseCase {
    private final BuscarPedidoGateway buscarPedidoGateway;
    private final EditarPedidoGateway editarPedidoGateway;

    public CancelarPedidoUseCaseImpl(BuscarPedidoGateway buscarPedidoGateway, EditarPedidoGateway editarPedidoGateway) {
        this.buscarPedidoGateway = buscarPedidoGateway;
        this.editarPedidoGateway = editarPedidoGateway;
    }

    @Override
    public Pedido cancelarPedido(Long idPedido) {
        Pedido pedido = buscarPedidoGateway.buscarPedidoPeloId(idPedido).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        pedido.cancelar();
        return editarPedidoGateway.editarPedido(pedido);
    }
}
