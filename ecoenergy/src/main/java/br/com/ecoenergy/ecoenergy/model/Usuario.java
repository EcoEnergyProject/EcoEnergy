package br.com.ecoenergy.ecoenergy.model;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name = "tb_usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Email
	private String email;
	
	@NotNull
	@Size(min = 6, message = "Insira no mínimo 6 caracteres para a senha")
	private String senha;
	
	@NotNull
	@Column(name = "nome_completo")
	private String nomeCompleto;
	
	@NotNull
	private String adm;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getAdm() {
		return adm;
	}

	public void setAdm(String adm) {
		this.adm = adm;
	}
	
}
