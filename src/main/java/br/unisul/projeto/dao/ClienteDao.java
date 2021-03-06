package br.unisul.projeto.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.unisul.projeto.domain.Cliente;
import br.unisul.projeto.util.HibernateUtil;

public class ClienteDao {

	
	public void alterarCliente(Cliente cliente) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction t = null;

		try {
			t = sessao.beginTransaction();
			sessao.merge(cliente);
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

	public void excluir(Cliente cliente) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction t = null;

		try {
			t = sessao.beginTransaction();
			sessao.delete(cliente);
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
	public List<Cliente> listarTodos() {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		try {
			Criteria consulta = sessao.createCriteria(Cliente.class);
			List<Cliente> resultado = consulta.list();
			return resultado;

		} catch (Exception e) {
			throw (e);

		} finally {
			sessao.close();

		}
	}

	public void salvarCliente(Cliente cliente) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction t = null;

		try {
			t = sessao.beginTransaction();
			sessao.merge(cliente);
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

	public Cliente salvar(Cliente cliente) {
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction t = null;
		
		Cliente novo = null;

		try {
			t = sessao.beginTransaction();
			novo = (Cliente) sessao.merge(cliente);
			t.commit();

		} catch (Exception e) {
			if (t != null) {
				t.rollback();
			}
			throw (e);

		} finally {
			sessao.close();

		}
		return novo;
	}

}
