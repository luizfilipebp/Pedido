package br.com.fiap.application.usecaseimpl.pedido;

import br.com.fiap.application.gateway.pedido.VerificarPagamentoGateway;
import br.com.fiap.core.model.Pedido;
import br.com.fiap.usecase.estoque.RetirarProdutoEstoqueUseCase;
import br.com.fiap.usecase.pedido.BuscarPedidoUseCase;
import br.com.fiap.usecase.pedido.EditarPedidoUseCase;
import br.com.fiap.usecase.pedido.RegistrarPagamentoUseCase;

public class RegistrarPagamentoUseCaseImpl implements RegistrarPagamentoUseCase {
    private final BuscarPedidoUseCase buscarPedidoUseCase;
    private final VerificarPagamentoGateway verificarPagamentoGateway;
    private final RetirarProdutoEstoqueUseCase retirarProdutoEstoqueUseCase;
    private final EditarPedidoUseCase editarPedidoUseCase;

    public RegistrarPagamentoUseCaseImpl(BuscarPedidoUseCase buscarPedidoUseCase, VerificarPagamentoGateway verificarPagamentoGateway, EditarPedidoUseCase editarPedidoUseCase, RetirarProdutoEstoqueUseCase retirarProdutoEstoqueUseCase) {
        this.buscarPedidoUseCase = buscarPedidoUseCase;
        this.verificarPagamentoGateway = verificarPagamentoGateway;
        this.editarPedidoUseCase = editarPedidoUseCase;
        this.retirarProdutoEstoqueUseCase = retirarProdutoEstoqueUseCase;
    }

    @Override
    public Pedido registrarPagamento(Long idPedido) throws RuntimeException {
        Pedido pedido = buscarPedidoUseCase.buscarPedidoPeloId(idPedido).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        verificarPagamento(idPedido);
        retirarProdutosDoEstoque(pedido);
        pedido.registrarPagamento();
        return editarPedidoUseCase.editarPedido(pedido);
    }

    private void verificarPagamento(Long idPedido) {
        if (!verificarPagamentoGateway.verificarPagamento(idPedido)) {
            throw new RuntimeException("Pagamento não foi aprovado");
        }
    }

    private void retirarProdutosDoEstoque(Pedido pedido) {
        pedido.getItens().forEach(item -> {
            if (!retirarProdutoEstoqueUseCase.retirarProdutoEstoque(item.idProduto(), item.quantidade())) {
                throw new RuntimeException("Estoque insuficiente");
            }
        });
    }
}
