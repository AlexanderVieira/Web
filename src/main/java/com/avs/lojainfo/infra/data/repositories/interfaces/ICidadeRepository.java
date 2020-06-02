package com.avs.lojainfo.infra.data.repositories.interfaces;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.avs.lojainfo.domain.model.Cidade;

@Repository
public interface ICidadeRepository extends IBaseRepository<Cidade, Integer> {
	
	@Transactional(value = TxType.NEVER)
	@Query("SELECT obj FROM Cidade obj WHERE obj.estado.id = :estadoId ORDER BY obj.nome")
	public List<Cidade> findCidades(@Param("estadoId") Integer estado_id);
}