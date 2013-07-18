package aaarrgh.persistence;

public class DaoFactory {

	public static PersonaDao getPersonaDao(){
		return PersonaDaoJdbcImpl.getInstance();
	}
	
	public static UsuarioDao getUsuarioDao() {
		return UsuarioDaoJdbcImpl.getInstance();
	}
	
	public static MensajeDao getMensajeDao() {
		return MensajeDaoJdbcImpl.getInstance();
	}
	
}
