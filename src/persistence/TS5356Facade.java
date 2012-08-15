package persistence;

import javax.ejb.Remote;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Remote
public abstract class TS5356Facade<T> extends AbstractFacade<T> {

	@PersistenceContext(unitName = "TS5356")
	private EntityManager em;

	public TS5356Facade() {
		super();
	}
	
	public TS5356Facade(Class<T> entityClass) {
		super(entityClass);
	}

	@Override
	protected EntityManager getEm() {
		return em;
	}

}
