package br.unisul.projeto.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Produto implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long pro_id;

	@Column(length = 100)
	private String pro_nome;

	@Column(length = 10)
	private String pro_valor;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pro_id == null) ? 0 : pro_id.hashCode());
		result = prime * result + ((pro_nome == null) ? 0 : pro_nome.hashCode());
		result = prime * result + ((pro_valor == null) ? 0 : pro_valor.hashCode());
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
		Produto other = (Produto) obj;
		if (pro_id == null) {
			if (other.pro_id != null)
				return false;
		} else if (!pro_id.equals(other.pro_id))
			return false;
		if (pro_nome == null) {
			if (other.pro_nome != null)
				return false;
		} else if (!pro_nome.equals(other.pro_nome))
			return false;
		if (pro_valor == null) {
			if (other.pro_valor != null)
				return false;
		} else if (!pro_valor.equals(other.pro_valor))
			return false;
		return true;
	}

	public Long getPro_id() {
		return pro_id;
	}

	public void setPro_id(Long pro_id) {
		this.pro_id = pro_id;
	}

	public String getPro_nome() {
		return pro_nome;
	}

	public void setPro_nome(String pro_nome) {
		this.pro_nome = pro_nome;
	}

	public String getPro_valor() {
		return pro_valor;
	}

	public void setPro_valor(String pro_valor) {
		this.pro_valor = pro_valor;
	}

	
}
