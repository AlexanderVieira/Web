package com.avs.lojainfo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.avs.lojainfo.domain.interfaces.services.IBaseService;
import com.avs.lojainfo.domain.model.Categoria;

@RestController
@RequestMapping(value = "/api/categorias")
public class CategoriasController {

	@Autowired
	private IBaseService<?, ?> baseService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(method=RequestMethod.GET)
	public List<Categoria> GetAll() {	
			
		List<Categoria> categorias = new ArrayList<>();
		categorias = (List<Categoria>) baseService.findAll();
		return categorias;
	}
}
