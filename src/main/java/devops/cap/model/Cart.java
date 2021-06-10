package devops.cap.model;

public class Cart {
	
	String userName;
	String password;
	
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	
	
	
	public Cart(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
}
