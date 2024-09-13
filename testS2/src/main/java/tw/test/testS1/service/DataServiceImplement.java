package tw.test.testS1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import tw.test.testS1.dao.DataDao;
import tw.test.testS1.model.Data;

@Component
public class DataServiceImplement implements DataService{

	@Autowired
	private DataDao dataDao;

	@Override
	public Data addData(String url) {
		RestTemplate restTemplate = new RestTemplate();
		
//		String url = "https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvTravelStay.aspx";
		String content = restTemplate.getForObject(url,String.class);
		
		dataDao.add(content);
		return null;
	}
	
	
}
