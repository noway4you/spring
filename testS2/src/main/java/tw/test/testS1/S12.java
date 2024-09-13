package tw.test.testS1;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class S12 {
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@RequestMapping("/S12_1")
	public String S12_1() {
		
		String sql = "insert into user (account,password,name) values ('AAA','123','AAA123')";
		Map<String,Object> map = new HashMap<String,Object>();
		namedParameterJdbcTemplate.update(sql,map);
		
		return "S12_1";
	}
	
	@RequestMapping("/S12_2")
	public String S12_2() {
		
		String sql = "insert into user (account,password,name) values (:account,:password,:name)";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("account","BBB");
		map.put("password","123");
		map.put("name","BBB123");
		namedParameterJdbcTemplate.update(sql,map);
		
		return "S12_2";
	}
	
	@RequestMapping("/S12_3/{id}")
	public String S12_3(@PathVariable Long id) {
		
		String sql = "delete from user where id = :id";
		HashMap<String,Object> map = new HashMap<String, Object>();
		map.put("id",id);
		namedParameterJdbcTemplate.update(sql,map);
		
		return "S12_3";
	}
	
}
