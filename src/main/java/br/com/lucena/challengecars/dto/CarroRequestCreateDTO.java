package br.com.lucena.challengecars.dto;

public class CarroRequestCreateDTO extends CarroAbstractRequestDTO {

    public CarroRequestCreateDTO(Long modeloId, int ano, String combustivel, int numPortas, String cor) {
        super(modeloId, ano, combustivel, numPortas, cor);
    }
}
