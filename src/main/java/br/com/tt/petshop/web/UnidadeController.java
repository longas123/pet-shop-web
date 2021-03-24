package br.com.tt.petshop.web;

import br.com.tt.petshop.model.Unidade;
import br.com.tt.petshop.service.UnidadeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;
import java.util.jar.Attributes;

@Controller
public class UnidadeController {

    private UnidadeService unidadeService;

    public UnidadeController(UnidadeService unidadeService){
        this.unidadeService = unidadeService;
    }

    //carregar a tela
    @GetMapping("/admin/unidades")
    public String listar(Model model){

        Unidade unidade = new Unidade(1L, "Cantinho do Pet", "Borges de Medeiros, 34");
        //model.addAttribute("unidades", Arrays.asList(unidade));
        List<Unidade> unidades = unidadeService.listar();
        model.addAttribute("unidades", unidades);

        return "unidades-page";
    }

    private final static Logger LOG = LoggerFactory.getLogger(UnidadeController.class);

    @PostMapping("/actions/criar-unidade")
    public String criar(Unidade unidadeCriacao, RedirectAttributes attributes){
        try{
            unidadeService.criar(unidadeCriacao);
            attributes.addFlashAttribute("mensagem", "Unidade Criada com Sucesso");
        }catch (Exception e){
            LOG.error("Ocorreu um erro", e);
            String erro = String.format("Ocorreu um erro %s", e.getMessage());
            attributes.addFlashAttribute("erro", erro);
        }

        //O Spring disse que quando queremos redirecionar, use assim.
        //Ele vai mandar o browser ir para /admin/unidades
        return "redirect:/admin/unidades";
    }



    @PostMapping("/actions/editar-unidade")
    public String editar(Unidade unidadeEdicao, RedirectAttributes attributes){
        ;

        try{
            unidadeService.editar(unidadeEdicao);
            attributes.addFlashAttribute("mensagem", "Unidade Atualizada com Sucesso");
        }catch (Exception e){
            LOG.error("Ocorreu um erro", e);
            String erro = String.format("Ocorreu um erro %s", e.getMessage());
            attributes.addFlashAttribute("erro", erro);
        }


        return  "redirect:/admin/unidades";
    }

    @PostMapping("/actions/deletar-unidade")
    public String deletar(Unidade deletarEdicao){
        unidadeService.deletar(deletarEdicao);
        return  "redirect:/admin/unidades";
    }
}
