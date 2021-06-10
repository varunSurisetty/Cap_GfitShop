package devops.cap.service;

import static org.junit.Assert.*;

import org.junit.Test;

import devops.cap.model.Cart;

public class CartServiceTest {

	@Test
	public void testIsAutherozied() {
		Cart u1=new Cart("meera","meera");
		assertEquals(true,new CartService().isAuthorized(u1));
	}

}
