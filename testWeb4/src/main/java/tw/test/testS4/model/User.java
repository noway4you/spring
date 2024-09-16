package tw.test.testS4.model;

public class User {

	private Long id;
	private String account;
	private String password;
	private String name;
	
	private byte[] icon; 
	private String iconBase64;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte[] getIcon() {
		return icon;
	}
	public void setIcon(byte[] icon) {
		this.icon = icon;
	}
	public String getIconBase64() {
		return iconBase64;
	}
	public void setIconBase64(String iconBase642) {
		this.iconBase64 = iconBase642;
	}
}