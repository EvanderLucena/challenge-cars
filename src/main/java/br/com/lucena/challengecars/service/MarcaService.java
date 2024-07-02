package br.com.lucena.challengecars.service;

import br.com.lucena.challengecars.entity.Marca;
import br.com.lucena.challengecars.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaService {
    @Autowired
    private MarcaRepository marcaRepository;

    public List<Marca> getAllMarcas() {
        return marcaRepository.findAll();
    }

    public Marca getMarcaById(Long id) {
        return marcaRepository.findById(id).orElse(null);
    }

    public Marca createMarca(Marca marca) {
        return marcaRepository.save(marca);
    }

    public Marca updateMarca(Long id, Marca marcaDetails) {
        Marca marca = marcaRepository.findById(id).orElse(null);
        if (marca != null) {
            marca.setNomeMarca(marcaDetails.getNomeMarca());
            return marcaRepository.save(marca);
        }
        return null;
    }

    public void deleteMarca(Long id) {
        marcaRepository.deleteById(id);
    }
}
