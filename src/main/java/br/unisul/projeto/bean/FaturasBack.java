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
	
	//<!-- TENTANDO FAZER COM QUE A DATA APAREÇA AUTOMATICA -->
	//private java.util.Date datahoraInicio;
	        
	//pst.setTimestamp(5, new java.sql.Timestamp(p.getDatahoraInicio().getTime()));
	
	
	/*private String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date(0);
		return dateFormat.format(date);
	}*/
	
	
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
	
	
	// SALVAR VALOR PAGO
	public void pagarFatura(ActionEvent evt) {
	
		try {
			
			f = (Faturas) evt.getComponent().getAttributes().get("pagarFatura");
			FaturasDao dao = new FaturasDao();
			
			f.setFat_status("Pago");
			
			
			//paga atual
			dao.salvar(f);
			
			
			// salva cliente atual - backup
			Faturas nova = f.clonaFatura();
			
			f = new Faturas();
						
			// valorFatura - valorPago
			f.setFat_valor(nova.getFat_valor() - nova.getFat_valorPago());
					
			// status não pago da nova fatura
			f.setFat_status("Não pago");
			
			// ainda não foi paga - null
			f.setFat_valorPago(null);
			f.setFat_dataPago(null);
			
			f.setFat_data(nova.getFat_data());
			
			dao.salvar(f);
			
			// salva
			// novo();

			Messages.addGlobalInfo("Fatura PAGA com sucesso");
			
			carregaFaturas();
			listar();

		} catch (Exception e) {
			Messages.addGlobalInfo("Erro ao pagar fatura");
			e.printStackTrace();
		}
		

		/*
			dao.pagarFatura(f);
		*/
			// armazena valores por segurança
/*			Double valorPago = f.getFat_valorPago();
			String dataPago = f.getFat_dataPago();
			Double valor = f.getFat_valor();
			Cliente cliente = f.getCli_nome();
		
			f.setFat_valorPago(null);
			f.setFat_dataPago(null);
		
		dao.pagarFatura(f);

		
			f.setFat_id(null);
			
			// cria fatura com valor restante
			f.setFat_valor(valor - valorPago);
			
			//define data de pagamento vazia - não pago
			f.setFat_dataPago(dataPago);
			
			// status padrão para nova fatura
			f.setFat_status("Não pago");
			
			// define valor pago como vazio
			f.setFat_valorPago(null);
			
			// define cliente novamente
			f.setCli_nome(cliente);

		novo();*/
		
		//Messages.addGlobalInfo("Fatura paga com sucesso");
		
		
		// lista novamente todos os registros
		
		
	}
	
	

	// Serve para quando iniciar o program chamar o método para ser executado
	// @PostConstruct
	// public void iniciaTela() {
	// carregaUfs();
	// }

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
