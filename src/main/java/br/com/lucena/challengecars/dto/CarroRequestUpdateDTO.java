package br.com.lucena.challengecars.dto;

public class CarroRequestUpdateDTO extends CarroAbstractRequestDTO{
    private Long carroId;

    public CarroRequestUpdateDTO(Long modeloId, int ano, String combustivel, int numPortas, String cor, Long carroId) {
        super(modeloId, ano, combustivel, numPortas, cor);
        this.carroId = carroId;
    }

    public Long getCarroId() {
        return carroId;
    }

    public void setCarroId(Long carroId) {
        this.carroId = carroId;
    }
}
