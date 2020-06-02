package com.avs.lojainfo.infra.data.repositories.interfaces;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
//@Repository
public interface IBaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

	void deleteById(ID id);

	List<T> findAll();

	Optional<T> findById(ID id);

	<S extends T> S save(S entity);

	<S extends T> S saveAndFlush(S entity);

	<S extends T> List<S> saveAll(Iterable<S> entities);

	boolean existsById(ID id);

}