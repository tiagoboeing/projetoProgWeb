package br.unisul.projeto.bean;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
		carregaClientes();

	}

	public void salvar() {

		try {
			FaturasDao dao = new FaturasDao();

			// status padrão
			f.setFat_status("Não pago");
					
			// data padrão
			String dataPadrao = "2006-12-23";	
			f.setFat_data(dataPadrao);
			
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
		
		carregaClientes();
		listar();

	}

	public void excluir(ActionEvent evt) {

		f = (Faturas) evt.getComponent().getAttributes().get("faturaExcluir");
		FaturasDao dao = new FaturasDao();
		dao.excluir(f);
		listaFaturas = (ArrayList<Faturas>) dao.listarTodasFaturas();
		carregaClientes();
		listar();
	}
	
	
	// SALVAR VALOR PAGO
	public void pagarFatura(ActionEvent evt) {
		
		f = (Faturas) evt.getComponent().getAttributes().get("pagarFatura");
		FaturasDao dao = new FaturasDao();
		
		dao.pagarFatura(f);
			
			f.setFat_id(null);
			
			// cria fatura com valor restante
			//FaturasDao dao2 = new FaturasDao();
			f.setFat_valor(f.getFat_valor() - f.getFat_valorPago());
			
			//define data de pagamento vazia - não pago
			f.setFat_dataPago(null);
			
			// status padrão para nova fatura
			f.setFat_status("Não pago");
			
			// define valor pago como vazio
			f.setFat_valorPago(null);
			
			dao.pagarFatura(f);

		
		Messages.addGlobalInfo("Fatura paga com sucesso");
		novo();
		listar();
		
	}
	
	

	// Serve para quando iniciar o program chamar o método para ser executado
	// @PostConstruct
	// public void iniciaTela() {
	// carregaUfs();
	// }

	private void carregaClientes() {
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
