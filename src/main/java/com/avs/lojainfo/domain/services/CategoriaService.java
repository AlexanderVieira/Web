package com.avs.lojainfo.domain.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.avs.lojainfo.data.interfaces.repositories.ICategoriaRepository;
import com.avs.lojainfo.domain.interfaces.services.ICategoriaService;
import com.avs.lojainfo.domain.model.Categoria;
import com.avs.lojainfo.domain.services.applicationexception.DataIntegrityException;
import com.avs.lojainfo.domain.services.applicationexception.ObjectNotFoundException;

@Service
public class CategoriaService implements ICategoriaService {

	private ICategoriaRepository _categoriaRepository;

	@Autowired
	public CategoriaService(ICategoriaRepository categoriaRepository) {
		super();
		_categoriaRepository = categoriaRepository;
	}

	@Override
	public void deleteById(Integer id) {
		
		try {

			if (existsById(id)) {

				_categoriaRepository.deleteById(id);
			}

		} catch (DataIntegrityViolationException e) {

			throw new DataIntegrityException("Erro tentar remover categoria. Existem produtos associados.");
		}
		
	}

	@Override
	public List<Categoria> findAll() {
		
		List<Categoria> collections = _categoriaRepository.findAll();
		if (collections == null || collections.isEmpty()) {

			throw new ObjectNotFoundException("Nenhum dado encontrado para exibição.");
		}
		return collections;
	}

	@Override
	public Optional<Categoria> findById(Integer id) {
		
		Optional<Categoria> obj = _categoriaRepository.findById(id);
		return obj;
	}

	@Override
	public <S extends Categoria> S save(S entity) {
		
		try {

			S persisted = _categoriaRepository.save(entity);
			return persisted;

		} catch (DataIntegrityViolationException e) {

			throw new DataIntegrityException("Erro interno do servidor. Tente mais tarde.");
		}
	}

	@Override
	public <S extends Categoria> S saveAndFlush(S entity) {
		
		try {

			S persisted = _categoriaRepository.saveAndFlush(entity);
			return persisted;

		} catch (DataIntegrityViolationException e) {

			throw new DataIntegrityException("Erro interno do servidor. Tente mais tarde.");
		}
	}

	@Override
	public <S extends Categoria> List<S> saveAll(Iterable<S> entities) {
		
		try {

			List<S> entidadesPersistidas = _categoriaRepository.saveAll(entities);
			return entidadesPersistidas;

		} catch (DataIntegrityViolationException e) {

			throw new DataIntegrityException("Erro interno do servidor. Tente mais tarde.");
		}
	}

	@Override
	public boolean existsById(Integer id) {
		
		boolean objExists = _categoriaRepository.existsById(id);
		return objExists;
	}
	
	
}