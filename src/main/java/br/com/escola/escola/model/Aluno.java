package br.com.escola.escola.model;

import com.sun.istack.NotNull;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String nome;

    @NotNull
    private String classe;

    @NotNull
    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "programa_id", nullable = false)
    private Programa programa;

    @OneToMany
    @JoinColumn(name = "nota_id")
    private List<Nota> listaNotas;

    public Aluno() {
    }

    public Aluno(Long id, String nome, String classe, Boolean active, Programa programa, List<Nota> listaNotas) {
        this.id = id;
        this.nome = nome;
        this.classe = classe;
        this.active = active;
        this.programa = programa;
        this.listaNotas = listaNotas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String name) {
        this.nome = name;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public List<Nota> getListaNotas() {
        return listaNotas;
    }

    public void setListaNotas(List<Nota> listaNotas) {
        this.listaNotas = listaNotas;
    }
}