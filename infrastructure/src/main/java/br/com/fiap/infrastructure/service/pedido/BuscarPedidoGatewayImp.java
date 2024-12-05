package br.com.fiap.infrastructure.service.pedido;

import br.com.fiap.application.gateway.pedido.BuscarPedidoGateway;
import br.com.fiap.core.model.Pedido;
import br.com.fiap.infrastructure.entities.PedidoEntity;
import br.com.fiap.infrastructure.mapper.PedidoMapper;
import br.com.fiap.infrastructure.repository.PedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BuscarPedidoGatewayImp implements BuscarPedidoGateway {

    private final PedidoRepository pedidoRepository;

    @Override
    public Optional<Pedido> buscarPedido(Long idCliente, LocalDateTime dataPedido) {
        return Optional.ofNullable(PedidoMapper.INSTANCE.pedidoEntityToPedido(pedidoRepository.findByIdClienteAndDataPedido(idCliente, dataPedido).orElse(null)));
    }

    @Override
    public Optional<Pedido> buscarPedidoPeloId(Long idPedido) {
        return Optional.ofNullable(PedidoMapper.INSTANCE.pedidoEntityToPedido(pedidoRepository.findById(idPedido).orElse(null)));
    }
}
