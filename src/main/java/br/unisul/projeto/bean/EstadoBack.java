package br.unisul.projeto.bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.unisul.projeto.dao.EstadoDao;
import br.unisul.projeto.domain.Estado;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped

public class EstadoBack implements Serializable {

	private Estado estado = new Estado();
	private ArrayList<Estado> estados = new ArrayList<Estado>();

	@PostConstruct
	public void listar() {
		try {
			EstadoDao dao = new EstadoDao();
			estados = (ArrayList<Estado>) dao.listarTodos();
		} catch (Exception e) {
			Messages.addGlobalInfo("Erro ao listar UFs");
			e.printStackTrace();
		}
	}

	public void edita(ActionEvent evt) {
		estado = (Estado) evt.getComponent().getAttributes().get("ufAlterar");
		EstadoDao dao = new EstadoDao();
		dao.alterar(estado);
		estados = (ArrayList<Estado>) dao.listarTodos();
	}

	public void excluir(ActionEvent evt) {
		estado = (Estado) evt.getComponent().getAttributes().get("ufExcluir");
		EstadoDao dao = new EstadoDao();
		dao.excluir(estado);
		estados = (ArrayList<Estado>) dao.listarTodos();
		// Messages.addGlobalInfo(estado.getNome() + "-" + estado.getUf());

	}

	public void cadastra() {

		EstadoDao dao = new EstadoDao();
		dao.salvar(estado);
		// System.out.println(estado.getNome() + " - " + estado.getUf());
		Messages.addGlobalInfo(estado.getNome() + " - " + estado.getUf());
		estados = (ArrayList<Estado>) dao.listarTodos();
		estado = new Estado();

	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public ArrayList<Estado> getEstados() {
		return estados;
	}

	public void setEstados(ArrayList<Estado> estados) {
		this.estados = estados;
	}

}
