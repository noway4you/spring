package tw.test.testS1.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import tw.test.testS1.model.Data;

@Component
public class DataDaoImplement implements DataDao{

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public void add(String content) {
		
		String sql = "insert into practice (name,address,phone) values (:name,:address,:phone)";
		ObjectMapper obj = new ObjectMapper();
		obj.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		try {
			
			List<Data> dataList = obj.readValue(content.toLowerCase(),new TypeReference<List<Data>>() {}); 
			MapSqlParameterSource[] source = new MapSqlParameterSource[dataList.size()];
			
			for(int i = 0 ; i < dataList.size() ; i++) {
				try {
					source[i] = new MapSqlParameterSource();
					source[i].addValue("name",dataList.get(i).getName());
					source[i].addValue("address",dataList.get(i).getAddress());
					source[i].addValue("phone",dataList.get(i).getTel());
				} catch (Exception e) {
					System.out.println(e);
				}
			}
			
			namedParameterJdbcTemplate.batchUpdate(sql,source);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
