package com.springweb.exercicio01.Controller;
import com.springweb.exercicio01.Exception.LivroNaoEncontradoException;
import com.springweb.exercicio01.Model.Livro;
import com.springweb.exercicio01.Service.LivroService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/livros")
public class LivroController {
    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public List<Livro> listaLivros(){
        return livroService.listaLivros();
    }

    @GetMapping("/quantidade")
    public int quantidadeLivros(){
        return livroService.quantidadeLivros();
    }

    @GetMapping("/buscar")
    public List<Livro> buscaLivros(@RequestParam String titulo){
        return livroService.buscarNomeLivro(titulo);
    }

    @GetMapping("/{id}")
    public Livro buscarLivroId(@PathVariable Integer id){
        return livroService.buscarPorId(id);
    }

    @ExceptionHandler(LivroNaoEncontradoException.class)
    public ResponseEntity<?> tratarLivroNaoEncontrado(LivroNaoEncontradoException exception){
        Map<String, Object> resposta = new HashMap<>();
        resposta.put("error", exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resposta);
    }

}
