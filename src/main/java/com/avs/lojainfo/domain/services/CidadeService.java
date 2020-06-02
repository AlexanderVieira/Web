package com.avs.lojainfo.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.avs.lojainfo.application.exception.DataIntegrityException;
import com.avs.lojainfo.domain.model.Cidade;
import com.avs.lojainfo.domain.services.interfaces.ICidadeService;
import com.avs.lojainfo.infra.data.repositories.interfaces.ICidadeRepository;

@Service
public class CidadeService implements ICidadeService {
	
	private ICidadeRepository _cidadeRepository;	
	
	@Autowired
	public CidadeService(ICidadeRepository cidadeRepository) {
		super();
		_cidadeRepository = cidadeRepository;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Cidade> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Cidade> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Cidade> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Cidade> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Cidade> List<S> saveAll(Iterable<S> entities) {
		
		try {

			List<S> entidadesPersistidas = _cidadeRepository.saveAll(entities);
			return entidadesPersistidas;

		} catch (DataIntegrityViolationException e) {

			throw new DataIntegrityException("Erro interno do servidor. Tente mais tarde.");
		}
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Cidade> findByEstado(Integer estado_id) {
		
		return _cidadeRepository.findCidades(estado_id);
	}
	
	

}
