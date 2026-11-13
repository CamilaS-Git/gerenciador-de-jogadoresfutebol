package br.senac.tads.dsw.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

public record JogadorRequest(

	@Schema(example = "Vini Jr")
	@NotNull(message = "O nome é obrigatório.")
	@Pattern(regexp = "(\\s*\\S){2,}\\s*",
		message = "O nome deve ter no mínimo 2 caracteres que não sejam espaços em branco.")
	String nome,

	@Schema(example = "7")
	@NotNull(message = "O número da camisa é obrigatório.")
	@Min(value = 1, message = "O número da camisa deve ser entre 1 e 99.")
	@Max(value = 99, message = "O número da camisa deve ser entre 1 e 99.")
	Integer numeroCamisa,

	@Schema(example = "Real Madrid")
	@NotNull(message = "O time é obrigatório.")
	@Pattern(regexp = "(\\s*\\S){2,}\\s*",
		message = "O time deve ter no mínimo 2 caracteres que não sejam espaços em branco.")
	String time,

	@NotNull(message = "Informe se o jogador está lesionado.")
	Boolean lesionado,

	String observacoes)
{}
