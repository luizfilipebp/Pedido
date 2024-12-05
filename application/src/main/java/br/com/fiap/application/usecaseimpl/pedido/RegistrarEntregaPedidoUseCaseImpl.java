package br.com.fiap.application.usecaseimpl.pedido;

import br.com.fiap.core.model.Pedido;
import br.com.fiap.usecase.pedido.BuscarPedidoUseCase;
import br.com.fiap.usecase.pedido.EditarPedidoUseCase;
import br.com.fiap.usecase.pedido.RegistrarEntregaPedidoUseCase;

public class RegistrarEntregaPedidoUseCaseImpl implements RegistrarEntregaPedidoUseCase {
    private final BuscarPedidoUseCase buscarPedidoUseCase;

    private final EditarPedidoUseCase editarPedidoUseCase;

    public RegistrarEntregaPedidoUseCaseImpl(BuscarPedidoUseCase buscarPedidoUseCase, EditarPedidoUseCase editarPedidoUseCase) {
        this.buscarPedidoUseCase = buscarPedidoUseCase;
        this.editarPedidoUseCase = editarPedidoUseCase;
    }

    @Override
    public Pedido registrarEntregaPedido(Long idPedido) {
        Pedido pedido = buscarPedidoUseCase.buscarPedidoPeloId(idPedido).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        pedido.registrarEntrega();
        return editarPedidoUseCase.editarPedido(pedido);
    }
}
