package sc.senac.br.cadastropessoa.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import sc.senac.br.cadastropessoa.jpautil.JPAUtil;

public class DaoGeneric<E> implements Serializable{

	private EntityManager entityManager = JPAUtil.getEntityManager();

	public void salvar(E entidade) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(entidade);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void alterar(E entidade) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(entidade);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void deletar(E entidade) {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(entidade);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void deletarPorId(E entidade) {
		try {
			entityManager.getTransaction().begin();
			Object id = JPAUtil.getPrimaryKeyObject(entidade);
			entityManager.remove(id);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public List<E> listarTodos(Class<E> entidade) {
		List<E> retorno = entityManager.createQuery("from " + entidade.getName()).getResultList();
		try {
			entityManager.getTransaction().begin();

			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		return retorno;
	}

}