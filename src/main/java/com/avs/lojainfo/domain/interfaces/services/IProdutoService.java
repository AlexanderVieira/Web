package com.avs.lojainfo.domain.interfaces.services;

import org.springframework.stereotype.Service;
import com.avs.lojainfo.domain.model.Produto;

@Service
public interface IProdutoService extends IBaseService<Produto, Integer> {	
	
}