package br.com.fiap.application.usecaseimpl.pedido;

import br.com.fiap.application.gateway.pedido.CriarPedidoGateway;
import br.com.fiap.core.model.Pedido;
import br.com.fiap.core.model.valueObject.ItemPedido;
import br.com.fiap.usecase.estoque.RetirarProdutoEstoqueUseCase;
import br.com.fiap.usecase.pedido.BuscarPedidoUseCase;
import br.com.fiap.usecase.pedido.CriarPedidoUseCase;
import br.com.fiap.usecase.estoque.VerificarEstoqueUseCase;
import br.com.fiap.usecase.VerificarUsuarioUseCase;

import java.util.stream.Collectors;

public class CriarPedidoUseCaseImpl implements CriarPedidoUseCase {
    private final CriarPedidoGateway criarPedidoGateway;
    private final VerificarUsuarioUseCase verificarUsuarioUseCase;
    private final VerificarEstoqueUseCase verificarEstoqueUseCase;

    private final RetirarProdutoEstoqueUseCase retirarProdutoEstoqueUseCase;

    private final BuscarPedidoUseCase buscarPedidoUseCase;

    public CriarPedidoUseCaseImpl(CriarPedidoGateway criarPedidoGateway, VerificarUsuarioUseCase verificarUsuarioUseCase, VerificarEstoqueUseCase verificarEstoqueUseCase, RetirarProdutoEstoqueUseCase retirarProdutoEstoqueUseCase, BuscarPedidoUseCase buscarPedidoUseCase) {
        this.criarPedidoGateway = criarPedidoGateway;
        this.verificarUsuarioUseCase = verificarUsuarioUseCase;
        this.verificarEstoqueUseCase = verificarEstoqueUseCase;
        this.retirarProdutoEstoqueUseCase = retirarProdutoEstoqueUseCase;
        this.buscarPedidoUseCase = buscarPedidoUseCase;
    }

    @Override
    public Pedido criarPedido(Pedido pedido) {
        if (buscarPedidoUseCase.buscarPedido(pedido.getIdCliente(), pedido.getDataPedido()).isPresent()) {
            throw new IllegalArgumentException("Pedido já existe");
        }

        if (!verificarUsuarioUseCase.verificarUsuario(pedido.getIdCliente())) {
            throw new IllegalArgumentException("Usuário não encontrado");
        }

        pedido.getItens().forEach((itemPedido) -> {
            if (itemPedido == null) {
                throw new IllegalArgumentException("Id do produto não pode ser nulo");
            }

            if (!verificarEstoqueUseCase.verificarEstoque(itemPedido.idProduto(), itemPedido.quantidade())) {
                throw new IllegalArgumentException("Estoque insuficiente ou produto não encontrado");
            }
        });

        return criarPedidoGateway.criarPedido(pedido);
    }
}
