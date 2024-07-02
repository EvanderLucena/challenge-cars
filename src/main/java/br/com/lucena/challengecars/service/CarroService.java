package br.com.lucena.challengecars.service;

import br.com.lucena.challengecars.dto.CarroDTO;
import br.com.lucena.challengecars.entity.Carro;
import br.com.lucena.challengecars.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public List<Carro> getAllCarros() {
        return carroRepository.findAll();
    }

    public Carro getCarroById(Long id) {
        return carroRepository.findById(id).orElse(null);
    }

    public Carro createCarro(Carro carro) {
        return carroRepository.save(carro);
    }

    public Carro updateCarro(Long id, Carro carroDetails) {
        Carro carro = carroRepository.findById(id).orElse(null);
        if (carro != null) {
            carro.setTimestampCadastro(carroDetails.getTimestampCadastro());
            carro.setAno(carroDetails.getAno());
            carro.setCombustivel(carroDetails.getCombustivel());
            carro.setNumPortas(carroDetails.getNumPortas());
            carro.setCor(carroDetails.getCor());
            carro.setModelo(carroDetails.getModelo());
            return carroRepository.save(carro);
        }
        return null;
    }

    public void deleteCarro(Long id) {
        carroRepository.deleteById(id);
    }

    public List<CarroDTO> getAllCarrosWithModelInfo() {
        List<Carro> carros = carroRepository.findAll();
        return carros.stream().map(carro -> {
            CarroDTO dto = new CarroDTO();
            dto.setId(carro.getId());
            dto.setTimestampCadastro(carro.getTimestampCadastro().getTime());
            dto.setModeloId(carro.getModelo().getId());
            dto.setAno(carro.getAno());
            dto.setCombustivel(carro.getCombustivel());
            dto.setNumPortas(carro.getNumPortas());
            dto.setCor(carro.getCor());
            dto.setNomeModelo(carro.getModelo().getNome());
            dto.setValor(carro.getModelo().getValorFipe());
            return dto;
        }).collect(Collectors.toList());
    }
}
