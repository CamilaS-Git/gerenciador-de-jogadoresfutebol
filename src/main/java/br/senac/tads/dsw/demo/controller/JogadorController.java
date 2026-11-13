package br.senac.tads.dsw.demo.controller;


import br.senac.tads.dsw.demo.dto.JogadorRequest;
import br.senac.tads.dsw.demo.dto.JogadorResponse;
import br.senac.tads.dsw.demo.service.JogadorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogadores")
@RequiredArgsConstructor
public class JogadorController {

	private final JogadorService service;

	@GetMapping
	public List<JogadorResponse> listarJogadores() {
		return service.listarJogadores();
	}

	@GetMapping("/{id}")
	public JogadorResponse buscarJogador(@PathVariable Long id) {
		return service.buscarJogadorPorId(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public JogadorResponse criarJogador(@Valid @RequestBody JogadorRequest request) {
		return service.criarJogador(request);
	}

	@PutMapping("/{id}")
	public JogadorResponse atualizarJogador(@PathVariable Long id,
									 @Valid @RequestBody JogadorRequest request) {
		return service.atualizarJogador(id, request);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable Long id) {
		service.excluirJogador(id);
	}
}
