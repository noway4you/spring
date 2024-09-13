package tw.test.testS1;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class S06 {
	
	@RequestMapping("/S06")
	public Member S06() {
		Member member = new Member();
		member.setAccount("spring");
		member.setPassword("123");
		member.setName("spring123");
		
		MemberDao dao = new MemberDao();
		dao.addMember(member);
		
		return member;
	}
	
	
}