package br.com.fiap.infrastructure.entities;


import br.com.fiap.core.model.enums.StatusPedido;
import br.com.fiap.core.model.valueObject.ItemPedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "pedido")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PedidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ped_id")
    private Long id;

    @Column(name = "ped_cli_id", nullable = false)
    private Long idCliente;

    @Column(name = "ped_data_pedido", nullable = false)
    private LocalDateTime dataPedido;

    @Column(name = "ped_status", nullable = false)
    private StatusPedido statusPedido;

    @ElementCollection
    @CollectionTable(name = "itens_pedidos", joinColumns = @JoinColumn(name = "ITP_PED_ID"))
    private List<ItemPedidoEntity> itens;

    @Column(name = "ped_valor_total", nullable = false)
    private BigDecimal valorTotal;

}
