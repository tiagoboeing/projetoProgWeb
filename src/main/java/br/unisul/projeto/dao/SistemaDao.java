package br.unisul.projeto.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.unisul.projeto.domain.Sistema;
import br.unisul.projeto.util.HibernateUtil;

public class SistemaDao {
	
	
	// novo
	public Sistema novoArquivo(Sistema sistema) {
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction t = null;
		Sistema novo = null;

		try {
			t = sessao.beginTransaction();
			novo = (Sistema) sessao.merge(sistema);
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
	
	
	// editar - salva alterações
	public void salvaAlteracoesSistema(Sistema sistema) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction t = null;

		try {
			t = sessao.beginTransaction();
			sessao.merge(sistema);
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
	
	
	
	// salvar - upload
	public Sistema salvaUpload(Sistema sistema) {
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction t = null;
		
		Sistema novo = null;

		try {
			t = sessao.beginTransaction();
			novo = (Sistema) sessao.merge(sistema);
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
	
	
	// Excluir
	public void excluirArquivo(Sistema sistema) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction t = null;

		try {
			t = sessao.beginTransaction();
			sessao.delete(sistema);
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
	
	
	// LISTAR
	@SuppressWarnings("unchecked")
	public List<Sistema> listarTodos() {
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		try {
			Criteria consulta = sessao.createCriteria(Sistema.class);
			List<Sistema> resultado = consulta.list();
			return resultado;

		} catch (Exception e) {
			throw (e);

		} finally {
			sessao.close();

		}
	}
	

}
