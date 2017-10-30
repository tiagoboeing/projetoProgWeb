package br.unisul.projeto.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.unisul.projeto.domain.Cliente;
import br.unisul.projeto.domain.Faturas;
import br.unisul.projeto.util.HibernateUtil;


public class FaturasDao {

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
	
	public void alterar(Faturas f) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction t = null;

		try {
			t = sessao.beginTransaction();
			sessao.merge(f);
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

	public void excluir(Faturas f) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction t = null;

		try {
			t = sessao.beginTransaction();
			sessao.delete(f);
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

	public void salvar(Faturas f) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction t = null;

		try {
			t = sessao.beginTransaction();
			sessao.merge(f);
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
	
	
	// pagar fatura
	// @arguments: objeto fatura
	public Faturas pagarFatura(Faturas f) {
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction t = null;
		
		try {
			
			//abre sessão
			t = sessao.beginTransaction();
			
			sessao.merge(f);
			t.commit();

			
		} catch (Exception e) {
			if (t != null) {
				t.rollback();
			}
			throw (e);

		} finally {
			sessao.close();
		}
		
		return f;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<Faturas> listarTodasFaturas()
	{
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		try {
			Criteria consulta = sessao.createCriteria(Faturas.class);
			List<Faturas> resultado = consulta.list();
			return resultado;
			
		} catch (Exception e) {
			throw(e);
			
		}finally {
			sessao.close();
			
		}
	}

}