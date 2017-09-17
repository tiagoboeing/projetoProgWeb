package br.unisul.projeto.bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.unisul.projeto.dao.ProdutoDao;
import br.unisul.projeto.domain.Produto;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped

public class ProdutoBack implements Serializable {

	private Produto p = new Produto();
	private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();

	@PostConstruct
	public void listar() {
		try {

			ProdutoDao dao = new ProdutoDao();
			listaProdutos = (ArrayList<Produto>) dao.listarTodosProdutos();

		} catch (Exception e) {

			Messages.addGlobalInfo("Erro ao listar Produtos");
			e.printStackTrace();

		}
	}

	public void edita(ActionEvent evt) {

		p = (Produto) evt.getComponent().getAttributes().get("idAlterar");
		ProdutoDao dao = new ProdutoDao();

		dao.alterarProduto(p);

		listaProdutos = (ArrayList<Produto>) dao.listarTodosProdutos();

	}

	public void exclui(ActionEvent evt) {
		// estado = (Estado) evt.getComponent().getAttributes().get("ufExcluir");
		//
		// Messages.addGlobalInfo(estado.getNomeEstado() + "-" + estado.getUfEstado());

		p = (Produto) evt.getComponent().getAttributes().get("idExcluir");
		ProdutoDao dao = new ProdutoDao();
		dao.excluir(p);

		listaProdutos = (ArrayList<Produto>) dao.listarTodosProdutos();
		// Messages.addGlobalInfo(estado.getNome() + "-" + estado.getUf());
	}

	public void cadastra() {

		ProdutoDao dao = new ProdutoDao();
		dao.salvarProduto(p);

		// System.out.println(estado.getNome() + " - " + estado.getUf());
		Messages.addGlobalInfo(p.getPro_nome() + " - " + p.getPro_valor());

		listaProdutos = (ArrayList<Produto>) dao.listarTodosProdutos();
		p = new Produto();

	}

	public Produto getP() {
		return p;
	}

	public void setP(Produto p) {
		this.p = p;
	}

	public ArrayList<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setlistaProdutos(ArrayList<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
}
