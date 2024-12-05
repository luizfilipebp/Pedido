package br.com.fiap.application.usecaseimpl.estoque;

import br.com.fiap.application.gateway.RetirarProdutoEstoqueGateway;
import br.com.fiap.usecase.estoque.RetirarProdutoEstoqueUseCase;

public class RetirarProdutoEstoqueUseCaseImpl implements RetirarProdutoEstoqueUseCase {
    private final RetirarProdutoEstoqueGateway retirarProdutoEstoqueGateway;


    public RetirarProdutoEstoqueUseCaseImpl(RetirarProdutoEstoqueGateway retirarProdutoEstoqueGateway) {
        this.retirarProdutoEstoqueGateway = retirarProdutoEstoqueGateway;
    }

    @Override
    public boolean retirarProdutoEstoque(Long idProduto, Integer quantidade) {
        return retirarProdutoEstoqueGateway.retirarProdutoEstoque(idProduto, quantidade);
    }
}
