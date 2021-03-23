package br.com.tt.petshop.web;

import br.com.tt.petshop.service.WelcomeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Controller
public class WelcomeController {

    private  final WelcomeService welcomeService;

    public WelcomeController(WelcomeService welcomeService){
        this.welcomeService = welcomeService;
    }


    @GetMapping("/")
    public String ola(Model model) {

        String versao = welcomeService.obtemVersao();
        model.addAttribute("versao", versao);

        List<String> notas = Arrays.asList(
                "Criado COntroller Welcome",
                "Criando página inicial",
                "Usado o Thymeleaf"
        );
        model.addAttribute("notas", notas);


        return "welcome-page";
    }
}
