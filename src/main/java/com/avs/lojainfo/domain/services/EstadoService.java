package com.avs.lojainfo.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.avs.lojainfo.application.exception.DataIntegrityException;
import com.avs.lojainfo.domain.model.Estado;
import com.avs.lojainfo.domain.services.interfaces.IEstadoService;
import com.avs.lojainfo.infra.data.repositories.interfaces.IEstadoRepository;

@Service
public class EstadoService implements IEstadoService {
	
	private IEstadoRepository _estadoRepository;
	
	@Autowired
	public EstadoService(IEstadoRepository estadoRepository) {
		super();
		_estadoRepository = estadoRepository;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Estado> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Estado> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Estado> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Estado> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Estado> List<S> saveAll(Iterable<S> entities) {
		
		try {

			List<S> entidadesPersistidas = _estadoRepository.saveAll(entities);
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
	public List<Estado> findAllByOrderByNome() {
		
		return _estadoRepository.findAllByOrderByNome();
	}

}
