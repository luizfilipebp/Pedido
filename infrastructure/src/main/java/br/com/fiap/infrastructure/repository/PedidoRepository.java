package br.com.fiap.infrastructure.repository;

import br.com.fiap.infrastructure.entities.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {

    Optional<PedidoEntity> findByIdClienteAndDataPedido(Long idCliente, LocalDateTime dataPedido);

}
