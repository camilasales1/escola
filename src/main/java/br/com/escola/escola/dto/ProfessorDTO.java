package br.com.escola.escola.dto;


public class ProfessorDTO {

    private Long id;
    private String nome;
    private String pais;
    private Boolean active;

    public ProfessorDTO() {

    }

    public ProfessorDTO(Long id, String nome, String pais, Boolean active) {
        this.id = id;
        this.nome = nome;
        this.pais = pais;
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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
