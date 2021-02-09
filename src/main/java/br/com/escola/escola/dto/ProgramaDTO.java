package br.com.escola.escola.dto;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import java.time.LocalDate;

public class ProgramaDTO {

    private Long id;
    private String nome;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Boolean active;

    public ProgramaDTO() {

    }

    public ProgramaDTO(Long id, String nome, LocalDate dataInicio, LocalDate dataFim, Boolean active) {
        this.id = id;
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
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

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
