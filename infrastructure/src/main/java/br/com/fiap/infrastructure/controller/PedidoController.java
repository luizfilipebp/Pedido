package br.com.fiap.infrastructure.controller;

import br.com.fiap.core.model.Pedido;
import br.com.fiap.infrastructure.dto.pedido.PedidoPostReqBody;
import br.com.fiap.infrastructure.entities.PedidoEntity;
import br.com.fiap.infrastructure.mapper.PedidoMapper;
import br.com.fiap.usecase.pedido.BuscarPedidoUseCase;
import br.com.fiap.usecase.pedido.CancelarPedidoUseCase;
import br.com.fiap.usecase.pedido.CriarPedidoUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/pedido")
@AllArgsConstructor
public class PedidoController {
    private final BuscarPedidoUseCase buscarPedidoUseCase;
    private final CancelarPedidoUseCase cancelarPedidoUseCase;
    private final CriarPedidoUseCase criarPedidoUseCase;

    @GetMapping("/{idPedido}")
    public ResponseEntity<?> getPedido(@PathVariable Long idPedido) {
        Optional<Pedido> pedido = buscarPedidoUseCase.buscarPedidoPeloId(idPedido);
        return pedido.isPresent() ? ResponseEntity.ok(pedido.get()) : ResponseEntity.noContent().build();
    }

    @PostMapping("/cancelar/{idPedido}")
    public ResponseEntity<?> cancelarPedido(@PathVariable Long idPedido) {
        return ResponseEntity.ok(cancelarPedidoUseCase.cancelarPedido(idPedido));
    }

    @PostMapping()
    public ResponseEntity<?> criarPedido(@RequestBody PedidoPostReqBody pedidoPostReqBody) {
        Pedido pedido = PedidoMapper.INSTANCE.pedidoPostReqBodyToPedido(pedidoPostReqBody);
        return ResponseEntity.ok(criarPedidoUseCase.criarPedido(pedido));
    }


}