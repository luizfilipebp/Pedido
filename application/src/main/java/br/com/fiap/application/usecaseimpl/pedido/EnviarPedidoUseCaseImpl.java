package br.com.fiap.application.usecaseimpl.pedido;

import br.com.fiap.core.model.Pedido;
import br.com.fiap.usecase.pedido.BuscarPedidoUseCase;
import br.com.fiap.usecase.pedido.EditarPedidoUseCase;
import br.com.fiap.usecase.pedido.EnviarPedidoUseCase;

public class EnviarPedidoUseCaseImpl implements EnviarPedidoUseCase {
    private final BuscarPedidoUseCase buscarPedidoUseCase;
    private final EditarPedidoUseCase editarPedidoUseCase;

    public EnviarPedidoUseCaseImpl(BuscarPedidoUseCase buscarPedidoUseCase, EditarPedidoUseCase editarPedidoUseCase) {
        this.buscarPedidoUseCase = buscarPedidoUseCase;
        this.editarPedidoUseCase = editarPedidoUseCase;
    }

    @Override
    public Pedido enviarPedido(Long idPedido) {
        Pedido pedido = buscarPedidoUseCase.buscarPedidoPeloId(idPedido).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        pedido.enviar();
        return editarPedidoUseCase.editarPedido(pedido);
    }
}
