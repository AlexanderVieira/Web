package com.avs.lojainfo.infra.data.repositories.interfaces;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.avs.lojainfo.domain.model.Estado;

@Repository
public interface IEstadoRepository extends IBaseRepository<Estado, Integer> {
	
	@Transactional(value = TxType.NEVER)
	public List<Estado> findAllByOrderByNome();
}