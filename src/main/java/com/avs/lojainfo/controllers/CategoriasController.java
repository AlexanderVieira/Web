package com.avs.lojainfo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/categorias")
public class CategoriasController {

	@RequestMapping(method=RequestMethod.GET)
	public String imprimir() {
		
		return "REST funcionando!!!";
	}
}
