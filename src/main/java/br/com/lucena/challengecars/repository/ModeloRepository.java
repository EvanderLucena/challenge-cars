package br.com.lucena.challengecars.repository;

import br.com.lucena.challengecars.entity.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModeloRepository extends JpaRepository<Modelo, Long> {}
