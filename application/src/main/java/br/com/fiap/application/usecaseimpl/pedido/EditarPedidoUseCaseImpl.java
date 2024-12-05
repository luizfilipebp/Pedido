package br.com.fiap.application.usecaseimpl.pedido;

import br.com.fiap.application.gateway.pedido.BuscarPedidoGateway;
import br.com.fiap.application.gateway.pedido.EditarPedidoGateway;
import br.com.fiap.core.model.Pedido;
import br.com.fiap.usecase.pedido.EditarPedidoUseCase;

public class EditarPedidoUseCaseImpl implements EditarPedidoUseCase {

    private final EditarPedidoGateway editarPedidoGateway;

    private final BuscarPedidoGateway buscarPedidoGateway;

    public EditarPedidoUseCaseImpl(EditarPedidoGateway editarPedidoGateway, BuscarPedidoGateway buscarPedidoGateway) {
        this.editarPedidoGateway = editarPedidoGateway;
        this.buscarPedidoGateway = buscarPedidoGateway;
    }

    @Override
    public Pedido editarPedido(Pedido pedido) {
        buscarPedidoGateway.buscarPedido(pedido.getIdCliente(), pedido.getDataPedido()).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        return editarPedidoGateway.editarPedido(pedido);
    }
}
