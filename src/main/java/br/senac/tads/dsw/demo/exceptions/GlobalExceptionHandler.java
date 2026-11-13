package br.senac.tads.dsw.demo.exceptions;

import br.senac.tads.dsw.demo.exceptions.JogadorNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(JogadorNaoEncontradoException.class)
	public ResponseEntity<String> tratarJogadorNaoEncontrado(
		JogadorNaoEncontradoException ex) {

		return ResponseEntity
			.status(HttpStatus.NOT_FOUND)
			.body(ex.getMessage());
	}
}
