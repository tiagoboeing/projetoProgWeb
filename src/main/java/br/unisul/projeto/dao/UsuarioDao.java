package br.unisul.projeto.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.unisul.projeto.domain.Usuario;
import br.unisul.projeto.util.HibernateUtil;

public class UsuarioDao {

	public Usuario buscarLoginSenha(String login, String senha) {

		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		try {

			Criteria consulta = sessao.createCriteria(Usuario.class);
			consulta.add(Restrictions.eq("login", login));
			consulta.add(Restrictions.eq("senha", senha));
			Usuario resultado = (Usuario) consulta.uniqueResult();
			return resultado;

		} catch (RuntimeException e) {

			throw (e);

		} finally {
			sessao.close();

		}

	}

}
