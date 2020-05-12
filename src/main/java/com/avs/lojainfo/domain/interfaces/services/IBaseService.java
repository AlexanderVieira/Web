package com.avs.lojainfo.domain.interfaces.services;

import java.util.List;
import java.util.Optional;

//@Service
public interface IBaseService<T, ID> {

	void deleteById(ID id);

	List<T> findAll();

	Optional<T> findById(ID id);

	<S extends T> S save(S entity);

	<S extends T> S saveAndFlush(S entity);

	<S extends T> List<S> saveAll(Iterable<S> entities);

	boolean existsById(ID id);

}