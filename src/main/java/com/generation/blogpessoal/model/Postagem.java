package com.generation.blogpessoal.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_postagens")
public class Postagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(min = 5, max = 100, message = "O título deve ter no mínimo 5 caracteres e no máximo 100")
	@NotBlank(message = "Atributo título é obrigatório")
	private String titulo;

	@Size(min = 10, max = 1000, message = "O texto deve ter no mínimo 10 caracteres e no máximo 1000")
	@NotBlank(message = "Atributo texto é obrigatório")
	private String texto;

	@UpdateTimestamp
	private LocalDateTime data;

	@ManyToOne
	// Muitas Postagens podem ter apenas Um Tema
	// A classe Postagem terá um objeto da classe Tema no modelo N:1, refletindo uma
	// chave estrangeira (tema_id) na tabela tb_postagens.
	@JsonIgnoreProperties("postagem")
	// Indica que parte do JSON será ignorada. Em uma relação bidirecional, quando
	// listamos um objeto Postagem, o objeto Tema (criado na linha 39) não será
	// exibido diretamente, evitando redundâncias no JSON.
	private Tema tema;

	// Receberá os dados do Tema associado ao Objeto da Classe Postagem. Este Objeto
	// representa a Chave Estrangeira da Tabela tb_postagens (tema_id).
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

}
