package eCommerceSystem.business.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerceSystem.business.abstracts.UserService;
import eCommerceSystem.core.concretes.BusinessException;
import eCommerceSystem.dataAccess.abstracts.UserDao;
import eCommerceSystem.dataAccess.concretes.UserJdbcDao;
import eCommerceSystem.entities.concretes.User;

public class UserManager implements UserService{
	
	UserDao userDao = new UserJdbcDao();
	
	public UserManager(UserDao userDao) {
		this.userDao = userDao;
	}
	private boolean checkName(User user) throws BusinessException{
		if (user.getFirstName().length()<2 || user.getLastName().length()<2) {
			throw new BusinessException("Ad-Soyad en az iki karakterden oluþmalýdýr.");
		}
		return true;
	}
	private boolean checkPassword(User user) throws BusinessException{
		if (user.getPassword().length()<6) {
			throw new BusinessException("Parola en az 6 karakterden oluþmalýdýr.");
		}
		return true;
	}
	private boolean checkEmailIsValid(User user) throws BusinessException{
		if (user.geteMail().contains("@")) {
			return true;
			}
		throw new BusinessException("Email geçersizdir.");
	}
	private boolean checkEmailIsUsedBefore(User user) throws BusinessException {
		for (int i = 0; i < getAll().size(); i++) {
			if (user.geteMail() == getAll().get(i).geteMail()) {
				throw new BusinessException("E-mail kullanýlmaktadýr.");
			}
		}
		return true;
	}
	
	@Override
	public void add(User user) throws BusinessException {
		if (checkName(user) && checkPassword(user) && checkEmailIsUsedBefore(user)
				&& checkEmailIsValid(user)) {
			userDao.add(user);
			System.out.println(user.getFirstName() + " " + user.getLastName() + " eklendi.");
		}
	}

	@Override
	public void update(User user) throws BusinessException {
		if (checkName(user) && checkPassword(user) && checkEmailIsValid(user)) {
			userDao.update(user);
			System.out.println(user.getId() +" ID'li"+ user.getFirstName() + " " + user.getLastName() + " güncellendi.");
		}
		
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
		System.out.println(user.getFirstName() + " " + user.getLastName() + " silindi.");
		
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userDao.getAll();
	}

}
