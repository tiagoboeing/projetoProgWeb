package br.unisul.projeto.bean;

import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import br.unisul.projeto.dao.ClienteDao;
import br.unisul.projeto.domain.Cliente;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped

public class ClienteBack implements Serializable {

	//private Cliente c = new Cliente();
	private ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

	Cliente cliente = new Cliente();

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

		cliente = (Cliente) evt.getComponent().getAttributes().get("idAlterar");
		ClienteDao dao = new ClienteDao();

		dao.alterarCliente(cliente);

		listaClientes = (ArrayList<Cliente>) dao.listarTodos();

	}

	public void exclui(ActionEvent evt) {
		// estado = (Estado) evt.getComponent().getAttributes().get("ufExcluir");
		//
		// Messages.addGlobalInfo(estado.getNomeEstado() + "-" + estado.getUfEstado());

		cliente = (Cliente) evt.getComponent().getAttributes().get("idExcluir");
		ClienteDao dao = new ClienteDao();
		dao.excluir(cliente);

		listaClientes = (ArrayList<Cliente>) dao.listarTodos();
		// Messages.addGlobalInfo(estado.getNome() + "-" + estado.getUf());
	}

	

	public void upload(FileUploadEvent evento) {

		try {

			UploadedFile x = evento.getFile();
			// Cria um espaço temporario no servidor
			Path t = Files.createTempFile(null, null);
			Files.copy(x.getInputstream(), t, StandardCopyOption.REPLACE_EXISTING);

			cliente.setPathTemp(t.toString());

		} catch (Exception e) {
			// TODO: handle exception
		}

		Messages.addGlobalInfo(cliente.getPathTemp());

	}

	public void cadastra() {

		ClienteDao dao = new ClienteDao();
		dao.salvarCliente(cliente);

		// System.out.println(estado.getNome() + " - " + estado.getUf());
		// Messages.addGlobalInfo(c.getCli_nome() + " - " + c.getCli_sobrenome());
		Messages.addGlobalInfo("Cliente cadastrado com sucesso");

		listaClientes = (ArrayList<Cliente>) dao.listarTodos();
		cliente = new Cliente();

	}
	
	public void salvar() {

		ClienteDao dao = new ClienteDao();
		Cliente clidn = dao.salvar(cliente);

		Path origem = Paths.get(cliente.getPathTemp());
		Path destino = Paths.get("C:/Users/tiagoboeing/Desktop/pweb/" + clidn.getCli_id() + ".png");
		
		try {

			Files.copy(origem, destino, StandardCopyOption.REPLACE_EXISTING);

		} catch (Exception e) {
			Messages.addGlobalInfo("Erro");
		}

		Messages.addGlobalInfo("Cliente cadastrado com sucesso");
		
		//listaClientes = (ArrayList<Cliente>) dao.listarTodos();
		cliente = new Cliente();

	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/*public Cliente getC() {
		return c;
	}

	public void setC(Cliente c) {
		this.c = c;
	}*/

	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

}
