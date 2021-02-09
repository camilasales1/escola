package br.com.escola.escola.dto;

import br.com.escola.escola.model.Aluno;
import br.com.escola.escola.model.Professor;
import javax.persistence.*;

public class MentoriaDTO {

    private Long id;
    private Aluno aluno;
    private Professor professor;
    private Boolean active;

    public MentoriaDTO() {

    }

    public MentoriaDTO(Long id, Aluno aluno, Professor professor, Boolean active) {
        this.id = id;
        this.aluno = aluno;
        this.professor = professor;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
