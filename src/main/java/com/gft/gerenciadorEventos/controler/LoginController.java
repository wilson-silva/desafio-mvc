package com.gft.gerenciadorEventos.controler;

import com.gft.gerenciadorEventos.entities.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@GetMapping
	@RequestMapping
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login.html");
		return mv;
	}

}
