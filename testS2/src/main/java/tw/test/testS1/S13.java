package tw.test.testS1;

import java.util.List;

import org.aspectj.weaver.patterns.ExactAnnotationFieldTypePattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tw.test.bcrypt.BCrypt;
import tw.test.testS1.model.User;

@RestController
public class S13 {
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@RequestMapping("/S13_1")
	public String S13_1(@RequestBody List<User> userList) {
		
		String sql = "insert into user (account,password,name) values (:account,:password,:name)";
		
		MapSqlParameterSource[] source = new MapSqlParameterSource[userList.size()];
		for(int i = 0 ; i < userList.size() ; i++) {
			User user = userList.get(i);
			source[i] = new MapSqlParameterSource();
			source[i].addValue("account",user.getAccount());
			source[i].addValue("password",BCrypt.hashpw(user.getPassword(),BCrypt.gensalt()));
			source[i].addValue("name",user.getName());
		}
		
		namedParameterJdbcTemplate.batchUpdate(sql,source);
		
		return "S13_1";
	}
	
	@RequestMapping("/S13_2")
	public String S13_2() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		String url = "https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvTravelStay.aspx";
		String content = restTemplate.getForObject(url,String.class);
		System.out.println(content);
		
		return "S13_2";
	}
	
	@RequestMapping("/S13_3")
	public User S13_3() throws Exception {
		
		String user = "{\"id\":7,\"account\":\"test1\",\"password\":\"test2\",\"name\":\"test3}";
		ObjectMapper mapper = new ObjectMapper();
		try {
			User newUser = mapper.readValue(user,User.class);
			System.out.println(newUser.getName());
			return newUser;
		} catch (Exception e) {
			System.out.println(e);
			throw new Exception();
		}
	}
	
	
}