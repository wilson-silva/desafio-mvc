package com.gft.gerenciadorEventos.entities;


import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotEmpty(message = "Nome não pode ser vazio")
    private String nome;

	private Long capacidade;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data;

    @Digits(fraction = 2, integer = 10)
    private BigDecimal valorIngresso;

	@Enumerated(EnumType.STRING)
	private Genero genero;

    @ManyToOne
	@JoinColumn(name="casas_id")
    private Casa casas;
}