package br.com.escola.escola.model;


import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "tb_materia")
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String nome;

    private Boolean active;

    public Materia() {
    }

    public Materia(Long id, String nome, Boolean active) {
        this.id = id;
        this.nome = nome;
        this.active = active;
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}