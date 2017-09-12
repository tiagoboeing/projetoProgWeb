package br.unisul.projeto.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.unisul.projeto.domain.Estado;
import br.unisul.projeto.util.HibernateUtil;


public class EstadoDao {

	public void alterar(Estado estado) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction t = null;

		try {
			t = sessao.beginTransaction();
			sessao.merge(estado);
			t.commit();

		} catch (Exception e) {
			if (t != null) {
				t.rollback();
			}
			throw (e);

		} finally {
			sessao.close();

		}
	}

	public void excluir(Estado estado) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction t = null;

		try {
			t = sessao.beginTransaction();
			sessao.delete(estado);
			t.commit();

		} catch (Exception e) {
			if (t != null) {
				t.rollback();
			}
			throw (e);

		} finally {
			sessao.close();

		}
	}

	@SuppressWarnings("unchecked")
	public List<Estado> listarTodos() {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		try {
			Criteria consulta = sessao.createCriteria(Estado.class);
			List<Estado> resultado = consulta.list();
			return resultado;

		} catch (Exception e) {
			throw (e);

		} finally {
			sessao.close();

		}
	}

	public void salvar(Estado estado) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction t = null;

		try {
			t = sessao.beginTransaction();
			sessao.merge(estado);
			t.commit();

		} catch (Exception e) {
			if (t != null) {
				t.rollback();
			}
			throw (e);

		} finally {
			sessao.close();

		}
	}
}
