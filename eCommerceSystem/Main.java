package eCommerceSystem;

import eCommerceSystem.business.concretes.UserManager;
import eCommerceSystem.core.concretes.BusinessException;
import eCommerceSystem.dataAccess.concretes.UserJdbcDao;
import eCommerceSystem.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		UserManager userManager = new UserManager(new UserJdbcDao());
		User user1 = new User(1, "Celal", "Yalçýn", "123456", "celal@");
		User user2 = new User(2, "Oðuzhan", "Duymaz", "134567", "oguz@");
		User user3 = new User(3, "Mehmet", "Yurdakul", "124567", "mehmet@");
		User user4 = new User(1, "Orhan", "inanç", "123567", "orhan@");
	try {

		userManager.add(user1);
		userManager.add(user2);
		userManager.add(user3);
		userManager.update(user4);
		userManager.delete(user2);

	} catch (BusinessException e) {

		System.out.println(e.getMessage());
	}
	System.out.println("--Kullanýcý listesi--");
	for (User user : userManager.getAll()) {
		
		System.out.println(user.getId()+" "+user.getFirstName()+" "+ user.getLastName()+ " " + user.geteMail());
	}
	
}

}
