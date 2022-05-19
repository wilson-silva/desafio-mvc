package com.gft.gerenciadorEventos.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    public Integer getQuantidade() {
        if(this.quantidade == null){
            quantidade = 0;
        }
        return quantidade;
    }
}