package org.example;

public class Livro {

    private String autor;
    private String titulo;
    private String genero;
    private int exemplares;



    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getExemplares() {
        return exemplares;
    }

    public void setExemplares(int exemplares) {
        this.exemplares = exemplares;
    }

    @Override
    public String toString() {
        return "Livro: " +
                ", nome='" + titulo + '\'' +
                "autor='" + autor + '\'' +
                ", genero='" + genero + '\'' +
                ", exemplares=" + exemplares ;
    }
}

