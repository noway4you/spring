package tw.test.testS1.dao;

import java.util.List;

import tw.test.testS1.model.User;

public interface UserDao {
	
	public User add(User user);
	
	public void update(User user);
	public void update(User user , Long id);
	
	public void delete(User user);
	public void delete(User user , Long id);
	
	public List<User> getAll();
	public User getById(Long id);
	public User getByAccount(String account);
	
}
