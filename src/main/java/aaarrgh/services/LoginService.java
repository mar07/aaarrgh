package aaarrgh.services;

import aaarrgh.persistence.DaoFactory;
import aaarrgh.persistence.PersistenceException;

public class LoginService {

	public Boolean authenticate(String username, String password) throws ServiceException {
		try {
			return DaoFactory.getUsuarioDao().existsUsuario(username, password);
		} catch (PersistenceException ex) {
			throw new ServiceException(ex);
		}
	}
	
}
