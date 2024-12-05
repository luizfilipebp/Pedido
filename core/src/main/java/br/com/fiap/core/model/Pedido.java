package br.com.fiap.core.model;

import br.com.fiap.core.model.enums.StatusPedido;
import br.com.fiap.core.model.valueObject.ItemPedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Pedido {
    private Long idCliente;
    private LocalDateTime dataPedido;
    private StatusPedido statusPedido;
    private List<ItemPedido> itens;
    private BigDecimal valorTotal;

    public void cancelar() {
        this.statusPedido = StatusPedido.CANCELADO;
    }

    public void registrarPagamento() {
        if (this.statusPedido != StatusPedido.AGUARDANDO_PAGAMENTO) {
            throw new IllegalStateException("Pedido não pode ser pago sem confirmação");
        }

        this.statusPedido = StatusPedido.PAGO;
    }

    public void enviar() {
        if (this.statusPedido != StatusPedido.PAGO) {
            throw new IllegalStateException("Pedido não pode ser enviado sem pagamento");
        }

        this.statusPedido = StatusPedido.AGUARDANDO_ENTREGA;
    }

    public void registrarEntrega() {
        if (this.statusPedido != StatusPedido.AGUARDANDO_ENTREGA) {
            throw new IllegalStateException("Pedido não pode ser entregue sem envio");
        }

        this.statusPedido = StatusPedido.ENTREGUE;
    }

    public void finalizar() {
        if (this.statusPedido != StatusPedido.ENTREGUE) {
            throw new IllegalStateException("Pedido não pode ser finalizado sem entrega");
        }

        this.statusPedido = StatusPedido.FINALIZADO;
    }


    public Pedido(Long idCliente, List<ItemPedido> itens) {
        this.idCliente = idCliente;
        this.itens = itens;
        this.valorTotal = itens.stream()
                .map(ItemPedido::getTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        this.dataPedido = LocalDateTime.now();
        this.statusPedido = StatusPedido.AGUARDANDO_CONFIRMACAO;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(idCliente, pedido.idCliente) && Objects.equals(dataPedido, pedido.dataPedido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCliente, dataPedido);
    }
}
