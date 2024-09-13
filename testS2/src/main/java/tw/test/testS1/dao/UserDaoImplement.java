package tw.test.testS1.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;

import tw.test.testS1.model.User;

@Component
public class UserDaoImplement implements UserDao{

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public User add(User user) {
		String sql = "insert into user (account,password,name) values (:account,:password,:name)";
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("account",user.getAccount());
		map.put("password",user.getPassword());
		map.put("name",user.getName());
		
		// get the id of the new added data 
		GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
		MapSqlParameterSource source = new MapSqlParameterSource(map);
		
		
		int num = namedParameterJdbcTemplate.update(sql,source,keyHolder);
		if(num > 0) {
			Long id =  keyHolder.getKey().longValue();
			user.setId(id);
			return user;
		}else {
			return null;
		}
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(User user, Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User user, Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getByAccount(String account) {
		// TODO Auto-generated method stub
		return null;
	}
}
