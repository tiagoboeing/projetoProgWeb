package br.unisul.projeto.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.unisul.projeto.dao.UsuarioDao;
import br.unisul.projeto.domain.Usuario;
import br.unisul.projeto.util.SessionContext;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class LoginBack implements Serializable {

	private String login;
	private String senha;
	private Usuario user;

	public String fazLogin() {

		try {
			UsuarioDao dao = new UsuarioDao();
			user = dao.buscarLoginSenha(login, senha);

			if (user != null) {
				SessionContext.getInstance().setAttribute("usuarioLogado", user);
				return "/dashboard.xhtml?faces-redirect=true";

			} else {
				FacesContext.getCurrentInstance().validationFailed();
				return "";

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "";

		}

	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

}