package br.com.escola.escola.dto;

public class MateriaDTO {

    private Long id;
    private String nome;
    private Boolean active;

    public MateriaDTO() {

    }

    public MateriaDTO(Long id, String nome, Boolean active) {
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
