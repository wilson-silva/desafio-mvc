package com.gft.gerenciadorEventos.controler;


import com.gft.gerenciadorEventos.entities.Evento;
import com.gft.gerenciadorEventos.services.CasaService;
import com.gft.gerenciadorEventos.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("evento")
public class EventoController {



    @Autowired
    private EventoService eventoService;

    @Autowired
    private CasaService casaService;

    //-----------------------------------------------------------------------
    @RequestMapping(path = "novo")
    public ModelAndView evento() {
        ModelAndView mv = new ModelAndView("evento/form.html");
        mv.addObject("evento", new Evento());
        mv.addObject("lista", eventoService.listarEvento());
        mv.addObject("listaCasa", casaService.listarCasaDeShow());
        return mv;
    }

    //-----------------------------------------------------------------------
    @RequestMapping(method = RequestMethod.POST, path = "novo")
    public ModelAndView salvarEvento(@Valid Evento evento, BindingResult result,
                                     RedirectAttributes attributes) {

        ModelAndView mv = new ModelAndView("evento/form.html");

        if (result.hasErrors()) {
            mv.addObject("evento", evento);
            return mv;
        }
        eventoService.salvarEvento(evento);
        if (evento.getId() == null) {
            mv.addObject("evento", new Evento());
        } else {
            mv.addObject("evento", evento);
        }

        mv.addObject("mensagem", "Evento salvo com sucesso");
        mv.addObject("lista", eventoService.listarEvento());
        mv.addObject("listaCasa", casaService.listarCasaDeShow());
        return mv;
    }

    //-----------------------------------------------------------------------
    @RequestMapping
    public ModelAndView listarEvento() {
        ModelAndView mv = new ModelAndView("evento");
        mv.addObject("lista", eventoService.listarEvento());
        mv.addObject("listaCasa", casaService.listarCasaDeShow());
        return mv;
    }

    //-----------------------------------------------------------------------
    @RequestMapping("/editar")
    public ModelAndView editarEvento(@RequestParam Long id) {
        ModelAndView mv = new ModelAndView("evento/form.html");
        Evento evento;

        try {
            evento = eventoService.obterEvento(id);
        } catch (Exception e) {
            evento = new Evento();
            mv.addObject("mensagem", e.getMessage());
        }

        mv.addObject("evento", evento);
        mv.addObject("lista", eventoService.listarEvento());
        mv.addObject("listaCasa", casaService.listarCasaDeShow());
        return mv;
    }

    //-----------------------------------------------------------------------
    @RequestMapping("/excluir")
    public ModelAndView excluirEvento(@RequestParam Long id, RedirectAttributes attributes) {

        ModelAndView mv = new ModelAndView("redirect:/evento/novo");

        try {
            eventoService.excluirEvento(id);
            attributes.addFlashAttribute("mensagem", "Evento excluido com sucesso!");
        } catch (Exception e) {
            attributes.addFlashAttribute("mensagem", "Erro ao excluir Evento " + e.getMessage());
        }

        return mv;
    }

}
