package br.com.fiap.infrastructure.mapper;

import br.com.fiap.core.model.Pedido;
import br.com.fiap.infrastructure.dto.pedido.PedidoPostReqBody;
import br.com.fiap.infrastructure.entities.PedidoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = ItemPedidoMapper.class)
public interface PedidoMapper {
    PedidoMapper INSTANCE = Mappers.getMapper(PedidoMapper.class);

    Pedido pedidoEntityToPedido(PedidoEntity pedidoEntity);

    PedidoEntity pedidoToPedidoEntity(Pedido pedido);

    Pedido pedidoPostReqBodyToPedido(PedidoPostReqBody pedido);


}