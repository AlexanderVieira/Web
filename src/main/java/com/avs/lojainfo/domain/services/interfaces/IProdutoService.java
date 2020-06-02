package com.avs.lojainfo.domain.services.interfaces;

import org.springframework.stereotype.Service;
import com.avs.lojainfo.domain.model.Produto;

@Service
public interface IProdutoService extends IBaseService<Produto, Integer> {	
	
}