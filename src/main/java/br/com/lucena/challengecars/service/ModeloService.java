package br.com.lucena.challengecars.service;

import br.com.lucena.challengecars.entity.Modelo;
import br.com.lucena.challengecars.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeloService {

    @Autowired
    private ModeloRepository modeloRepository;

    public List<Modelo> getAllModelos() {
        return modeloRepository.findAll();
    }

    public Modelo getModeloById(Long id) {
        return modeloRepository.findById(id).orElse(null);
    }

    public Modelo createModelo(Modelo modelo) {
        return modeloRepository.save(modelo);
    }

    public Modelo updateModelo(Long id, Modelo modeloDetails) {
        Modelo modelo = modeloRepository.findById(id).orElse(null);
        if (modelo != null) {
            modelo.setNome(modeloDetails.getNome());
            modelo.setValorFipe(modeloDetails.getValorFipe());
            modelo.setMarca(modeloDetails.getMarca());
            return modeloRepository.save(modelo);
        }
        return null;
    }

    public void deleteModelo(Long id) {
        modeloRepository.deleteById(id);
    }
}
