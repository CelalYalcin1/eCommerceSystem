package eCommerceSystem.business.abstracts;

import java.util.List;

import eCommerceSystem.entities.concretes.User;
import eCommerceSystem.core.concretes.BusinessException;
public interface UserService {
	
	void add(User user) throws BusinessException;
	void update(User user) throws BusinessException;
	void delete(User user);
	List<User> getAll();
}
