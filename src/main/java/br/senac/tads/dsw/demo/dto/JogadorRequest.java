package br.senac.tads.dsw.demo.dto;

import jakarta.validation.constraints.*;

public record JogadorRequest(

	@NotNull(message = "O nome é obrigatório.")
	@Pattern(regexp = "(\\s*\\S){2,}\\s*",
		message = "O nome deve ter no mínimo 2 caracteres que não sejam espaços em branco.")
	String nome,

	@NotNull(message = "O número da camisa é obrigatório.")
	@Min(value = 1, message = "O número da camisa deve ser entre 1 e 99.")
	@Max(value = 99, message = "O número da camisa deve ser entre 1 e 99.")
	Integer numeroCamisa,

	@NotNull(message = "O time é obrigatório.")
	@Pattern(regexp = "(\\s*\\S){2,}\\s*",
		message = "O time deve ter no mínimo 2 caracteres que não sejam espaços em branco.")
	String time,

	@NotNull(message = "Informe se o jogador está lesionado.")
	Boolean lesionado,

	String observacoes)
{}
