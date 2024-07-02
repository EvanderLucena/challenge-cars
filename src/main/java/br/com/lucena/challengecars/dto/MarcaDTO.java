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

    public static MarcaDTO fromMarca(Marca marca) {
        MarcaDTO dto = new MarcaDTO();
        dto.setId(marca.getId());
        dto.setNomeMarca(marca.getNomeMarca());
        return dto;
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
