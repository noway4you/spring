package tw.test.testS4.dao;

import java.util.List;

import tw.test.testS4.model.Hotel;

public interface HotelDao {
	
	public Hotel add(Hotel hotel);
	public Integer add(List<Hotel> hotels);
	public Hotel get(Long id);
	public List<Hotel> get(String key);
	
}
