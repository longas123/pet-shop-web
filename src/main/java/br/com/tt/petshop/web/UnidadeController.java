package br.com.tt.petshop.web;

import br.com.tt.petshop.model.Unidade;
import br.com.tt.petshop.service.UnidadeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

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
}
