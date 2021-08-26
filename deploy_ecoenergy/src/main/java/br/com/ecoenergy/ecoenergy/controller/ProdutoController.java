package br.com.ecoenergy.ecoenergy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.ecoenergy.ecoenergy.model.Produto;
import br.com.ecoenergy.ecoenergy.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {

	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping
	private ResponseEntity<List<Produto>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> getById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nomeproduto/{nomeProduto}")
	public ResponseEntity<List<Produto>> getByNomeProduto(@PathVariable String nomeProduto) {
		return ResponseEntity.ok(repository.findAllByNomeProdutoContainingIgnoreCase(nomeProduto));
	}
	
	@GetMapping("/caracteristica/{caracteristica}")
	public ResponseEntity<List<Produto>> getByCaracteristica(@PathVariable String caracteristica) {
		return ResponseEntity.ok(repository.findAllByCaracteristicaContainingIgnoreCase(caracteristica));
	}
	
	@PostMapping
	public ResponseEntity<Produto> post(@RequestBody Produto produto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
	}
	
	@PutMapping
	public ResponseEntity<Produto> put(@RequestBody Produto produto) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(produto));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}
