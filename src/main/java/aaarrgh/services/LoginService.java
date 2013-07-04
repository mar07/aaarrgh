package aaarrgh.services;

public class LoginService {

	public Boolean authenticate(String username, String password) {
		return username.equals(password);
	}
	
}
