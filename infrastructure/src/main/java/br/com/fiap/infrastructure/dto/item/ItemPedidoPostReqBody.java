package br.com.fiap.infrastructure.dto.item;

import java.math.BigDecimal;

public record ItemPedidoPostReqBody(
        Long idProduto,
        Integer quantidade,
        BigDecimal precoUnitario
) {
}
