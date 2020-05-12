package com.avs.lojainfo.domain.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.avs.lojainfo.data.interfaces.repositories.IProdutoRepository;
import com.avs.lojainfo.domain.interfaces.services.IProdutoService;
import com.avs.lojainfo.domain.model.Produto;
import com.avs.lojainfo.domain.services.applicationexception.DataIntegrityException;
import com.avs.lojainfo.domain.services.applicationexception.ObjectNotFoundException;

@Service
public class ProdutoService implements IProdutoService {

	private IProdutoRepository _produtoRepository;

	@Autowired
	public ProdutoService(IProdutoRepository produtoRepository) {
		super();
		_produtoRepository = produtoRepository;
	}

	@Override
	public void deleteById(Integer id) {

		try {

			if (existsById(id)) {

				_produtoRepository.deleteById(id);
			}

		} catch (DataIntegrityViolationException e) {

			throw new DataIntegrityException("Erro interno do servidor. Tente mais tarde.");
		}

	}

	@Override
	public List<Produto> findAll() {

		List<Produto> collections = _produtoRepository.findAll();
		if (collections == null || collections.isEmpty()) {

			throw new ObjectNotFoundException("Nenhum dado encontrado para exibição.");
		}
		return collections;
	}

	@Override
	public Optional<Produto> findById(Integer id) {

		Optional<Produto> obj = _produtoRepository.findById(id);
		return obj;
	}

	@Override
	public <S extends Produto> S save(S entity) {

		try {

			S persisted = _produtoRepository.save(entity);
			return persisted;

		} catch (DataIntegrityViolationException e) {

			throw new DataIntegrityException("Erro interno do servidor. Tente mais tarde.");
		}
	}

	@Override
	public <S extends Produto> S saveAndFlush(S entity) {

		try {

			S persisted = _produtoRepository.saveAndFlush(entity);
			return persisted;

		} catch (DataIntegrityViolationException e) {

			throw new DataIntegrityException("Erro interno do servidor. Tente mais tarde.");
		}
	}

	@Override
	public <S extends Produto> List<S> saveAll(Iterable<S> entities) {

		try {

			List<S> entidadesPersistidas = _produtoRepository.saveAll(entities);
			return entidadesPersistidas;

		} catch (DataIntegrityViolationException e) {

			throw new DataIntegrityException("Erro interno do servidor. Tente mais tarde.");
		}

	}

	@Override
	public boolean existsById(Integer id) {

		boolean objExists = _produtoRepository.existsById(id);
		return objExists;
	}

}