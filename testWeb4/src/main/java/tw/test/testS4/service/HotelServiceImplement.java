package tw.test.testS4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import tw.test.testS4.dao.HotelDao;
import tw.test.testS4.model.Hotel;

@Component
public class HotelServiceImplement implements HotelService{
	
	@Autowired
	private HotelDao hotelDao;
	
	@Override
	public void addHotelsFromUrl(String url) {
		
		RestTemplate restTemplate = new RestTemplate();
		String content = restTemplate.getForObject(url,String.class);
		
		String json = content.replace("\"Name\":","\"name\":").replace("\"Address\":","\"address\":").replace("\"Tel\":","\"tel\":");

		ObjectMapper mapper = new ObjectMapper();
		try {
			List<Hotel> list = mapper.readValue(json,new TypeReference<List<Hotel>>() {});
			hotelDao.add(list);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public Hotel addHotel(Hotel hotel) {
		return hotelDao.add(hotel);
	}

	@Override
	public Hotel getHotel(Long id) {
		return hotelDao.get(id);
	}

	@Override
	public List<Hotel> getHotel(String key) {
		return hotelDao.get(key);
	}
}
