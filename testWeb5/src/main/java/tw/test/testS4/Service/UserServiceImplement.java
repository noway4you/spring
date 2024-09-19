package tw.test.testS4.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.test.bcrypt.BCrypt;
import tw.test.testS4.Model.ResponseUser;
import tw.test.testS4.Model.User;
import tw.test.testS4.Model.UserStatus;
import tw.test.testS4.Repository.UserRepository;

@Service
public class UserServiceImplement implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public ResponseUser regUser(User user) {
		ResponseUser responseUser = isExistUser(user.getAccount());
		if(responseUser.getUserStatus() == UserStatus.NON_EXIST) {
			user.setPassword(BCrypt.hashpw(user.getPassword(),BCrypt.gensalt()));
			User newUser = userRepository.save(user);
			if(newUser.getId() != null) {
				responseUser.setUserStatus(UserStatus.ADD_SUCCESS);
				responseUser.setMessage("add success");
				responseUser.setUser(newUser);
			}else {
				responseUser.setUserStatus(UserStatus.ADD_FAILURE);
				responseUser.setMessage("add failure");
				responseUser.setUser(user);
			}
		}else {
			responseUser.setMessage("this account has existed");
		}
		
		return responseUser;
	}

	@Override
	public ResponseUser isExistUser(String account) {
		
		ResponseUser responseUser = new ResponseUser();
		List<User> users = userRepository.findByAccount(account);
		if(users!=null && users.size()>0) {
			responseUser.setUserStatus(UserStatus.EXISTED);
			responseUser.setMessage("this.account has existed");
			responseUser.setUser(users.get(0));
		}else {
			responseUser.setUserStatus(UserStatus.NON_EXIST);
			responseUser.setMessage("this account is not existed");
			responseUser.setUser(null);
		}
		return responseUser;
	}

	@Override
	public ResponseUser loginUser(User user) {
		
		ResponseUser responseUser = isExistUser(user.getAccount());
		if(responseUser.getUserStatus() == UserStatus.NON_EXIST) {
			responseUser.setUserStatus(UserStatus.LOGIN_FAILURE);
			responseUser.setMessage("Login Failure");
			responseUser.setUser(user);
		}else {
			User userDB = responseUser.getUser();
			if(BCrypt.checkpw(user.getPassword(),userDB.getPassword())) {
				responseUser.setUserStatus(UserStatus.LOGIN_SUCCESS);
				responseUser.setMessage("Login Success");
				responseUser.setUser(userDB);
			}else {
				responseUser.setUserStatus(UserStatus.LOGIN_FAILURE);
				responseUser.setMessage("Login Failure");
				responseUser.setUser(user);
			}
		}
		
		return responseUser;
	}

	@Override
	public User updateUser(User user) {
		
		User userDB = userRepository.findById(user.getId()).orElse(null);
		if(userDB!=null) {
			if(user.getAccount()!=null) userDB.setAccount(user.getAccount());
			if(user.getName()!=null) userDB.setName(user.getName());
			if(user.getDetail()!=null && user.getDetail().getNickname()!=null) {
				userDB.getDetail().setNickname(user.getDetail().getNickname());
			}
			userRepository.save(userDB);
			return userDB;
		}else {
			System.out.println("not found");
			return null;
		}
	}

	@Override
	public void deleteUser(Long id) {
		
		userRepository.deleteById(id);
		
//		User userDB = userRepository.findById(id).orElse(null);
//		if(userDB!=null) {
//			userRepository.delete(userDB);
//		}
	}
}
