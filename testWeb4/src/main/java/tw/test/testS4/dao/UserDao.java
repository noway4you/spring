package tw.test.testS4.dao;

import java.util.*;

import tw.test.testS4.model.User;

public interface UserDao {
	public User add(User user);
	
	public void delete(User user);
	public void delete(User user, Long id);
	
	public void update(User user);
	public void update(User user, Long id);
	
	public List<User> getAll();
	public User getById(Long id);
	public User getByAccount(String account);
	
}