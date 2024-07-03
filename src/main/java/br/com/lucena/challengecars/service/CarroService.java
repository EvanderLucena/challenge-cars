package br.com.lucena.challengecars.service;

import br.com.lucena.challengecars.dto.CarroDTO;
import br.com.lucena.challengecars.dto.CarroRequestUpdateDTO;
import br.com.lucena.challengecars.entity.Carro;
import br.com.lucena.challengecars.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import br.com.lucena.challengecars.dto.CarroRequestCreateDTO;
import br.com.lucena.challengecars.entity.Modelo;
import br.com.lucena.challengecars.repository.ModeloRepository;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;
    @Autowired
    private ModeloRepository modeloRepository;

    public List<CarroDTO> getAllCarros() {
        return carroRepository.findAll().stream()
                .map(CarroDTO::fromCarro)
                .collect(Collectors.toList());
    }

    public CarroDTO getCarroById(Long id) {
        Carro carro = carroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carro não encontrado com ID: " + id));
        return CarroDTO.fromCarro(carro);
    }

    public CarroDTO createCarro(CarroRequestCreateDTO carroRequestDTO) {
        Carro carro = new Carro();
        Modelo modelo = modeloRepository.findById(carroRequestDTO.getModeloId())
                .orElseThrow(() -> new RuntimeException("Modelo não encontrado com ID: " + carroRequestDTO.getModeloId()));
        carro.setModelo(modelo);
        carro.setTimestampCadastro(Timestamp.from(Instant.now()));
        carro.setAno(carroRequestDTO.getAno());
        carro.setCombustivel(carroRequestDTO.getCombustivel());
        carro.setNumPortas(carroRequestDTO.getNumPortas());
        carro.setCor(carroRequestDTO.getCor());
        carro = carroRepository.save(carro);
        return CarroDTO.fromCarro(carro);
    }

    public CarroDTO updateCarro(CarroRequestUpdateDTO carroRequestDTO) {
        Carro carro = carroRepository.findById(carroRequestDTO.getCarroId())
                .orElseThrow(() -> new RuntimeException("Carro não encontrado com ID: " + carroRequestDTO.getCarroId()));
        carro.setAno(carroRequestDTO.getAno());
        carro.setTimestampCadastro(Timestamp.from(Instant.now()));
        carro.setCombustivel(carroRequestDTO.getCombustivel());
        carro.setNumPortas(carroRequestDTO.getNumPortas());
        carro.setCor(carroRequestDTO.getCor());
        Modelo modelo = modeloRepository.findById(carroRequestDTO.getModeloId())
                .orElseThrow(() -> new RuntimeException("Modelo não encontrado com ID: " + carroRequestDTO.getModeloId()));
        carro.setModelo(modelo);
        carro = carroRepository.save(carro);
        return CarroDTO.fromCarro(carro);
    }

    public void deleteCarro(Long id) {
        carroRepository.deleteById(id);
    }
}
