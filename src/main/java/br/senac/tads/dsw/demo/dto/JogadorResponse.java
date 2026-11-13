package br.senac.tads.dsw.demo.dto;

import br.senac.tads.dsw.demo.model.JogadorEntity;

public record JogadorResponse(
	Long id,
	String nome,
	Integer numeroCamisa,
	String time,
	Boolean lesionado,
	String observacoes
) {
	public static JogadorResponse de(JogadorEntity jogadorEntity) {
		return new JogadorResponse(jogadorEntity.getId(), jogadorEntity.getNome(), jogadorEntity.getNumeroCamisa(),
			jogadorEntity.getTime(), jogadorEntity.getLesionado(), jogadorEntity.getObservacoes()
		);
	}
}
