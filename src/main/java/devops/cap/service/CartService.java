package devops.cap.service;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import devops.cap.db.CartDb;
import devops.cap.model.Cart;

public class CartService {
	CartDb cartDb;
	public CartService(){
		cartDb=new CartDb();
	}
	
	public boolean isAuthorized(Cart signup){
		boolean isValidUser=false;
		
		if(signup!=null && signup.getUserName()!=null && signup.getPassword()!=null){
			 Set entrySet = cartDb.cartItems.entrySet();
			 Iterator it = entrySet.iterator();
			 
			 while(it.hasNext()){
				 Map.Entry u = (Map.Entry)it.next();
				 if(u.getKey().equals(signup.getUserName()) && u.getKey().equals(signup.getPassword()))
				 {
					 isValidUser=true;
				 }

			 }	
		}
		
		
		return isValidUser;
	}

}
