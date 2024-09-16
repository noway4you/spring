package tw.test.testS4.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;

import tw.test.testS4.model.Hotel;

@Component
public class HotelDaoImplement implements HotelDao{

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public Hotel add(Hotel hotel) {
		
		String sql = "insert into hotel (name,address,tel) values (:name,:address,:tel)";
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("name",hotel.getName());
		map.put("address",hotel.getAddress());
		map.put("tel",hotel.getTel());
		
		GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
		MapSqlParameterSource source = new MapSqlParameterSource(map);
		
		int num = namedParameterJdbcTemplate.update(sql,source,keyHolder);
		if(num>0) {
			long id = keyHolder.getKey().longValue();
			hotel.setId(id);
			return hotel;
		}
		
		return null;
	}

	@Override
	public Integer add(List<Hotel> hotels) {
		
		deleteAll();
		
		String sql = "insert into hotel (name,address,tel) values (:name,:address,:tel)";
		
		MapSqlParameterSource[] sources = new MapSqlParameterSource[hotels.size()];
		for(int i=0;i<hotels.size();i++) {
			Hotel hotel = hotels.get(i);
			sources[i] = new MapSqlParameterSource();
			sources[i].addValue("name",hotel.getName());
			sources[i].addValue("address",hotel.getAddress());
			sources[i].addValue("tel",hotel.getTel());
		}
		
		int[] nums = namedParameterJdbcTemplate.batchUpdate(sql,sources);
		int sum = 0;
		for(int n:nums) {
			sum+=n;
		}
		return Integer.valueOf(sum);
	}
	
	private void deleteAll() {
		
		String sql_delete = "delete from hotel";
		String sql_reset = "alter table hotel auto_increment = 1";
		
		Map<String,Object> map = new HashMap<String, Object>();
		namedParameterJdbcTemplate.update(sql_delete,map);
		namedParameterJdbcTemplate.update(sql_reset,map);
		
	}
	
	@Override
	public Hotel get(Long id) {
		
		String sql = "select id,name,address,tel from hotel where id = :id";
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("id",id);
		List<Hotel> list = namedParameterJdbcTemplate.query(sql,map,new HotelRowMapper());
		if(list.size()>0) return list.get(0);
		else return null;
	}

	@Override
	public List<Hotel> get(String key) {
		String sql = "select id,name,address,tel from hotel where name like :skey or address like :skey or tel like :skey";
		String skey = "%" + key + "%";
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("skey",skey);
		List<Hotel> list = namedParameterJdbcTemplate.query(sql,map,new HotelRowMapper());
		
		return list;
	}
}
