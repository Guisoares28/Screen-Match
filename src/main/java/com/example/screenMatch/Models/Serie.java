package com.example.screenMatch.Models;

import com.example.screenMatch.Service.Tradutor.ConsumoTradutor;
import jakarta.persistence.*;

import java.util.OptionalDouble;

@Entity
@Table(name = "series")
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String titulo;

    private Integer totalTemporadas;

    private Double avaliacao;
    @Enumerated(EnumType.STRING)
    private Genero genero;

    private String atores;

    private String poster;

    private String sinopse;

    public Serie() {

    }

    public Serie(DadosSerie dadosSerie) {
        this.titulo = dadosSerie.titulo();
        this.totalTemporadas = dadosSerie.totalTemporadas();
        this.avaliacao = OptionalDouble.of(Double.valueOf(dadosSerie.avaliacao())).orElse(0.0);
        this.genero = Genero.fromString(dadosSerie.genero().split(",")[0].trim());
        this.atores = dadosSerie.atores();
        this.poster = dadosSerie.poster();
        ConsumoTradutor consumoTradutor = new ConsumoTradutor();
        this.sinopse = consumoTradutor.consumoTradutor(dadosSerie.sinopse().trim());
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

    public Integer getTotalTemporadas() {
        return totalTemporadas;
    }

    public void setTotalTemporadas(Integer totalTemporadas) {
        this.totalTemporadas = totalTemporadas;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getAtores() {
        return atores;
    }

    public void setAtores(String atores) {
        this.atores = atores;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    @Override
    public String toString() {
        return "Serie:" +
                "\ntitulo: " + titulo +
                "\ntotalTemporadas: " + totalTemporadas +
                "\navaliacao: " + avaliacao +
                "\ngenero: " + genero +
                "\natores: " + atores +
                "\nposter: " + poster +
                "\nsinopse: " + sinopse +
                "\n******************************************************";
    }
}