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
	private String fat_data;
	
	@Column(length = 20)
	private String fat_status;
	
	
	// RECUPERA VALOR PAGO
	@Column(length = 20)
	private Double fat_valorPago;
	
	@Column(length = 20)
	private String fat_dataPago;

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cli_nome == null) ? 0 : cli_nome.hashCode());
		result = prime * result + ((fat_data == null) ? 0 : fat_data.hashCode());
		result = prime * result + ((fat_dataPago == null) ? 0 : fat_dataPago.hashCode());
		result = prime * result + ((fat_id == null) ? 0 : fat_id.hashCode());
		result = prime * result + ((fat_status == null) ? 0 : fat_status.hashCode());
		result = prime * result + ((fat_valor == null) ? 0 : fat_valor.hashCode());
		result = prime * result + ((fat_valorPago == null) ? 0 : fat_valorPago.hashCode());
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
		if (fat_data == null) {
			if (other.fat_data != null)
				return false;
		} else if (!fat_data.equals(other.fat_data))
			return false;
		if (fat_dataPago == null) {
			if (other.fat_dataPago != null)
				return false;
		} else if (!fat_dataPago.equals(other.fat_dataPago))
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
		if (fat_valorPago == null) {
			if (other.fat_valorPago != null)
				return false;
		} else if (!fat_valorPago.equals(other.fat_valorPago))
			return false;
		return true;
	}

	
	
	public String getFat_data() {
		return fat_data;
	}

	public void setFat_data(String fat_data) {
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

	public Double getFat_valorPago() {
		return fat_valorPago;
	}

	public void setFat_valorPago(Double fat_valorPago) {
		this.fat_valorPago = fat_valorPago;
	}

	public String getFat_dataPago() {
		return fat_dataPago;
	}

	public void setFat_dataPago(String fat_dataPago) {
		this.fat_dataPago = fat_dataPago;
	}





}
