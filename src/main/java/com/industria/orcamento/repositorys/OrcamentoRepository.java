package com.industria.orcamento.repositorys;

import com.industria.orcamento.models.entitys.Orcamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrcamentoRepository extends JpaRepository<Orcamento, Long>{
    
}
