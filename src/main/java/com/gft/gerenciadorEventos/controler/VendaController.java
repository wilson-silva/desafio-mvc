package com.gft.gerenciadorEventos.controler;


import com.gft.gerenciadorEventos.entities.Compra;
import com.gft.gerenciadorEventos.entities.Evento;
import com.gft.gerenciadorEventos.entities.ItensCompra;
import com.gft.gerenciadorEventos.entities.Usuario;
import com.gft.gerenciadorEventos.repositoy.ItensCompraRepository;
import com.gft.gerenciadorEventos.services.EventoService;
import com.gft.gerenciadorEventos.services.ItensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Long.sum;

@Controller
public class VendaController {

    @Autowired
    private EventoService eventoService;

    @Autowired
    private ItensService itensService;


    private List<ItensCompra> itens = new ArrayList<ItensCompra>();



    //--------------------------------------------------------------------------------------
    private Compra compra = new Compra();
    private void calculatTotal(){
        compra.setValorTotal(BigDecimal.valueOf(0));
        for(ItensCompra it : itens){
            compra.setValorTotal(compra.getValorTotal().add(it.getValorTotal()));
        }
    }

    //--------------------------------------------------------------------------------------
    @RequestMapping("/venda")
    public ModelAndView venda(Evento evento){
        ModelAndView mv = new ModelAndView("cliente/venda.html");
        calculatTotal();
        mv.addObject("compra", compra);
        mv.addObject("listaItens", itens);
        mv.addObject("evento", evento);
        return mv;
    }

    //--------------------------------------------------------------------------------------
    @RequestMapping("/historico")
    public ModelAndView historicoCompra(){
        ModelAndView mv = new ModelAndView("cliente/historico.html");
        calculatTotal();
        mv.addObject("compra", compra);
        mv.addObject("listaItens", itens);
        return mv;
    }
    //--------------------------------------------------------------------------------------
    @RequestMapping("/finalizar")
    public ModelAndView finalizarCompra(){
        ModelAndView mv = new ModelAndView("cliente/finalizar.html");
        calculatTotal();
        mv.addObject("compra", compra);
        mv.addObject("listaItens", itens);
        return mv;
    }


    //--------------------------------------------------------------------------------------
    @RequestMapping("/confirmar")
    public ModelAndView ConfirmarCompra(){
        ModelAndView mv = new ModelAndView("cliente/finalizar.html");
        calculatTotal();
        mv.addObject("mensagem", "Compra confirmada com sucesso");
        mv.addObject("compra", compra);
        mv.addObject("listaItens", itens);
        return mv;
    }

    //--------------------------------------------------------------------------------------
    @RequestMapping("/alterarQuantidade/{id}/{acao}")
    public String alterarQuantidade(@PathVariable Long id, @PathVariable Integer acao) throws Exception {
        Evento evento = eventoService.obterEvento(id);

            for(ItensCompra it : itens){
                if(it.getEvento().getId().equals(id)){
                        if(acao.equals(1)){
                            it.setQuantidade(it.getQuantidade() + 1);
                            it.setValorTotal(BigDecimal.valueOf(0));
                            BigDecimal quantidade = BigDecimal.valueOf(it.getQuantidade());
                            it.setValorTotal(it.getValorTotal().add(quantidade.multiply(it.getValorUnitario())));

                            evento.setCapacidade(evento.getCapacidade() - 1);
                            eventoService.salvarEvento(evento);


                        }else if(acao.equals(0)){
                            if(it.getQuantidade() > 0){
                                it.setQuantidade(it.getQuantidade() - 1);
                            }else if(it.getQuantidade() <= 0){
                                break;
                            }
                            evento.setCapacidade(evento.getCapacidade() + 1);
                            eventoService.salvarEvento(evento);

                            it.setValorTotal(BigDecimal.valueOf(0));
                            BigDecimal quantidade = BigDecimal.valueOf(it.getQuantidade());
                            it.setValorTotal(it.getValorTotal().add(quantidade.multiply(it.getValorUnitario())));


                        }
                    break;
                }
            }
        return "redirect:/venda";
    }

    //--------------------------------------------------------------------------------------
    @RequestMapping("/removerVenda/{id}")
    public String removerVenda(@PathVariable Long id) throws Exception {
        Evento evento = eventoService.obterEvento(id);

        for (ItensCompra it : itens) {
            if (it.getEvento().getId().equals(id)) {
                System.out.println(it.getQuantidade());
                evento.setCapacidade(evento.getCapacidade()+it.getQuantidade());
                eventoService.salvarEvento(evento);
                itens.remove(it);
                break;
            }
        }
        return "redirect:/venda";
    }


    //--------------------------------------------------------------------------------------
    @RequestMapping("/adicionarVenda/{id}")
    public String adicionarVenda(@PathVariable Long id) throws Exception {

            Evento evento = eventoService.obterEvento(id);

            int controle = 0;
            for(ItensCompra it : itens){
                if(it.getEvento().getId().equals(evento.getId())){
                    it.setQuantidade(it.getQuantidade() + 1);
                    it.setValorTotal(BigDecimal.valueOf(0));
                    BigDecimal quantidade = BigDecimal.valueOf(it.getQuantidade());
                    it.setValorTotal(it.getValorTotal().add(quantidade.multiply(it.getValorUnitario())));

                    evento.setCapacidade(evento.getCapacidade() - 1);
                    eventoService.salvarEvento(evento);


                    controle = 1;
                    break;
                }
            }
            if(controle == 0){
                ItensCompra item = new ItensCompra();
                itensService.salvarItem(item);
                System.out.println(item.getId());
                item.setEvento(evento);
                item.setValorUnitario(evento.getValorIngresso());
                item.setQuantidade(item.getQuantidade() + 1);

                evento.setCapacidade(evento.getCapacidade() - 1);
                eventoService.salvarEvento(evento);

                BigDecimal quantidade = BigDecimal.valueOf(item.getQuantidade());
                item.setValorTotal(item.getValorTotal().add(quantidade.multiply(item.getValorUnitario())));
                itens.add(item);



            }



        return "redirect:/venda";

    }


}
