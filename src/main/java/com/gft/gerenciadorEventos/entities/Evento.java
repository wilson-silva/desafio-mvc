package com.gft.gerenciadorEventos.entities;


import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
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


	public Long getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(Long capacidade) {
		this.capacidade = capacidade;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public BigDecimal getValorIngresso() {
		return valorIngresso;
	}

	public void setValorIngresso(BigDecimal valorIngresso) {
		this.valorIngresso = valorIngresso;
	}

	public Casa getCasas() {
		return casas;
	}

	public void setCasas(Casa casas) {
		this.casas = casas;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

    
    





}