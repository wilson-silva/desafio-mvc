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
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Digits(fraction = 2, integer = 10)
    private BigDecimal valorTotal = BigDecimal.valueOf(0);

    @ManyToOne
    private Usuario usuario;

}
