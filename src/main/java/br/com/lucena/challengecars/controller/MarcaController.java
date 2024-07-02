package br.com.lucena.challengecars.controller;

import br.com.lucena.challengecars.entity.Marca;
import br.com.lucena.challengecars.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marcas")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @GetMapping
    public List<Marca> getAllMarcas() {
        return marcaService.getAllMarcas();
    }

    @GetMapping("/{id}")
    public Marca getMarcaById(@PathVariable Long id) {
        return marcaService.getMarcaById(id);
    }

    @PostMapping
    public Marca createMarca(@RequestBody Marca marca) {
        return marcaService.createMarca(marca);
    }

    @PutMapping("/{id}")
    public Marca updateMarca(@PathVariable Long id, @RequestBody Marca marcaDetails) {
        return marcaService.updateMarca(id, marcaDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteMarca(@PathVariable Long id) {
        marcaService.deleteMarca(id);
    }
}
