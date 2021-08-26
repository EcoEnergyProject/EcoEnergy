package br.com.ecoenergy.ecoenergy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ecoenergy.ecoenergy.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	public List<Produto> findAllByNomeProdutoContainingIgnoreCase(String nomeProduto);
	public List<Produto> findAllByCaracteristicaContainingIgnoreCase(String caracteristica);
}
