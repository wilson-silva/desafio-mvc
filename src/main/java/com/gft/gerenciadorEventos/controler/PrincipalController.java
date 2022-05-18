package com.gft.gerenciadorEventos.controler;



import com.gft.gerenciadorEventos.entities.Casa;
import com.gft.gerenciadorEventos.services.CasaService;
import com.gft.gerenciadorEventos.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping
public class PrincipalController {

	@Autowired
	private EventoService eventoService;

	@Autowired
	private CasaService casaService;


	@RequestMapping("/home")
	public ModelAndView index() {

		Authentication autenticado = SecurityContextHolder.getContext().getAuthentication();
		if(!(autenticado instanceof AnonymousAuthenticationToken)){
			String username = autenticado.getName();
			System.out.println(username);
		}


		ModelAndView mv = new ModelAndView("home.html");
		mv.addObject("lista", eventoService.listarEvento());
		mv.addObject("listaCasa", casaService.listarCasaDeShow ());
		return mv;

	}
	
	

}
