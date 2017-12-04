package br.unisul.projeto.bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.unisul.projeto.dao.ClienteDao;
import br.unisul.projeto.dao.FaturasDao;
import br.unisul.projeto.domain.Cliente;
import br.unisul.projeto.domain.Faturas;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class FaturasBack implements Serializable {

	private Faturas f = new Faturas();
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private ArrayList<Faturas> listaFaturas = new ArrayList<Faturas>();

	// <!-- TENTANDO FAZER COM QUE A DATA APAREÇA AUTOMATICA -->
	// private java.util.Date datahoraInicio;

	// pst.setTimestamp(5, new java.sql.Timestamp(p.getDatahoraInicio().getTime()));

	/*
	 * private String getDateTime() { DateFormat dateFormat = new
	 * SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); Date date = new Date(0); return
	 * dateFormat.format(date); }
	 */

	@PostConstruct
	public void listar() {

		try {

			FaturasDao dao = new FaturasDao();
			listaFaturas = (ArrayList<Faturas>) dao.listarTodasFaturas();

		} catch (Exception e) {
			Messages.addGlobalInfo("Erro ao listar faturas");
			e.printStackTrace();
		}

	}

	public void novo() {

		f = new Faturas();
		carregaFaturas();

	}

	// ao criar nova
	public void salvar() {

		try {
			FaturasDao dao = new FaturasDao();

			// status padrão
			f.setFat_status("Não pago");

			// data padrão - HOJE
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			LocalDate localDate = LocalDate.now();

			String dataPadrao = dtf.format(localDate);
			f.setFat_data(dataPadrao);

			// salva
			dao.salvar(f);

			Messages.addGlobalInfo("Fatura cadastrada com sucesso");
			novo();
			listar();

		} catch (Exception e) {
			Messages.addGlobalInfo("Erro ao cadastrar fatura");
			e.printStackTrace();
		}

	}

	public void alterar(ActionEvent evt) {

		f = (Faturas) evt.getComponent().getAttributes().get("faturaAlterar");
		// CidadeDao dao = new CidadeDao();
		// dao.alterar(cidade);
		// cidades = (ArrayList<Cidade>)dao.listarTodos();

		carregaFaturas();
		listar();

	}

	public void excluir(ActionEvent evt) {

		f = (Faturas) evt.getComponent().getAttributes().get("faturaExcluir");
		FaturasDao dao = new FaturasDao();
		dao.excluir(f);
		listaFaturas = (ArrayList<Faturas>) dao.listarTodasFaturas();
		carregaFaturas();
		listar();
	}

	public void setarFatura(ActionEvent evt) {
		f = (Faturas) evt.getComponent().getAttributes().get("pagarFatura");
	}

	// SALVAR VALOR PAGO
	public void pagarFatura(ActionEvent evt) {

		try {

			// f = (Faturas) evt.getComponent().getAttributes().get("pagarFatura");
			FaturasDao dao = new FaturasDao();

			f.setFat_valorPago(f.getFat_valorPago());
			Double valorPagamento = f.getFat_valorPago();
			
			// data padrão - HOJE
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			LocalDate localDate = LocalDate.now();
			String dataPadrao = dtf.format(localDate);
			
			f.setFat_dataPago(dataPadrao);
			
			if(f.getFat_valor() >= valorPagamento) {
				// paga atual
				dao.alterar(f);
			} else {
				Messages.addGlobalInfo("Opa, o valor pago é superior ao valor da fatura!");
				
				carregaFaturas();
				listar();
				return;
			}

			

			// CLONA CLIENTE
			Faturas novaFatura = f.clonaFatura(f);

			// INSTANCIA nova fatura com alguns dados da original
			novo();

			// cliente permanece o mesmo
			f.setCli_nome(novaFatura.getCli_nome());

			// a data permanece a original - de quando foi gerada
			f.setFat_data(novaFatura.getFat_data());

			// subtrai valorFatura - valorPago = restante
			Double valorRestante = novaFatura.getFat_valor() - valorPagamento;

			// define fatura nova como não pago
			f.setFat_status("Não pago");
			f.setFat_dataPago(null);
			f.setFat_valorPago(null);

			// não tem como ser negativo, se não quer dizer que foi pago a mais
			if (valorRestante > 0) {
				f.setFat_valor(valorRestante);
				dao.salvar(f);
			} 
			

			Messages.addGlobalInfo("Fatura PAGA com sucesso");

			carregaFaturas();
			listar();		

		} catch (Exception e) {
			Messages.addGlobalInfo("Erro ao pagar fatura");
			e.printStackTrace();
		}

	}

	
	// Chamar método ao iniciar programa
	// @PostConstruct


	public Boolean checaPago(Faturas fatura) {
		
		return fatura.getFat_status().equalsIgnoreCase("Pago");
		//return desativado;
		
	}

	private void carregaFaturas() {
		try {
			ClienteDao dao = new ClienteDao();
			clientes = (ArrayList<Cliente>) dao.listarTodos();

		} catch (Exception e) {

			Messages.addGlobalInfo("Erro ao listar clientes");
			e.printStackTrace();

		}
	}

	public Faturas getF() {
		return f;
	}

	public void setF(Faturas f) {
		this.f = f;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public ArrayList<Faturas> getListaFaturas() {
		return listaFaturas;
	}

	public void setListaFaturas(ArrayList<Faturas> listaFaturas) {
		this.listaFaturas = listaFaturas;
	}

}
