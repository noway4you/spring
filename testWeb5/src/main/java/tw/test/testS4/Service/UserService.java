package tw.test.testS4.Service;

import tw.test.testS4.Model.ResponseUser;
import tw.test.testS4.Model.User;

public interface UserService {
	
	public ResponseUser regUser(User user);
	public ResponseUser isExistUser(String account);
	public ResponseUser loginUser(User user);
	public User updateUser(User user);
	public void deleteUser(Long id);
	
}
