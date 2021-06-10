package devops.cap.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import devops.cap.model.Cart;

public class CartDb {
	
	private static String[][] users;
	private static List<Cart>  cartData;
	
	public static Map<String, Cart> cartItems=new HashMap<String,Cart>();
	
	public CartDb(){
		
		Cart c1=new Cart("meera","meera");
		Cart c2=new Cart("vidhya","vidhya");
		Cart c3=new Cart("varun","varun");
	
		
		cartItems.put(c1.getUserName(), c1);
		cartItems.put(c2.getUserName(), c2);
		cartItems.put(c3.getUserName(), c3);
		
	}
	


}
