package tw.test.testS4.Model;

public class MyTestResponse {

	private Integer code;
	private String message;
	private MyTest myTest;
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public MyTest getMyTest() {
		return myTest;
	}
	public void setMyTest(MyTest myTest) {
		this.myTest = myTest;
	}
}
