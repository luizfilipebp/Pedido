package br.com.fiap.core.model.valueObject;

import java.math.BigDecimal;

public record ItemPedido(Long idProduto, Integer quantidade, BigDecimal precoUnitario) {
    public BigDecimal getTotal() {
        return precoUnitario.multiply(BigDecimal.valueOf(quantidade));
    }
}