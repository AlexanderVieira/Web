package com.avs.lojainfo.domain.services.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.avs.lojainfo.domain.model.Estado;

@Service
public interface IEstadoService extends IBaseService<Estado, Integer> {	
	
	public List<Estado> findAllByOrderByNome();
}