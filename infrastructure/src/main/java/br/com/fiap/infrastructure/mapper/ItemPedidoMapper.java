package br.com.fiap.infrastructure.mapper;

import br.com.fiap.core.model.valueObject.ItemPedido;
import br.com.fiap.infrastructure.entities.ItemPedidoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ItemPedidoMapper {
    ItemPedidoMapper INSTANCE = Mappers.getMapper(ItemPedidoMapper.class);

    ItemPedido itemPedidoEntityToItemPedido(ItemPedidoEntity itemPedido);

    ItemPedidoEntity itemPedidoToItemPedidoEntity(ItemPedido itemPedido);
}
