package tw.test.testS1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class MyConf2 {
	
	@Autowired
	private ResourceLoader resourceLoader;
	
	@Bean("mySetting")
	public MySetting getMySetting() {
		
		try {
			Resource resource = resourceLoader.getResource("classpath:mysetting.json");
			BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
			String line;
			StringBuffer buffer = new StringBuffer();
			while((line = reader.readLine())!= null) {
				buffer.append(line);
			}
			reader.close();
			
//			JSONObject root = new JSONObject(buffer.toString());
//			MySetting mySetting = new MySetting();
//			mySetting.setTitle(root.getString("title"));
			
			ObjectMapper objectMapper = new ObjectMapper();
			MySetting mySetting = objectMapper.readValue(buffer.toString(),MySetting.class);
			System.out.println(mySetting.getTitle());
			
			return mySetting;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
}
