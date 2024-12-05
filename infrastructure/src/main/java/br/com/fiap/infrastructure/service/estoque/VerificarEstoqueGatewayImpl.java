package br.com.fiap.infrastructure.service.estoque;

import br.com.fiap.application.gateway.VerificarEstoqueGateway;
import br.com.fiap.infrastructure.exemplo.EstoqueDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VerificarEstoqueGatewayImpl implements VerificarEstoqueGateway {

    private final EstoqueGateway buscarEstoqueGateway;


    @Override
    public boolean verificarEstoque(Long idProduto, Integer quantidade) {
        try {
            EstoqueDTO payload = buscarEstoqueGateway.verificarEstoque(idProduto).getPayload();
            return payload.quantidade() > quantidade;
        }catch (ClassCastException e){
            return false;
        }
    }
}
