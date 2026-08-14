package com.springweb.exercicio01.Service;
import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import com.springweb.exercicio01.Model.Livro;



@Service
public class LivroService {
    private List<Livro> meusLivros = new ArrayList<>();

    public List<Livro> listaLivros(){
        meusLivros.add(new Livro("O Senhor dos Aneis"));
        meusLivros.add(new Livro("Harry Potter e a Pedra Filosofal"));
        meusLivros.add(new Livro("Harry Potter e o Prisioneiro de Askaban"));
        meusLivros.add(new Livro("Java e SpringBoot"));

        return meusLivros;
    }

    public int quantidadeLivros(){
        return meusLivros.size();
    }


    }


