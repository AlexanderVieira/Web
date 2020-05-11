package com.avs.lojainfo.data.interfaces.repositories;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import com.avs.lojainfo.domain.model.Categoria;

@Repository
@Primary
public interface ICategoriaRepository extends IBaseRepository<Categoria, Integer> {
	
}