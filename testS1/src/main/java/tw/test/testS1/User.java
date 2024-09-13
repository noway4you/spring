package tw.test.testS1;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/*
 * {
 *  "id":1,
 *  "name":"AAA"
 * }
 */
public class User {
	
	@NotNull
	private Long id;
	
	@Size(max = 3,min = 2)
	private String name;
	
	@Email
	private String email;
	
	@Pattern(regexp = "^[A-Z][12][0-9]{8}$")
	private String twid;
	
	@NotBlank
	private String account;
	
	@NotEmpty
	private List<String> course;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTwid() {
		return twid;
	}
	public void setTwid(String twid) {
		this.twid = twid;
	}
}
