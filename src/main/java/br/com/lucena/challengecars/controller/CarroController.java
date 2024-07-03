package br.com.lucena.challengecars.controller;

import br.com.lucena.challengecars.dto.CarroDTO;
import br.com.lucena.challengecars.dto.CarroRequestCreateDTO;
import br.com.lucena.challengecars.dto.CarroRequestUpdateDTO;
import br.com.lucena.challengecars.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carros")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @GetMapping
    public List<CarroDTO> getAllCarros() {
        return carroService.getAllCarros();
    }

    @GetMapping("/{id}")
    public CarroDTO getCarroById(@PathVariable Long id) {
        return carroService.getCarroById(id);
    }

    @PostMapping
    public CarroDTO createCarro(@RequestBody CarroRequestCreateDTO carro) {
        return carroService.createCarro(carro);
    }

    @PutMapping("/{id}")
    public CarroDTO updateCarro(@RequestBody CarroRequestUpdateDTO carroDetails) {
        return carroService.updateCarro(carroDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteCarro(@PathVariable Long id) {
        carroService.deleteCarro(id);
    }

}
