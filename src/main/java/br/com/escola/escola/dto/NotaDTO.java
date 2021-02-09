package br.com.escola.escola.dto;

import br.com.escola.escola.model.Materia;
import java.time.LocalDate;

public class NotaDTO {

    private Long id;
    private Double nota;
    private LocalDate data;
    private Materia materia;

    public NotaDTO() {

    }

    public NotaDTO(Long id, Double nota, LocalDate data, Materia materia) {
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
