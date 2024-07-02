package br.com.lucena.challengecars.repository;

import br.com.lucena.challengecars.entity.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, Long> {}
