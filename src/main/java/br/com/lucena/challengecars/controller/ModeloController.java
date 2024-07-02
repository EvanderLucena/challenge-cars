package br.com.lucena.challengecars.controller;

import br.com.lucena.challengecars.dto.ModeloDTO;
import br.com.lucena.challengecars.dto.ModeloRequestDTO;
import br.com.lucena.challengecars.entity.Modelo;
import br.com.lucena.challengecars.service.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/modelos")
public class ModeloController {

    @Autowired
    private ModeloService modeloService;

    @GetMapping
    public List<ModeloDTO> getAllModelos() {
        return modeloService.getAllModelos();
    }

    @GetMapping("/{id}")
    public ModeloDTO getModeloById(@PathVariable Long id) {
        return modeloService.getModeloById(id);
    }

    @PostMapping
    public ModeloDTO createModelo(@RequestBody ModeloRequestDTO modelo) {
        return modeloService.createModelo(modelo);
    }

    @PutMapping("/{id}")
    public ModeloDTO updateModelo(@PathVariable Long id, @RequestBody ModeloRequestDTO modeloDetails) {
        return modeloService.updateModelo(id, modeloDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteModelo(@PathVariable Long id) {
        modeloService.deleteModelo(id);
    }
}
