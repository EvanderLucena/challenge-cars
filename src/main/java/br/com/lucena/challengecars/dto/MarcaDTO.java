package br.com.lucena.challengecars.dto;

import br.com.lucena.challengecars.entity.Marca;

public class MarcaDTO {
    private Long id;
    private String nomeMarca;

    // Construtor padrão
    public MarcaDTO() {
    }

    // Construtor com todos os campos
    public MarcaDTO(Long id, String nomeMarca) {
        this.id = id;
        this.nomeMarca = nomeMarca;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeMarca() {
        return nomeMarca;
    }

    public void setNomeMarca(String nomeMarca) {
        this.nomeMarca = nomeMarca;
    }

    // Método de conversão de entidade para DTO
    public static MarcaDTO fromMarca(Marca marca) {
        return new MarcaDTO(marca.getId(), marca.getNomeMarca());
    }

    // toString para facilitar o debug e log
    @Override
    public String toString() {
        return "MarcaDTO{" +
                "id=" + id +
                ", nomeMarca='" + nomeMarca + '\'' +
                '}';
    }
}
