package com.avs.lojainfo.application.controllers;

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

import com.avs.lojainfo.application.exception.ObjectNotFoundException;
import com.avs.lojainfo.domain.model.Categoria;
import com.avs.lojainfo.domain.services.interfaces.ICategoriaService;

@RestController
public class CategoriasController {
	
	//private IBaseService<Categoria, Integer> baseService;
	private ICategoriaService _categoriaService;	
	
	@Autowired
	public CategoriasController(ICategoriaService categoriaService) {
		super();
		_categoriaService = categoriaService;
	}

	@GetMapping(value = "/api/categorias", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Categoria>> findAll() {

		List<Categoria> categorias = (List<Categoria>) _categoriaService.findAll();
		return new ResponseEntity<>(categorias, HttpStatus.OK);
	}

	@GetMapping(value = "/api/categoria/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Categoria> findById(@PathVariable Integer id) {

		Optional<Categoria> optionalCategoria = _categoriaService.findById(id);
		Categoria categoria = optionalCategoria
				.orElseThrow(() -> new ObjectNotFoundException("Categoria não encontrada."));
		return new ResponseEntity<>(categoria, HttpStatus.OK);

	}

	@DeleteMapping(value = "/api/categoria/del/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Categoria> deleteById(@PathVariable Integer id) {

		_categoriaService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@ResponseBody
	@PostMapping(value = "/api/categoria/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<Categoria> save(@RequestBody(required = false) Categoria categoria) {

		Categoria categoriaPersistida = _categoriaService.save(categoria);
		return new ResponseEntity<>(categoriaPersistida, HttpStatus.CREATED);
	}
}
