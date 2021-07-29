package br.com.ecoenergy.ecoenergy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto incremento. 
	private long id;
	
	@NotNull (message = "O Atributo categoria é obrigatório")
	@Size(min = 5, max = 100)
	private String tipo;
	
	@NotNull (message = "O Atributo descrição é obrigatório")
	@Size(min = 10, max = 2000) 
	private String descricao_categoria;
	
	@NotNull (message = "O Atributo palavra chave é obrigatório")
	@Size(min = 5, max = 100)
	private String palavra_chave;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao_categoria() {
		return descricao_categoria;
	}

	public void setDescricao_categoria(String descricao_categoria) {
		this.descricao_categoria = descricao_categoria;
	}

	public String getPalavra_chave() {
		return palavra_chave;
	}

	public void setPalavra_chave(String palavra_chave) {
		this.palavra_chave = palavra_chave;
	}
	
}
