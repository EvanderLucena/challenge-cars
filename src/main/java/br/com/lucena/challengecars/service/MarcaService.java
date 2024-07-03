package br.com.lucena.challengecars.service;

import br.com.lucena.challengecars.dto.MarcaRquestDTO;
import br.com.lucena.challengecars.entity.Marca;
import br.com.lucena.challengecars.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.lucena.challengecars.repository.MarcaRepository;
import br.com.lucena.challengecars.repository.ModeloRepository;
import br.com.lucena.challengecars.dto.MarcaDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private ModeloRepository modeloRepository;

    public List<MarcaDTO> getAllMarcas() {
        return marcaRepository.findAll().stream()
                .map(MarcaDTO::fromMarca)
                .collect(Collectors.toList());
    }

    public MarcaDTO getMarcaById(Long id) {
        Marca marca = marcaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Marca não encontrada com ID: " + id));
        return MarcaDTO.fromMarca(marca);
    }

    @Transactional
    public MarcaDTO createMarca(MarcaRquestDTO marcaDTO) {
        Marca marca = new Marca();
        marca.setNomeMarca(marcaDTO.getNomeMarca());
        return MarcaDTO.fromMarca(marcaRepository.save(marca));
    }

    @Transactional
    public MarcaDTO updateMarca(Long id, MarcaRquestDTO marcaDTO) {
        Marca marca = marcaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Marca não encontrada com ID: " + id));
        marca.setNomeMarca(marcaDTO.getNomeMarca());
        return MarcaDTO.fromMarca(marcaRepository.save(marca));
    }

    @Transactional
    public void deleteMarca(Long id) {
        if (modeloRepository.existsByMarcaId(id)) {
            throw new RuntimeException("Não é possível deletar a marca porque ela está associada a um ou mais modelos.");
        }
        marcaRepository.deleteById(id);
    }
}

