package aaarrgh.services;

import org.junit.Assert;
import org.junit.Test;

public class LoginServiceTests {

	LoginService service = new LoginService();

	@Test
	public void testThatAuthenticates() throws ServiceException {
		String username = "jack";
		String password = "jack";
		Assert.assertTrue("username equals password must authenticate",
				service.authenticate(username, password));
	}
	
	@Test
	public void testThatRefusesAuthentication() throws ServiceException {
		String username = "jack";
		String password = "sparrow";
		Assert.assertFalse("username not equals password must refuse authentication",
				service.authenticate(username, password));
	}
	
}
