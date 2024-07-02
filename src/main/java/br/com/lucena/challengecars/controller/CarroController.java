package br.com.lucena.challengecars.controller;

import br.com.lucena.challengecars.dto.CarroDTO;
import br.com.lucena.challengecars.entity.Carro;
import br.com.lucena.challengecars.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/carros")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @GetMapping
    public List<Carro> getAllCarros() {
        return carroService.getAllCarros();
    }

    @GetMapping("/{id}")
    public Carro getCarroById(@PathVariable Long id) {
        return carroService.getCarroById(id);
    }

    @PostMapping
    public Carro createCarro(@RequestBody Carro carro) {
        return carroService.createCarro(carro);
    }

    @PutMapping("/{id}")
    public Carro updateCarro(@PathVariable Long id, @RequestBody Carro carroDetails) {
        return carroService.updateCarro(id, carroDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteCarro(@PathVariable Long id) {
        carroService.deleteCarro(id);
    }

    @GetMapping("/listagem")
    public Map<String, List<CarroDTO>> getAllCarrosWithModelInfo() {
        List<CarroDTO> carros = carroService.getAllCarrosWithModelInfo();
        Map<String, List<CarroDTO>> response = new HashMap<>();
        response.put("cars", carros);
        return response;
    }
}
