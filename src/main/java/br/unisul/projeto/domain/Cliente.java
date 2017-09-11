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
