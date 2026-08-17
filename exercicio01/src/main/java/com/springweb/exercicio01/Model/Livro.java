package com.springweb.exercicio01.Model;

public class Livro {
    private Integer id;
    private String titulo;
    private String Autor;

    public Livro(Integer id, String titulo, String autor) {
        this.id = id;
        this.titulo = titulo;
        Autor = autor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

}
