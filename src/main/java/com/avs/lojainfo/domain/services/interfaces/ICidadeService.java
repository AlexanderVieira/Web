package com.avs.lojainfo.domain.services.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.avs.lojainfo.domain.model.Cidade;

@Service
public interface ICidadeService extends IBaseService<Cidade, Integer> {	
	
	public List<Cidade> findByEstado(Integer estado_id);
}