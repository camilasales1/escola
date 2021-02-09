package br.com.escola.escola.dto;



import br.com.escola.escola.model.Nota;
import br.com.escola.escola.model.Programa;

import java.util.List;

public class AlunoDTO {

    private Long id;
    private String nome;
    private String classe;
    private Boolean active;
    private Programa programa;
    private List<Nota> listaNotas;

    public AlunoDTO() {
    }

    public AlunoDTO(Long id, String nome, String classe, Boolean active, Programa programa, List<Nota> listaNotas) {
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

    public void setNome(String nome) {
        this.nome = nome;
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