package devops.cap.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import devops.cap.model.User;

public class UserDb {
	
	public static String[][] users;
	public static List<User>  usersData;
	
	public static Map<String, User> userProfile=new HashMap<String,User>();
	
	public UserDb(){
		
		User u1=new User("surisetty","varun","cicd","s.v@devops.com");
		User u2=new User("vidhya","sainath","cicd","v.s@devops.com");
		User u3=new User("meera","kumari","cicd","m.k@devops.com");
	
		
		userProfile.put(u1.getEmail(), u1);
		userProfile.put(u2.getEmail(), u2);
		userProfile.put(u3.getEmail(), u3);
		
	}
	


}
