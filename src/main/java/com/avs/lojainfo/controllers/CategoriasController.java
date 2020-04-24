package com.avs.lojainfo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.avs.lojainfo.domain.model.Categoria;

@RestController
@RequestMapping(value = "/api/categorias")
public class CategoriasController {

	@RequestMapping(method=RequestMethod.GET)
	public List<Categoria> GetAll() {
		
		Categoria categoria1 = new Categoria(1, "Informática");
		Categoria categoria2 = new Categoria(2, "Escritório");
				
		List<Categoria> categorias = new ArrayList<>();
		categorias.add(categoria1);
		categorias.add(categoria2);
		
		return categorias;
	}
}
