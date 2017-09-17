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
public class Crediario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cre_id;

	// Pé de galinha : muitos cidades para um estado
	@ManyToOne
	@JoinColumn(nullable = false) // Não pode ser falso. Sempre que precisar fazer um Join vai se utlizar este
									// campo
	private Cliente cli_nome;

	@Column(length = 20)
	private Double cre_valor;

	public Integer getCre_id() {
		return cre_id;
	}

	public void setCre_id(Integer cre_id) {
		this.cre_id = cre_id;
	}

	public Cliente getCli_nome() {
		return cli_nome;
	}

	public void setCli_nome(Cliente cli_nome) {
		this.cli_nome = cli_nome;
	}

	public Double getCre_valor() {
		return cre_valor;
	}

	public void setCre_valor(Double cre_valor) {
		this.cre_valor = cre_valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cli_nome == null) ? 0 : cli_nome.hashCode());
		result = prime * result + ((cre_id == null) ? 0 : cre_id.hashCode());
		result = prime * result + ((cre_valor == null) ? 0 : cre_valor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Crediario other = (Crediario) obj;
		if (cli_nome == null) {
			if (other.cli_nome != null)
				return false;
		} else if (!cli_nome.equals(other.cli_nome))
			return false;
		if (cre_id == null) {
			if (other.cre_id != null)
				return false;
		} else if (!cre_id.equals(other.cre_id))
			return false;
		if (cre_valor == null) {
			if (other.cre_valor != null)
				return false;
		} else if (!cre_valor.equals(other.cre_valor))
			return false;
		return true;
	}

}
