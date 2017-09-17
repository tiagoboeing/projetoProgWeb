package br.unisul.projeto.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Faturas implements Serializable {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long cli_id;

	// Pé de galinha : muitos cidades para um estado
	@ManyToOne
	@JoinColumn(nullable = false) // Não pode ser falso. Sempre que precisar fazer um Join vai se utlizar este
									// campo
	private Cliente cli_nome;

	@Column(length = 20)
	private Double cre_valor;






}
