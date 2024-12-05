package br.com.fiap.infrastructure.service.pedido;

import br.com.fiap.application.gateway.pedido.EditarPedidoGateway;
import br.com.fiap.core.model.Pedido;
import br.com.fiap.infrastructure.mapper.PedidoMapper;
import br.com.fiap.infrastructure.repository.PedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EditarPedidoGatewayImpl implements EditarPedidoGateway {
    private final PedidoRepository pedidoRepository;

    @Override
    public Pedido editarPedido(Pedido pedido) {
        pedidoRepository.findByIdClienteAndDataPedido(pedido.getIdCliente(), pedido.getDataPedido()).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        pedidoRepository.save(PedidoMapper.INSTANCE.pedidoToPedidoEntity(pedido));
        return pedido;
    }
}
