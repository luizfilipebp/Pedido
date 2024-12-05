package br.com.fiap.infrastructure.dto.pedido;

import br.com.fiap.infrastructure.dto.item.ItemPedidoPostReqBody;

import java.util.List;

public record PedidoPostReqBody(
        Long idCliente,
        List<ItemPedidoPostReqBody> itens
) {
}
