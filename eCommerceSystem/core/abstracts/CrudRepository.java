package eCommerceSystem.core.abstracts;

import java.util.List;

import eCommerceSystem.core.concretes.Entity;

public interface CrudRepository<T extends Entity> {
	List<T> getAll();
	void add(T entity);
	void update(T entity);
	void delete(T entity);
	
}
