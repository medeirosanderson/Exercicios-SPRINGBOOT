package com.springweb.exercicio01.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.springweb.exercicio01.Exception.LivroNaoEncontradoException;
import com.springweb.exercicio01.Model.Livro;



@Service
public class LivroService {
    private List<Livro> meusLivros = new ArrayList<>();

    public List<Livro> listaLivros(){
        meusLivros.add(new Livro(1, "Dom Casmurro", "Machado de Assis"));
        meusLivros.add(new Livro(2, "O Hobbit", "J.R.R Tolkien"));
        meusLivros.add(new Livro(3, "1984", "George Orwell"));
        meusLivros.add(new Livro(4, "O Pequeno Principe", "Antonie de Saint-Exupéry"));
        meusLivros.add(new Livro(5, "A Hora da Estrela", "Clarisse Lispector"));
        meusLivros.add(new Livro(6, "Orgulho e preconceito", "Jane Austen"));
        meusLivros.add(new Livro(7, "O Sol é pra todos", "Harper Lee"));
        meusLivros.add(new Livro(8, "Fahrenheit 451", "Ray Bradbury"));
        meusLivros.add(new Livro(9, "Capitães da Areia", "Jorge Amado"));
        meusLivros.add(new Livro(10, "Frankenstein", "Mary Shelley"));
        return meusLivros;
    }

    public int quantidadeLivros(){
        return meusLivros.size();
    }

    public List<Livro> buscarNomeLivro(String titulo){
        List<Livro> buscarLivro = meusLivros.stream()
        .filter(livro -> livro.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
        .collect(Collectors.toList());

        return buscarLivro;
    }

    public Livro buscarPorId(Integer id) {
        Optional<Livro> buscarId = meusLivros.stream()
        .filter(livro -> livro.getId() == id)
        .findFirst();

        return buscarId.orElseThrow(() -> new LivroNaoEncontradoException("Não existe nenhum Livro com esse ID inserido! (ID: " + id + ")"));
    }

    }


