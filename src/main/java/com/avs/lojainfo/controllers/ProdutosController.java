package com.avs.lojainfo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.avs.lojainfo.domain.interfaces.services.IBaseService;
import com.avs.lojainfo.domain.model.Produto;
import com.avs.lojainfo.domain.services.applicationexception.ObjectNotFoundException;

@RestController
public class ProdutosController {

	@Autowired
	private IBaseService<Produto, Integer> baseService;

	@GetMapping(value = "/api/produtos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Produto>> findAll() {

		List<Produto> produtos = (List<Produto>) baseService.findAll();
		return new ResponseEntity<>(produtos, HttpStatus.OK);
	}

	@GetMapping(value = "/api/produto/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Produto> findById(@PathVariable Integer id) {

		Optional<Produto> optionalProduto = baseService.findById(id);
		Produto produto = optionalProduto.orElseThrow(() -> new ObjectNotFoundException("Produto não encontrado."));
		return new ResponseEntity<>(produto, HttpStatus.OK);

	}

	@DeleteMapping(value = "/api/produto/del/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Produto> deleteById(@PathVariable Integer id) {

		baseService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@PostMapping(value = "/api/produto/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Produto> save(@RequestBody(required = false) Produto produto) {

		Produto produtoPersistido = baseService.save(produto);
		return new ResponseEntity<>(produtoPersistido, HttpStatus.CREATED);
	}
}
