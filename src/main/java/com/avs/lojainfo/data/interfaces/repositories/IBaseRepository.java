package com.avs.lojainfo.data.interfaces.repositories;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface IBaseRepository<T, ID extends Serializable> extends Repository<T, ID> {
	
	void deleteById(ID id);
	List<T> findAll();    
    Optional<T> findById(ID id); 
    T save(T entity);
	
}