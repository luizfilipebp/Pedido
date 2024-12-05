package br.com.fiap.usecase.estoque;

public interface VerificarEstoqueUseCase {
    boolean verificarEstoque(Long idProduto, Integer quantidade);
}
