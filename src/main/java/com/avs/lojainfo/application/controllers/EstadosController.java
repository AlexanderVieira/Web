package com.avs.lojainfo.application.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.avs.lojainfo.application.dtos.CidadeDTO;
import com.avs.lojainfo.application.dtos.EstadoDTO;
import com.avs.lojainfo.domain.model.Cidade;
import com.avs.lojainfo.domain.model.Estado;
import com.avs.lojainfo.domain.services.CidadeService;
import com.avs.lojainfo.domain.services.EstadoService;

@RestController
public class EstadosController {
	
	private EstadoService _estadoService;	
	private CidadeService _cidadeService;		
	
	@Autowired
	public EstadosController(EstadoService estadoService, CidadeService cidadeService) {
		super();
		_estadoService = estadoService;
		_cidadeService = cidadeService;
	}

	@GetMapping(value = "/api/estados", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EstadoDTO>> findAll() {
		List<Estado> list = _estadoService.findAll();
		List<EstadoDTO> listDto = list.stream().map(obj -> new EstadoDTO(obj)).collect(Collectors.toList());  
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value="/api/{estadoId}/cidades", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CidadeDTO>> findCidades(@PathVariable Integer estadoId) {
		List<Cidade> list = _cidadeService.findByEstado(estadoId);
		List<CidadeDTO> listDto = list.stream().map(obj -> new CidadeDTO(obj)).collect(Collectors.toList());  
		return ResponseEntity.ok().body(listDto);
	}
}
