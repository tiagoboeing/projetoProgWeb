package br.unisul.projeto.bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.unisul.projeto.dao.ClienteDao;
import br.unisul.projeto.dao.EstadoDao;
import br.unisul.projeto.domain.Cliente;
import br.unisul.projeto.domain.Estado;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped

public class ClienteBack implements Serializable{

	private Cliente c = new Cliente();
	private ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

	@PostConstruct
	public void listar() {
		try {
			
			ClienteDao dao = new ClienteDao();
			listaClientes = (ArrayList<Cliente>) dao.listarTodos();
			
		} catch (Exception e) {
			
			Messages.addGlobalInfo("Erro ao listar Clientes");
			e.printStackTrace();
			
		}
	}

	public void edita(ActionEvent evt) {
		
		c = (Cliente) evt.getComponent().getAttributes().get("idAlterar");
		ClienteDao dao = new ClienteDao();
		
		dao.alterarCliente(c);
		
		listaClientes = (ArrayList<Cliente>) dao.listarTodos();
		
	}

	public void exclui(ActionEvent evt){ 
//		estado = (Estado) evt.getComponent().getAttributes().get("ufExcluir");
//		
//		Messages.addGlobalInfo(estado.getNomeEstado() + "-" + estado.getUfEstado());
		
		c = (Cliente) evt.getComponent().getAttributes().get("idExcluir");
		ClienteDao dao = new ClienteDao();
		dao.excluir(c);
		
		listaClientes = (ArrayList<Cliente>)dao.listarTodos();
		//Messages.addGlobalInfo(estado.getNome() + "-" + estado.getUf());
	}

	public void cadastra() {

		ClienteDao dao = new ClienteDao();
		dao.salvarCliente(c);
		
		// System.out.println(estado.getNome() + " - " + estado.getUf());
		Messages.addGlobalInfo(c.getCli_nome() + " - " + c.getCli_sobrenome());
		
		listaClientes = (ArrayList<Cliente>) dao.listarTodos();
		c = new Cliente();

	}

	public Cliente getC() {
		return c;
	}

	public void setC(Cliente c) {
		this.c = c;
	}

	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	
	
}
