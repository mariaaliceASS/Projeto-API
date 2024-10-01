
package com.senac.filmeWeb.model;


public class Filme {
    private Long id;
    private String titulo;
    private String sinopse;
    private String genero;
    private Integer anolancamento;

    public Filme() {
        
    }

    public Filme(Long id, String titulo, String sinopse, String genero, Integer anolancamento) {
        this.id = id;
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.genero = genero;
        this.anolancamento = anolancamento;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getAnolancamento() {
        return anolancamento;
    }

    public void setAnolancamento(Integer anolancamento) {
        this.anolancamento = anolancamento;
    }
    
}
