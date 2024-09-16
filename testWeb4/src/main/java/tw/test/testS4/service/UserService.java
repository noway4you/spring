package tw.test.testS4.service;

import tw.test.testS4.model.User;
import tw.test.testS4.model.UserReturn;
import tw.test.testS4.model.UserV2;

public interface UserService {
	public UserReturn addUser(User user);
	public User getUser(Long id);
	public UserV2 addUser(UserV2 user);

}