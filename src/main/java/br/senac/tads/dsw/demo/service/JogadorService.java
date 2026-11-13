
package br.senac.tads.dsw.demo.service;

import br.senac.tads.dsw.demo.dto.JogadorRequest;
import br.senac.tads.dsw.demo.dto.JogadorResponse;
import br.senac.tads.dsw.demo.exceptions.JogadorNaoEncontradoException;
import br.senac.tads.dsw.demo.model.JogadorEntity;
import br.senac.tads.dsw.demo.repository.JogadorRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class JogadorService {

	private final JogadorRepository jogadorRepository;

	private JogadorEntity toEntity(JogadorRequest request) {
		JogadorEntity entity = new JogadorEntity();
		preencherDados(entity, request);
		return entity;
	}

	private void preencherDados(JogadorEntity entity, JogadorRequest request) {
		entity.setNome(request.nome().trim());
		entity.setNumeroCamisa(request.numeroCamisa());
		entity.setTime(request.time().trim());
		entity.setLesionado(request.lesionado());
		entity.setObservacoes(
			request.observacoes() == null
				? null
				: request.observacoes().trim()
		);
	}

	private JogadorEntity buscarJogador(Long id) {
		return jogadorRepository.findById(id)
			.orElseThrow(() ->
				new JogadorNaoEncontradoException(
					"Jogador não encontrado: ID " + id
				)
			);
	}

	@Transactional(readOnly = true)
	public List<JogadorResponse> listarJogadores() {
		List<JogadorResponse> resultado = new ArrayList<>();

		for (JogadorEntity entity : jogadorRepository.findAll()) {
			JogadorResponse response = JogadorResponse.de(entity);
			resultado.add(response);
		}

		return resultado;
	}
	@Transactional(readOnly = true)
	public JogadorResponse buscarJogadorPorId(Long id) {
		return JogadorResponse.de(buscarJogador(id));
	}

	@Transactional
	public JogadorResponse criarJogador(JogadorRequest request) {
		JogadorEntity entity = toEntity(request);
		JogadorEntity salvo = jogadorRepository.save(entity);

		return JogadorResponse.de(salvo);
	}

	// Atualização de jogador
	@Transactional
	public JogadorResponse atualizarJogador(Long id, JogadorRequest request) {
		JogadorEntity entity = buscarJogador(id);

		preencherDados(entity, request);

		JogadorEntity salvo = jogadorRepository.save(entity);

		return JogadorResponse.de(salvo);
	}

	@Transactional
	public void excluirJogador(Long id) {
		JogadorEntity entity = buscarJogador(id);
		jogadorRepository.delete(entity);
	}
}
