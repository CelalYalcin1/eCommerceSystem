package eCommerceSystem.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerceSystem.dataAccess.abstracts.UserDao;
import eCommerceSystem.entities.concretes.User;

public class UserJdbcDao implements UserDao {
	List<User> users = new ArrayList<User>();
	
	@Override
	public List<User> getAll() {
		
		return users;
	}

	@Override
	public void add(User user) {
		users.add(user);
		System.out.println("Jdbc'ye eklendi");
	}

	@Override
	public void update(User entity) {
		for (User user : users) {
			if(user.getId() == entity.getId()) {
				users.set(users.indexOf(user), entity);
				System.out.println("Jdbc'de güncellendi");
				break;
			}
		}
		
	}

	@Override
	public void delete(User user) {
		users.remove(user);
		System.out.println("Jdbc'den silindi");
		
	}

}
