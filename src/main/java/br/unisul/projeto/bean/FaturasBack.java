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
	private ArrayList<Faturas> crediarios = new ArrayList<Faturas>();

	@PostConstruct
	public void listar() {
		try {
			FaturasDao dao = new FaturasDao();
			crediarios = (ArrayList<Faturas>) dao.listarTodosCrediarios();
		} catch (Exception e) {
			Messages.addGlobalInfo("Erro ao listar crediarios");
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

			Messages.addGlobalInfo("Crediario cadastrado com sucesso");
			novo();
			listar();

		} catch (Exception e) {
			Messages.addGlobalInfo("Erro ao cadastrar Crediario");
			e.printStackTrace();
		}

	}

	public void alterar(ActionEvent evt) {

		f = (Faturas) evt.getComponent().getAttributes().get("clienteAlterar");
		// CidadeDao dao = new CidadeDao();
		// dao.alterar(cidade);
		// cidades = (ArrayList<Cidade>)dao.listarTodos();
		carregaClientes();
		listar();

	}

	public void excluir(ActionEvent evt) {

		f = (Faturas) evt.getComponent().getAttributes().get("clienteExcluir");
		FaturasDao dao = new FaturasDao();
		dao.excluir(f);
		crediarios = (ArrayList<Faturas>) dao.listarTodosCrediarios();
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
			Messages.addGlobalInfo("Erro ao listar UFs");
			e.printStackTrace();
		}
	}

	public Faturas getCrediario() {
		return f;
	}

	public void setCrediario(Faturas crediario) {
		this.f = crediario;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public ArrayList<Faturas> getCrediarios() {
		return crediarios;
	}

	public void setCrediarios(ArrayList<Faturas> crediarios) {
		this.crediarios = crediarios;
	}

}
