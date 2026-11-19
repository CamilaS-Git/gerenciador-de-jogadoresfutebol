package br.senac.tads.dsw.demo.repository;

import br.senac.tads.dsw.demo.model.JogadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogadorRepository extends JpaRepository<JogadorEntity, Long> {
}

/* Vazia porque estende JpaRepository, que fornece métodos prontos.
algns deles: findAll(), findById(), save(),delete()
 */
