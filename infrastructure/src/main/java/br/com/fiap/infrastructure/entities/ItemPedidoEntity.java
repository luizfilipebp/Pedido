package br.com.fiap.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Embeddable
@AttributeOverrides({
        @AttributeOverride(name = "idProduto", column = @Column(name = "ITP_ID_PRODUTO")),
        @AttributeOverride(name = "quantidade", column = @Column(name = "ITP_QUANTIDADE")),
        @AttributeOverride(name = "precoUnitario", column = @Column(name = "ITP_PRECO_UNITARIO"))
})
public class ItemPedidoEntity {
    private Long idProduto;
    private Integer quantidade;
    private BigDecimal precoUnitario;
}
