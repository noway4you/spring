package tw.test.testS4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tw.test.bcrypt.BCrypt;
import tw.test.testS4.dao.UserDao;
import tw.test.testS4.model.User;
import tw.test.testS4.model.UserReturn;
import tw.test.testS4.model.UserV2;
import tw.test.testS4.repository.UserRepository;


@Component
public class UserServiceImplement implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserReturn addUser(User user)  {
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
		
		User newUser = userDao.add(user);
		UserReturn userReturn = new UserReturn();
		
		if (newUser != null) {
			userReturn.setMesg("OK");
			userReturn.setId(user.getId());
			userReturn.setAccount(user.getAccount());
			userReturn.setName(user.getName());
		}else {
			userReturn.setMesg("ERR");
		}
		return userReturn; 
	}

	@Override
	public User getUser(Long id) {
		return userDao.getById(id);
	}

	@Override
	public UserV2 addUser(UserV2 user) {
		user.setPassword(BCrypt.hashpw(user.getPassword(),BCrypt.gensalt()));
		UserV2 user2 = userRepository.save(user);
		return user2;
	}

}