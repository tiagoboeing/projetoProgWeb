package br.unisul.projeto.bean;

import java.io.Serializable;
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
