package br.com.escola.escola.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_nota_aluno")
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Double nota;

    @NotNull
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "materia_id")
    private Materia materia;

    public Nota() {
    }

    public Nota(Long id, Double nota, LocalDate data, Materia materia) {
        this.id = id;
        this.nota = nota;
        this.data = data;
        this.materia = materia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }


}