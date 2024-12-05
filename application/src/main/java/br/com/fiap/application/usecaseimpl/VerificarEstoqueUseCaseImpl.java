package br.com.fiap.application.usecaseimpl;

import br.com.fiap.application.gateway.VerificarEstoqueGateway;
import br.com.fiap.usecase.estoque.VerificarEstoqueUseCase;

public class VerificarEstoqueUseCaseImpl  implements VerificarEstoqueUseCase {

   private final VerificarEstoqueGateway verificarEstoqueGateway;

    public VerificarEstoqueUseCaseImpl(VerificarEstoqueGateway verificarEstoqueGateway) {
        this.verificarEstoqueGateway = verificarEstoqueGateway;
    }


    @Override
    public boolean verificarEstoque(Long idProduto, Integer quantidade) {
        return verificarEstoqueGateway.verificarEstoque(idProduto, quantidade);
    }
}
