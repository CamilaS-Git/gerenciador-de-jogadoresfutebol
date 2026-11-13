package br.senac.tads.dsw.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

	@Entity
	@Table(name = "jogadores")
	@Getter
	@Setter
	@NoArgsConstructor
	public class JogadorEntity {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		@Column(nullable = false)
		private String nome;

		@Column(name = "numero_camisa", nullable = false)
		private Integer numeroCamisa;

		@Column(nullable = false)
		private String time;

		@Column(nullable = false)
		private Boolean lesionado = false;

		@Column(columnDefinition = "TEXT")
		private String observacoes;
}
