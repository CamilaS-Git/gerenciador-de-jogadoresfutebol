package br.senac.tads.dsw.demo.repository;

import br.senac.tads.dsw.demo.model.JogadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogadorRepository extends JpaRepository<JogadorEntity, Long> {
}
