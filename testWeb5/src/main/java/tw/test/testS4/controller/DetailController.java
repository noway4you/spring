package tw.test.testS4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.test.testS4.Model.Detail;
import tw.test.testS4.Repository.DetailRepository;

@RequestMapping("/detail")
@RestController
public class DetailController {

	@Autowired
	private DetailRepository detailRepository;
	
	@RequestMapping("/get/{id}")
	public Detail getDetail(@PathVariable Long id) {
		Detail detail = detailRepository.findById(id).orElse(null);
		return detail;
	}
	
}
