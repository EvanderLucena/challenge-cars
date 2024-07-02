package br.com.lucena.challengecars.repository;

import br.com.lucena.challengecars.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Long> {}
