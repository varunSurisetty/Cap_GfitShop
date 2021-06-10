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

	@Test
	public void testIsnotAutherozied() {
		Cart u1=new Cart("meera","mee");
		assertEquals(true,new CartService().isAuthorized(u1));
	}

}
