package br.com.fiap.infrastructure.service.pedido;

import br.com.fiap.application.gateway.pedido.CriarPedidoGateway;
import br.com.fiap.core.model.Pedido;
import br.com.fiap.infrastructure.mapper.PedidoMapper;
import br.com.fiap.infrastructure.repository.PedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CriarPedidoGatewayImpl implements CriarPedidoGateway {
    private final PedidoRepository pedidoRepository;

    @Override
    public Pedido criarPedido(Pedido pedido) {
        return PedidoMapper.INSTANCE.pedidoEntityToPedido(pedidoRepository.save(PedidoMapper.INSTANCE.pedidoToPedidoEntity(pedido)));
    }
}
