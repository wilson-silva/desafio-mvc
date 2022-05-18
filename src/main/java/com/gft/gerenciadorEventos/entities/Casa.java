package com.gft.gerenciadorEventos.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;



@Entity
public class Casa {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;


	@NotEmpty(message = "Nome não pode ser vazio.")
	private String nome;


	@NotEmpty(message = "Nome não pode ser vazio.")
	private String endereco;

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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	

}
