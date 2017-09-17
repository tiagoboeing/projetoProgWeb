package br.unisul.projeto.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.unisul.projeto.domain.Cliente;
import br.unisul.projeto.domain.Crediario;
import br.unisul.projeto.util.HibernateUtil;


public class CrediarioDao {

	@SuppressWarnings("unchecked")
	public List<Cliente> listarPorNome(Cliente cliente)
	{
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		try {
			Criteria consulta = sessao.createCriteria(Cliente.class);
			consulta.add(Restrictions.eq("cli_nome.cli_id", cliente.getCli_id()));
			consulta.addOrder(org.hibernate.criterion.Order.asc("nome"));
			List<Cliente> resultado = consulta.list();
			return resultado;
			
		} catch (Exception e) {
			throw(e);
			
		}finally {
			sessao.close();
			
		}
	}
	
	public void alterar(Cliente cliente) {
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

	public void excluir(Crediario crediario) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction t = null;

		try {
			t = sessao.beginTransaction();
			sessao.delete(crediario);
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
	public List<Cliente> listarTodosClientes() {
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

	public void salvar(Crediario crediario) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction t = null;

		try {
			t = sessao.beginTransaction();
			sessao.merge(crediario);
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
	public List<Crediario> listarTodosCrediarios()
	{
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		try {
			Criteria consulta = sessao.createCriteria(Crediario.class);
			List<Crediario> resultado = consulta.list();
			return resultado;
			
		} catch (Exception e) {
			throw(e);
			
		}finally {
			sessao.close();
			
		}
	}

}