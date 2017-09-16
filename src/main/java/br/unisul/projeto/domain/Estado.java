package br.unisul.projeto.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity 
public class Estado implements Serializable {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long idEstado;
	
	@Column(length=100)
	private String nomeEstado;
	
	@Column(length=2)
	private String ufEstado;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEstado == null) ? 0 : idEstado.hashCode());
		result = prime * result + ((nomeEstado == null) ? 0 : nomeEstado.hashCode());
		result = prime * result + ((ufEstado == null) ? 0 : ufEstado.hashCode());
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
		Estado other = (Estado) obj;
		if (idEstado == null) {
			if (other.idEstado != null)
				return false;
		} else if (!idEstado.equals(other.idEstado))
			return false;
		if (nomeEstado == null) {
			if (other.nomeEstado != null)
				return false;
		} else if (!nomeEstado.equals(other.nomeEstado))
			return false;
		if (ufEstado == null) {
			if (other.ufEstado != null)
				return false;
		} else if (!ufEstado.equals(other.ufEstado))
			return false;
		return true;
	}
	
	
	public Long getCodigo() {
		return idEstado;
	}
	public void setCodigo(Long idEstado) {
		this.idEstado = idEstado;
	}
	
	public String getNomeEstado() {
		return nomeEstado;
	}
	public void setNomeEstado(String nomeEstado) {
		this.nomeEstado = nomeEstado;
	}
	public String getUfEstado() {
		return ufEstado;
	}
	public void setUfEstado(String ufEstado) {
		this.ufEstado = ufEstado;
	}

	
	
	
}
