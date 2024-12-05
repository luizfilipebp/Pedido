package br.com.fiap.usecase.estoque;

public interface RetirarProdutoEstoqueUseCase {
    boolean retirarProdutoEstoque (Long idProduto, Integer quantidade) throws RuntimeException;
}
