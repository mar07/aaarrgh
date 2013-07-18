package aaarrgh.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import aaarrgh.dto.MensajeDto;
import aaarrgh.model.Usuario;
import aaarrgh.services.LoginService;
import aaarrgh.services.MensajeService;
import aaarrgh.services.ServiceException;
import aaarrgh.services.UsuarioService;
import aaarrgh.util.WebSession;

@Controller
@RequestMapping("/login")
public class LoginController {

	LoginService loginService = new LoginService();
	UsuarioService usuarioService = new UsuarioService();
	MensajeService mensajeService = new MensajeService();

	@RequestMapping("/auth")
	public ModelAndView authenticate(
			@RequestParam("username") String username,
			@RequestParam("password") String password) {

		ModelAndView dispatch = null;
		
		try {
			if (loginService.authenticate(username, password)) {
				dispatch = new ModelAndView("welcome", "message", "Bienvenido, @" + username); 
				
				Usuario usuario = usuarioService.findByUsername(username);
				WebSession.getInstance().addObject("usuarioLogueado", usuario);
				
				List<MensajeDto> misMensajes =  mensajeService.findMensaje();
				dispatch.addObject("m", misMensajes);
			} else {
				dispatch = new ModelAndView("../../index", "message", "Ingreso incorrecto");
			}

			return dispatch;
		}
		catch (ServiceException ex) {
			dispatch = new ModelAndView("error", "message", ex.getMessage());
			return dispatch;
		}
	}

	@RequestMapping("/logout")
	public ModelAndView logout() {
		
		WebSession.getInstance().deleteObject("usuarioLogueado");
		
		ModelAndView dispatch = null;
		dispatch = new ModelAndView("../../index", "message", "Se ha deslogueado");
		return dispatch;
	}
}
