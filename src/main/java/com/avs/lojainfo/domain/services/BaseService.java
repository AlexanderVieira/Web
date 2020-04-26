package com.avs.lojainfo.domain.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avs.lojainfo.data.interfaces.repositories.IBaseRepository;
import com.avs.lojainfo.domain.interfaces.services.IBaseService;

@Service
public class BaseService<T, ID extends Serializable> implements IBaseService<T, ID> {
	
	@Autowired
	private IBaseRepository<T, ID> baseRepository;

	@Override
	public void deleteById(ID id) {
		
		baseRepository.deleteById(id);
		
	}

	@Override
	public List<T> findAll() {
		
		List<T> collections = baseRepository.findAll();
		return collections;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Optional<T> findById(ID id) {
		
		Optional<T> obj = baseRepository.findById(id);		
		return (Optional<T>) obj.orElse(null);
	}

	@Override
	public T save(T entity) {
		
		T persisted = baseRepository.save(entity);
		return persisted;
	}

}
