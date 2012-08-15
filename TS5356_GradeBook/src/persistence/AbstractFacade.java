package persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ejb.Remote;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Remote
public abstract class AbstractFacade<T> {

	private Class<T> entityClass;
	
	public AbstractFacade() {
	}
	
	public AbstractFacade(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
	
	protected abstract EntityManager getEm();
	
	public void persist(T entity) {
		getEm().persist(entity);
	}
	
	public void merge(T entity) {
		getEm().merge(entity);
	}
	
	public void remove(T entity) {
		getEm().remove( getEm().merge(entity) );
	}
	
	public T find(Object id) {
		return getEm().find(entityClass, id);
	}
	
	public List<T> findAll(Class<T> clazz) {
		String queryStr = new String("SELECT a FROM " + clazz.getSimpleName() + " a");
		Query query = getEm().createQuery(queryStr);
		return query.getResultList();
	}
	
	public List<T> findByParams(String queryName, Map<String, Object> params) {
		
		Query query = getEm().createNamedQuery(queryName);
		setQueryParameters(query, params);
		
		return query.getResultList();
	}
	
	public List<T> findByParam(String queryName, String paramName, Object paramValue) {
		Map<String, Object> params = new HashMap<String,Object>();
		params.put(paramName, paramValue);
		return findByParams(queryName, params);
	}
	
	public T findSingleByParams(String queryName, Map<String, Object> params) {
		List<T> results = findByParams(queryName, params);
		T result = null;
		
		switch(results.size()) {
		case 0:
			break;
		case 1:
			result = results.get(0);
			break;
		default:
			throw new RuntimeException("More than one result was found for the provided parameters.");
		}
		
		return result;
	}
	
	public T findSingleByParam(String queryName, String paramName, Object paramValue) {
		Map<String, Object> params = new HashMap<String,Object>();
		params.put(paramName, paramValue);
		return findSingleByParams(queryName, params);
	}
	
	public List<T> executeQuery(Class<T> clazz, String queryString, Map<String, Object> params) {
		Query query = getEm().createQuery(queryString, clazz);
		setQueryParameters(query, params);
		return query.getResultList();
	}

	private void setQueryParameters(Query query, Map<String, Object> params) {
		for(Entry<String, Object> param : params.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}
	}

}
