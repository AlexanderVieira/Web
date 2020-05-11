package com.avs.lojainfo.domain.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.avs.lojainfo.data.interfaces.repositories.IBaseRepository;
import com.avs.lojainfo.domain.interfaces.services.IBaseService;
import com.avs.lojainfo.domain.services.applicationexception.DataIntegrityException;
import com.avs.lojainfo.domain.services.applicationexception.ObjectNotFoundException;

@Service
public class BaseService<T, ID extends Serializable> implements IBaseService<T, ID> {

	@Autowired
	private IBaseRepository<T, ID> baseRepository;

	@Override
	public void deleteById(ID id) {
		
		try {
			
			if (existsById(id)) {
				
				baseRepository.deleteById(id);
			}			

		} catch (DataIntegrityViolationException e) {

			throw new DataIntegrityException("Erro interno do servidor. Tente mais tarde.");
		}

	}

	@Override
	public List<T> findAll() {

		List<T> collections = baseRepository.findAll();
		if (collections == null || collections.isEmpty()) {

			throw new ObjectNotFoundException("Nenhum dado encontrado para exibição.");
		}
		return collections;

	}

	@Override
	public Optional<T> findById(ID id) {

		Optional<T> obj = baseRepository.findById(id);
		return (Optional<T>) obj;
	}

	@Override
	public <S extends T> S save(S entity) {

		try {

			S persisted = baseRepository.save(entity);
			return persisted;

		} catch (DataIntegrityViolationException e) {

			throw new DataIntegrityException("Erro interno do servidor. Tente mais tarde.");
		}

	}

	@Override
	public <S extends T> S saveAndFlush(S entity) {

		try {

			S persisted = baseRepository.saveAndFlush(entity);
			return persisted;

		} catch (DataIntegrityViolationException e) {

			throw new DataIntegrityException("Erro interno do servidor. Tente mais tarde.");
		}
	}

	@Override
	public <S extends T> List<S> saveAll(Iterable<S> entities) {

		try {

			List<S> entidadesPersistidas = baseRepository.saveAll(entities);
			return entidadesPersistidas;

		} catch (DataIntegrityViolationException e) {

			throw new DataIntegrityException("Erro interno do servidor. Tente mais tarde.");
		}

	}

	@Override
	public boolean existsById(ID id) {
		
		boolean objExists = baseRepository.existsById(id);
		return objExists;
	}

}
