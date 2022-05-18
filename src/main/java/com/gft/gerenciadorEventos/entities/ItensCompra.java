package com.gft.gerenciadorEventos.entities;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;

@Entity
public class ItensCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Evento evento;

    @ManyToOne
    private Compra compra;

    private Integer quantidade;

    @Digits(fraction = 2, integer = 10)
    private BigDecimal valorUnitario = BigDecimal.valueOf(0);

    @Digits(fraction = 2, integer = 10)
    private BigDecimal valorTotal =  BigDecimal.valueOf(0);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Integer getQuantidade() {
        if(this.quantidade == null){
            quantidade = 0;
        }
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}