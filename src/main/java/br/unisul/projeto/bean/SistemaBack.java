package br.unisul.projeto.bean;

import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.omnifaces.util.Messages;
import br.unisul.projeto.dao.SistemaDao;
import br.unisul.projeto.domain.Sistema;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped

public class SistemaBack implements Serializable{
	
	
	private ArrayList<Sistema> listaArquivos = new ArrayList<Sistema>();

	Sistema sistema = new Sistema();
	
	
	//LISTAR
	@PostConstruct
	public void listarArquivos() {
		try {

			SistemaDao dao = new SistemaDao();
			listaArquivos = (ArrayList<Sistema>) dao.listarTodos();

		} catch (Exception e) {

			Messages.addGlobalInfo("Erro ao listar arquivos");
			e.printStackTrace();

		}
	}

	

	
	// getters and setters
	public ArrayList<Sistema> getListaArquivos() {
		return listaArquivos;
	}

	public void setListaArquivos(ArrayList<Sistema> listaArquivos) {
		this.listaArquivos = listaArquivos;
	}



	public Sistema getSistema() {
		return sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}
	
	
	
	

}
