package com.avs.lojainfo.domain.interfaces.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public interface IBaseService<T, ID> {

	void deleteById(ID id);
	List<T> findAll();    
    Optional<T> findById(ID id); 
    T save(T persisted);
	
}
