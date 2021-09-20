package br.com.freddofrio.telacadastro.controllers;

import br.com.freddofrio.telacadastro.entity.Usuario;
import br.com.freddofrio.telacadastro.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/*
* Controller Usuario
* */

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Redirecionar todoas as requisiçoes "/" para "/cadastro"
    @RequestMapping(name = "/", method = RequestMethod.GET)
    public String home2() {
        return "redirect:/cadastro";
    }

    // Método para cria a url "/cadastro". retorna a pagina html que sera usada
    @GetMapping("/cadastro")
    public String home(Usuario usuario){
        return "Home";
    }

    /*Método esta salvando no banco de dados*/
    @PostMapping("/cadastro")
    public String salvar(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, RedirectAttributes attr){

        // Verificar se o objeto tem algum erro com a validação
        if (result.hasErrors()) {
            return "Home";
        }
        // Testar se as senha são iguais
        if (!usuario.getSenha().equals(usuario.getReSenha())){
            attr.addFlashAttribute("errorSenha", "Erro senhas não confere");
            return "redirect:/cadastro";
        }

        usuarioService.save(usuario);
        return "redirect:/";
    }






}
