package br.com.lucena.challengecars.dto;

public abstract class CarroAbstractRequestDTO {

    private Long modeloId;
    private int ano;
    private String combustivel;
    private int numPortas;
    private String cor;

    public CarroAbstractRequestDTO(Long modeloId, int ano, String combustivel, int numPortas, String cor) {
        this.modeloId = modeloId;
        this.ano = ano;
        this.combustivel = combustivel;
        this.numPortas = numPortas;
        this.cor = cor;
    }

    public Long getModeloId() {
        return modeloId;
    }

    public void setModeloId(Long modeloId) {
        this.modeloId = modeloId;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public int getNumPortas() {
        return numPortas;
    }

    public void setNumPortas(int numPortas) {
        this.numPortas = numPortas;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}
