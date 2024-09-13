package tw.test.testS1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tw.test.bcrypt.BCrypt;
import tw.test.testS1.dao.UserDao;
import tw.test.testS1.model.User;
import tw.test.testS1.model.UserReturn;

@Component
public class UserSeriveImplement implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public UserReturn addUser(User user) {
		
		user.setPassword(BCrypt.hashpw(user.getPassword(),BCrypt.gensalt()));
		User newUser = userDao.add(user);
		
		UserReturn userReturn = new UserReturn();
		if(newUser != null) {
			userReturn.setMessage("ok");
			userReturn.setId(user.getId());
			userReturn.setAccount(user.getAccount());
			userReturn.setName(user.getName());
		}else {
			userReturn.setMessage("not ok");;
		}
		
		return userReturn;
	}
	
}
