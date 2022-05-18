package com.gft.gerenciadorEventos.controler;

import javax.validation.Valid;

import com.gft.gerenciadorEventos.entities.Casa;
import com.gft.gerenciadorEventos.services.CasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("casa")
public class CasaController {

    @Autowired
    private CasaService casaDeShowService;


    //-----------------------------------------------------------------------
    @RequestMapping(path = "novo")
    public ModelAndView Casa() {
        ModelAndView mv = new ModelAndView("casa/form.html");
        mv.addObject("casa", new Casa());
        mv.addObject("lista", casaDeShowService.listarCasaDeShow());
        return mv;
    }

    //-----------------------------------------------------------------------
    @RequestMapping(method = RequestMethod.POST, path = "novo")
    public ModelAndView salvarCasa(@Valid Casa casa, BindingResult result, RedirectAttributes attributes) {
        ModelAndView mv = new ModelAndView("casa/form.html");


        if (result.hasErrors()) {
            mv.addObject("casa", casa);
            return mv;
        }

        casaDeShowService.salvarCasaDeShow(casa);

        if (casa.getId() == null) {
            mv.addObject("casa", new Casa());
        } else {
            mv.addObject("casa", casa);
        }

        mv.addObject("mensagem", "Casa de show salva com sucesso");
        mv.addObject("lista", casaDeShowService.listarCasaDeShow());
        return mv;

    }

    //-----------------------------------------------------------------------
    @RequestMapping
    public ModelAndView listarCasa() {
        //ModelAndView mv = new ModelAndView("casa/listar.html");
        ModelAndView mv = new ModelAndView("casa");
        mv.addObject("lista", casaDeShowService.listarCasaDeShow());
        return mv;
    }

    //-----------------------------------------------------------------------
    @RequestMapping("/editar")
    public ModelAndView editarCasa(@RequestParam Long id) {

        ModelAndView mv = new ModelAndView("casa/form.html");

        Casa casa;

        try {
            casa = casaDeShowService.obterCasaDeShow(id);
        } catch (Exception e) {
            casa = new Casa();
            mv.addObject("mensagem", e.getMessage());
        }

        mv.addObject("casa", casa);
        mv.addObject("lista", casaDeShowService.listarCasaDeShow());
        return mv;
    }

    //-----------------------------------------------------------------------
	@RequestMapping("/excluir")
	public ModelAndView excluirCasa(@RequestParam Long id, RedirectAttributes attributes) {
		
		ModelAndView mv = new ModelAndView("redirect:/casa/novo");
		
		
		try {
			casaDeShowService.excluirCasaDeShow(id);
			attributes.addFlashAttribute("mensagem", "Casa de show excluida com sucesso!");
		} catch (Exception e) {
			attributes.addFlashAttribute("mensagem", "Erro ao excluir casa de show " + e.getMessage());
		}
		
		return mv;
	}

}
