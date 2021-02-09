package br.com.escola.escola.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "tb_mentoria")
public class Mentoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "mentor_id", nullable = false)
    private Professor professor;

    private Boolean active;

    public Mentoria() {
    }

    public Mentoria(long id, Aluno aluno, Professor professor, Boolean active) {
        this.id = id;
        this.aluno = aluno;
        this.professor = professor;
        this.active = active;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}