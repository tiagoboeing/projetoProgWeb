package br.unisul.projeto.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity 
public class Cliente implements Serializable{
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long cli_id;
	
	@Column(length=100)
	private String cli_nome;
	
	@Column(length=100)
	private String cli_sobrenome;
	
	@Column(length=255)
	private String cli_empresa;
	
	@Column(length=255)
	private String cli_razaosocial;
	
	@Column(length=20)
	private String cli_cpf;
	
	@Column(length=20)
	private String cli_rg;
	
	@Column(length=20)
	private String cli_cnpj;
	
	@Column(length=20)
	private Date cli_dtnasc;
	
	@Column(length=255)
	private String cli_email;
	
	@Column(length=255)
	private String cli_observacoes;
	
	@Column(length=1)
	private Integer cli_status;
	
	@Column(length=1)
	private String cli_tipoconta;

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cli_cnpj == null) ? 0 : cli_cnpj.hashCode());
		result = prime * result + ((cli_cpf == null) ? 0 : cli_cpf.hashCode());
		result = prime * result + ((cli_dtnasc == null) ? 0 : cli_dtnasc.hashCode());
		result = prime * result + ((cli_email == null) ? 0 : cli_email.hashCode());
		result = prime * result + ((cli_empresa == null) ? 0 : cli_empresa.hashCode());
		result = prime * result + ((cli_id == null) ? 0 : cli_id.hashCode());
		result = prime * result + ((cli_nome == null) ? 0 : cli_nome.hashCode());
		result = prime * result + ((cli_observacoes == null) ? 0 : cli_observacoes.hashCode());
		result = prime * result + ((cli_razaosocial == null) ? 0 : cli_razaosocial.hashCode());
		result = prime * result + ((cli_rg == null) ? 0 : cli_rg.hashCode());
		result = prime * result + ((cli_sobrenome == null) ? 0 : cli_sobrenome.hashCode());
		result = prime * result + ((cli_status == null) ? 0 : cli_status.hashCode());
		result = prime * result + ((cli_tipoconta == null) ? 0 : cli_tipoconta.hashCode());
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
		Cliente other = (Cliente) obj;
		if (cli_cnpj == null) {
			if (other.cli_cnpj != null)
				return false;
		} else if (!cli_cnpj.equals(other.cli_cnpj))
			return false;
		if (cli_cpf == null) {
			if (other.cli_cpf != null)
				return false;
		} else if (!cli_cpf.equals(other.cli_cpf))
			return false;
		if (cli_dtnasc == null) {
			if (other.cli_dtnasc != null)
				return false;
		} else if (!cli_dtnasc.equals(other.cli_dtnasc))
			return false;
		if (cli_email == null) {
			if (other.cli_email != null)
				return false;
		} else if (!cli_email.equals(other.cli_email))
			return false;
		if (cli_empresa == null) {
			if (other.cli_empresa != null)
				return false;
		} else if (!cli_empresa.equals(other.cli_empresa))
			return false;
		if (cli_id == null) {
			if (other.cli_id != null)
				return false;
		} else if (!cli_id.equals(other.cli_id))
			return false;
		if (cli_nome == null) {
			if (other.cli_nome != null)
				return false;
		} else if (!cli_nome.equals(other.cli_nome))
			return false;
		if (cli_observacoes == null) {
			if (other.cli_observacoes != null)
				return false;
		} else if (!cli_observacoes.equals(other.cli_observacoes))
			return false;
		if (cli_razaosocial == null) {
			if (other.cli_razaosocial != null)
				return false;
		} else if (!cli_razaosocial.equals(other.cli_razaosocial))
			return false;
		if (cli_rg == null) {
			if (other.cli_rg != null)
				return false;
		} else if (!cli_rg.equals(other.cli_rg))
			return false;
		if (cli_sobrenome == null) {
			if (other.cli_sobrenome != null)
				return false;
		} else if (!cli_sobrenome.equals(other.cli_sobrenome))
			return false;
		if (cli_status == null) {
			if (other.cli_status != null)
				return false;
		} else if (!cli_status.equals(other.cli_status))
			return false;
		if (cli_tipoconta == null) {
			if (other.cli_tipoconta != null)
				return false;
		} else if (!cli_tipoconta.equals(other.cli_tipoconta))
			return false;
		return true;
	}

	public Long getCli_id() {
		return cli_id;
	}

	public void setCli_id(Long cli_id) {
		this.cli_id = cli_id;
	}

	public String getCli_nome() {
		return cli_nome;
	}

	public void setCli_nome(String cli_nome) {
		this.cli_nome = cli_nome;
	}

	public String getCli_sobrenome() {
		return cli_sobrenome;
	}

	public void setCli_sobrenome(String cli_sobrenome) {
		this.cli_sobrenome = cli_sobrenome;
	}

	public String getCli_empresa() {
		return cli_empresa;
	}

	public void setCli_empresa(String cli_empresa) {
		this.cli_empresa = cli_empresa;
	}

	public String getCli_razaosocial() {
		return cli_razaosocial;
	}

	public void setCli_razaosocial(String cli_razaosocial) {
		this.cli_razaosocial = cli_razaosocial;
	}

	public String getCli_cpf() {
		return cli_cpf;
	}

	public void setCli_cpf(String cli_cpf) {
		this.cli_cpf = cli_cpf;
	}

	public String getCli_rg() {
		return cli_rg;
	}

	public void setCli_rg(String cli_rg) {
		this.cli_rg = cli_rg;
	}

	public String getCli_cnpj() {
		return cli_cnpj;
	}

	public void setCli_cnpj(String cli_cnpj) {
		this.cli_cnpj = cli_cnpj;
	}

	public Date getCli_dtnasc() {
		return cli_dtnasc;
	}

	public void setCli_dtnasc(Date cli_dtnasc) {
		this.cli_dtnasc = cli_dtnasc;
	}

	public String getCli_email() {
		return cli_email;
	}

	public void setCli_email(String cli_email) {
		this.cli_email = cli_email;
	}

	public String getCli_observacoes() {
		return cli_observacoes;
	}

	public void setCli_observacoes(String cli_observacoes) {
		this.cli_observacoes = cli_observacoes;
	}

	public Integer getCli_status() {
		return cli_status;
	}

	public void setCli_status(Integer cli_status) {
		this.cli_status = cli_status;
	}

	public String getCli_tipoconta() {
		return cli_tipoconta;
	}

	public void setCli_tipoconta(String cli_tipoconta) {
		this.cli_tipoconta = cli_tipoconta;
	}
	
	

}
