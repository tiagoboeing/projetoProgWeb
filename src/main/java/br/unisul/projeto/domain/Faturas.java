package br.unisul.projeto.domain;

import java.io.Serializable;
import java.util.Date;

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
	private Long fat_id;

	// Pé de galinha : muitos cidades para um estado
	@ManyToOne
	@JoinColumn(nullable = false) // Não pode ser falso. Sempre que precisar fazer um Join vai se utlizar este
									// campo
	
	
	// CHAVE ESTRANGEIRA
	private Cliente cli_nome;

	@Column(length = 20)
	private Double fat_valor;
	
	@Column(length = 20)
	private Date fat_data;
	
	@Column(length = 20)
	private String fat_status;

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cli_nome == null) ? 0 : cli_nome.hashCode());
		result = prime * result + ((fat_id == null) ? 0 : fat_id.hashCode());
		result = prime * result + ((fat_status == null) ? 0 : fat_status.hashCode());
		result = prime * result + ((fat_valor == null) ? 0 : fat_valor.hashCode());
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
		Faturas other = (Faturas) obj;
		if (cli_nome == null) {
			if (other.cli_nome != null)
				return false;
		} else if (!cli_nome.equals(other.cli_nome))
			return false;
		if (fat_id == null) {
			if (other.fat_id != null)
				return false;
		} else if (!fat_id.equals(other.fat_id))
			return false;
		if (fat_status == null) {
			if (other.fat_status != null)
				return false;
		} else if (!fat_status.equals(other.fat_status))
			return false;
		if (fat_valor == null) {
			if (other.fat_valor != null)
				return false;
		} else if (!fat_valor.equals(other.fat_valor))
			return false;
		return true;
	}

	
	
	public Date getFat_data() {
		return fat_data;
	}

	public void setFat_data(Date fat_data) {
		this.fat_data = fat_data;
	}

	public String getFat_status() {
		return fat_status;
	}

	public void setFat_status(String fat_status) {
		this.fat_status = fat_status;
	}

	public Long getFat_id() {
		return fat_id;
	}

	public void setFat_id(Long fat_id) {
		this.fat_id = fat_id;
	}

	public Cliente getCli_nome() {
		return cli_nome;
	}

	public void setCli_nome(Cliente cli_nome) {
		this.cli_nome = cli_nome;
	}

	public Double getFat_valor() {
		return fat_valor;
	}

	public void setFat_valor(Double fat_valor) {
		this.fat_valor = fat_valor;
	}






}
