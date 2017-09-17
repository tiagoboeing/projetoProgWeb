package br.unisul.projeto.bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.unisul.projeto.dao.ClienteDao;
import br.unisul.projeto.dao.CrediarioDao;
import br.unisul.projeto.domain.Cliente;
import br.unisul.projeto.domain.Crediario;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CrediarioBack implements Serializable {

	private Crediario crediario = new Crediario();
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private ArrayList<Crediario> crediarios = new ArrayList<Crediario>();

	@PostConstruct
	public void listar() {
		try {
			CrediarioDao dao = new CrediarioDao();
			crediarios = (ArrayList<Crediario>) dao.listarTodosCrediarios();
		} catch (Exception e) {
			Messages.addGlobalInfo("Erro ao listar crediarios");
			e.printStackTrace();
		}
	}

	public void novo() {

		crediario = new Crediario();
		carregaClientes();

	}

	public void salvar() {

		try {
			CrediarioDao dao = new CrediarioDao();
			dao.salvar(crediario);

			Messages.addGlobalInfo("Crediario cadastrado com sucesso");
			novo();
			listar();

		} catch (Exception e) {
			Messages.addGlobalInfo("Erro ao cadastrar Crediario");
			e.printStackTrace();
		}

	}

	public void alterar(ActionEvent evt) {

		crediario = (Crediario) evt.getComponent().getAttributes().get("clienteAlterar");
		// CidadeDao dao = new CidadeDao();
		// dao.alterar(cidade);
		// cidades = (ArrayList<Cidade>)dao.listarTodos();
		carregaClientes();
		listar();

	}

	public void excluir(ActionEvent evt) {

		crediario = (Crediario) evt.getComponent().getAttributes().get("clienteExcluir");
		CrediarioDao dao = new CrediarioDao();
		dao.excluir(crediario);
		crediarios = (ArrayList<Crediario>) dao.listarTodosCrediarios();
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

	public Crediario getCrediario() {
		return crediario;
	}

	public void setCrediario(Crediario crediario) {
		this.crediario = crediario;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public ArrayList<Crediario> getCrediarios() {
		return crediarios;
	}

	public void setCrediarios(ArrayList<Crediario> crediarios) {
		this.crediarios = crediarios;
	}

}
