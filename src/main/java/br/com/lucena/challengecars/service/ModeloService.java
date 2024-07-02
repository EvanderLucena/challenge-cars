package br.com.lucena.challengecars.service;

import br.com.lucena.challengecars.dto.ModeloDTO;
import br.com.lucena.challengecars.dto.ModeloRequestDTO;
import br.com.lucena.challengecars.entity.Modelo;
import br.com.lucena.challengecars.repository.CarroRepository;
import br.com.lucena.challengecars.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import br.com.lucena.challengecars.entity.Marca;
import br.com.lucena.challengecars.repository.MarcaRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ModeloService {

    @Autowired
    private ModeloRepository modeloRepository;

    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private CarroRepository carroRepository;

    public List<ModeloDTO> getAllModelos() {
        List<Modelo> modelos = modeloRepository.findAll();
        return modelos.stream()
                .map(ModeloDTO::fromModelo)
                .collect(Collectors.toList());
    }

    public ModeloDTO getModeloById(Long id) {
        Modelo modelo = modeloRepository.findById(id).orElseThrow(() -> new RuntimeException("Modelo não encontrado com ID: " + id));
        return ModeloDTO.fromModelo(modelo);
    }

    @Transactional
    public ModeloDTO createModelo(ModeloRequestDTO modeloRequestDTO) {
        Marca marca = marcaRepository.findById(modeloRequestDTO.getMarcaId())
                .orElseThrow(() -> new RuntimeException("Marca não encontrada com ID: " + modeloRequestDTO.getMarcaId()));

        Modelo modelo = new Modelo();
        modelo.setNome(modeloRequestDTO.getNome());
        modelo.setValorFipe(modeloRequestDTO.getValorFipe());
        modelo.setMarca(marca);

        return ModeloDTO.fromModelo(modeloRepository.save(modelo));
    }

    @Transactional
    public ModeloDTO updateModelo(Long id, ModeloRequestDTO modeloRequestDTO) {
        Modelo modelo = modeloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Modelo não encontrado com ID: " + id));

        // Atualizar os campos do Modelo com os dados do DTO
        modelo.setNome(modeloRequestDTO.getNome());
        modelo.setValorFipe(modeloRequestDTO.getValorFipe());

        // Verificar e atualizar a Marca associada ao Modelo
        Long marcaId = modeloRequestDTO.getMarcaId();
        Marca marca = marcaRepository.findById(marcaId)
                .orElseThrow(() -> new RuntimeException("Marca não encontrada com ID: " + marcaId));

        modelo.setMarca(marca);

        return ModeloDTO.fromModelo(modeloRepository.save(modelo));
    }

    @Transactional
    public void deleteModelo(Long id) {
        if (carroRepository.existsByModeloId(id)) {
            throw new RuntimeException("Não é possível deletar o modelo porque ele está associado a um ou mais carros.");
        }
        modeloRepository.deleteById(id);
    }
}
