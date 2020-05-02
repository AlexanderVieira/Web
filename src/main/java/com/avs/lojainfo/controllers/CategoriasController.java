package com.avs.lojainfo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.avs.lojainfo.domain.interfaces.services.IBaseService;
import com.avs.lojainfo.domain.model.Categoria;

@RestController
public class CategoriasController {

	@Autowired
	private IBaseService<Categoria, Integer> baseService;

	@GetMapping(value = "/api/categorias", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Categoria>> findAll() {

		List<Categoria> categorias = new ArrayList<>();
		categorias = (List<Categoria>) baseService.findAll();
		return new ResponseEntity<>(categorias, HttpStatus.OK);
	}

	@GetMapping(value = "/api/categoria/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Categoria> findById(@PathVariable Integer id) {

		Optional<Categoria> optionalCategoria = baseService.findById(id);

		if (optionalCategoria != null) {
			Categoria categoria = optionalCategoria.orElse(new Categoria());
			return new ResponseEntity<>(categoria, HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}
	
	@GetMapping(value = "/api/categoria/del/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Categoria> deleteById(@PathVariable Integer id) {

		baseService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);

	}
	
	@PostMapping(value = "/api/categoria/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Categoria> save(@RequestBody  Categoria categoria){
		
		Categoria categoriaPersistida = baseService.save(categoria);
		return new ResponseEntity<>(categoriaPersistida, HttpStatus.CREATED);
	}
}
