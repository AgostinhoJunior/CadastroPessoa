package sc.senac.br.cadastropessoa.jpautil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory factory = null;

	static {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory("cadastropessoa-PU");
		}
	}

	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

	public static Object getPrimaryKeyObject(Object entity) {
		return factory.getPersistenceUnitUtil().getIdentifier(entity);
	}
}
