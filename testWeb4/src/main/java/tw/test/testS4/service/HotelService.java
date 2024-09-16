package tw.test.testS4.service;

import java.util.List;

import tw.test.testS4.model.Hotel;

public interface HotelService {
	
	public void addHotelsFromUrl(String url);
	public Hotel addHotel(Hotel hotel);
	public Hotel getHotel(Long id);
	public List<Hotel> getHotel(String key);
	
}
