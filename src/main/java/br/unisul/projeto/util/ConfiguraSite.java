package br.unisul.projeto.util;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ConfiguraSite implements Serializable {

	// PEGA INFORMAÇÕES DO SITE
	@PostConstruct
	public String dadosSite(String informacaoSolicitada) {
		String informacao = "nomeSite";

		try {

			// CONFIGURAR AQUI
			String nomeSite = "Projeto ProWeb";
			String urlSite = "http://localhost:8080/projetoProgWeb/";
			String arquivoIndex = "index.jsp";

			switch (informacaoSolicitada) {

				case "nomeSite":
					informacao = nomeSite;
					break;
	
				case "urlSite":
					informacao = urlSite;
					break;
	
				case "index":
					informacao = arquivoIndex;
					break;
	
				default:
					return "";
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return informacao;
	}
	
	
	public String teste() {
		
		try {
			return "testes";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "sss";
	}
	

}
