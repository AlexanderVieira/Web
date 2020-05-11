package com.avs.lojainfo.data.interfaces.repositories;

import org.springframework.stereotype.Repository;
import com.avs.lojainfo.domain.model.Produto;

@Repository
public interface IProdutoRepository extends IBaseRepository<Produto, Integer> {
	
}