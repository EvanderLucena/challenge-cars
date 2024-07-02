package br.com.lucena.challengecars.dto;

import br.com.lucena.challengecars.entity.Marca;
import br.com.lucena.challengecars.entity.Modelo;

public class ModeloDTO {

    private Long id;
    private String nome;
    private Double valorFipe;
    private MarcaDTO marca;

    public ModeloDTO() {
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

    public Double getValorFipe() {
        return valorFipe;
    }

    public void setValorFipe(Double valorFipe) {
        this.valorFipe = valorFipe;
    }

    public MarcaDTO getMarca() {
        return marca;
    }

    public void setMarca(MarcaDTO marca) {
        this.marca = marca;
    }

    // Método estático de conversão
    public static ModeloDTO fromModelo(Modelo modelo) {
        ModeloDTO dto = new ModeloDTO();
        dto.setId(modelo.getId());
        dto.setNome(modelo.getNome());
        dto.setValorFipe(modelo.getValorFipe());
        if (modelo.getMarca() != null) {
            dto.setMarca(MarcaDTO.fromMarca(modelo.getMarca()));
        }
        return dto;
    }
}
