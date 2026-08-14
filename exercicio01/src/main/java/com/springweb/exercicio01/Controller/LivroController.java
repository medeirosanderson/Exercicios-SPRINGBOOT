package com.springweb.exercicio01.Controller;
import com.springweb.exercicio01.Model.Livro;
import com.springweb.exercicio01.Service.LivroService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class LivroController {
    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping("/meuslivros")
    public List<Livro> listaLivros(){
        return livroService.listaLivros();
    }

    @GetMapping("/quant")
    public int quantidadeLivros(){
        return livroService.quantidadeLivros();
    }

}
