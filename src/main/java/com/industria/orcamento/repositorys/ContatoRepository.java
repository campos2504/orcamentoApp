package com.industria.orcamento.repositorys;

import com.industria.orcamento.models.entitys.Contato;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long>{
    
}
