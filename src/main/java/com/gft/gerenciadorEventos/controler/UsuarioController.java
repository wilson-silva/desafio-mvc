package com.gft.gerenciadorEventos.controler;



import com.gft.gerenciadorEventos.entities.Usuario;
import com.gft.gerenciadorEventos.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    //-----------------------------------------------------------------------
    @RequestMapping(path = "novo")
    public ModelAndView usuario() {
        ModelAndView mv = new ModelAndView("cliente/cadastrar.html");
        mv.addObject("usuario", new Usuario());
        mv.addObject("listaUsuario", usuarioService.listarUsuario());
        return mv;
    }

    //-----------------------------------------------------------------------
    @RequestMapping(method = RequestMethod.POST, path = "novo")
    public ModelAndView salvarUsuario(@Valid Usuario usuario, BindingResult result,
                                     RedirectAttributes attributes) {

        ModelAndView mv = new ModelAndView("cliente/cadastrar.html");


        if (result.hasErrors()) {
            mv.addObject("usuario", usuario);
            return mv;
        }

        usuarioService.salvarUsuario(usuario);

        if (usuario.getId() == null) {
            mv.addObject("usuario", new Usuario());
        } else {
            mv.addObject("usuario", usuario);
        }

        mv.addObject("mensagem", "Usuario salvo com sucesso");
        mv.addObject("listaUsuario", usuarioService.listarUsuario());
        return mv;
    }

    //-----------------------------------------------------------------------
    @RequestMapping
    public ModelAndView listarUsuario() {
        ModelAndView mv = new ModelAndView("cliente");
        mv.addObject("listaUsuario", usuarioService.listarUsuario());
        return mv;
    }

    //-----------------------------------------------------------------------
    @RequestMapping("/editar")
    public ModelAndView editarUsuario(@RequestParam Long id) {
        ModelAndView mv = new ModelAndView("cliente/cadastrar.html");
        Usuario usuario;

        try {
            usuario = usuarioService.obterUsuario(id);
        } catch (Exception e) {
            usuario = new Usuario();
            mv.addObject("mensagem", e.getMessage());
        }

        mv.addObject("usuario", usuario);
        mv.addObject("listaUsuario", usuarioService.listarUsuario());
        return mv;
    }

    //-----------------------------------------------------------------------
    @RequestMapping("/excluir")
    public ModelAndView excluirUsuario(@RequestParam Long id, RedirectAttributes attributes) {

        ModelAndView mv = new ModelAndView("redirect:/cliente/novo");

        try {
            usuarioService.excluirUsuario(id);
            attributes.addFlashAttribute("mensagem", "Usuario excluido com sucesso!");
        } catch (Exception e) {
            attributes.addFlashAttribute("mensagem", "Erro ao excluir Usuario " + e.getMessage());
        }

        return mv;
    }

}
