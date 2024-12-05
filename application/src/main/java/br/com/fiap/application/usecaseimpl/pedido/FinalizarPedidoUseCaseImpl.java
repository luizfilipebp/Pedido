package br.com.fiap.application.usecaseimpl.pedido;

import br.com.fiap.core.model.Pedido;
import br.com.fiap.usecase.pedido.BuscarPedidoUseCase;
import br.com.fiap.usecase.pedido.EditarPedidoUseCase;
import br.com.fiap.usecase.pedido.FinalizarPedidoUseCase;

public class FinalizarPedidoUseCaseImpl implements FinalizarPedidoUseCase {

    private final BuscarPedidoUseCase buscarPedidoUseCase;

    private final EditarPedidoUseCase editarPedidoUseCase;

    public FinalizarPedidoUseCaseImpl(BuscarPedidoUseCase buscarPedidoUseCase, EditarPedidoUseCase editarPedidoUseCase) {
        this.buscarPedidoUseCase = buscarPedidoUseCase;
        this.editarPedidoUseCase = editarPedidoUseCase;
    }

    @Override
    public Pedido finalizarPedido(Long idPedido) {
        Pedido pedido = buscarPedidoUseCase.buscarPedidoPeloId(idPedido).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        pedido.finalizar();
        return editarPedidoUseCase.editarPedido(pedido);
    }
}
