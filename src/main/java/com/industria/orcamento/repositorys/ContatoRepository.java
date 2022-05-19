package com.industria.orcamento.repositorys;

import java.util.List;

import com.industria.orcamento.models.entitys.Contato;
import com.industria.orcamento.models.entitys.Empresa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long>{

    List<Contato> findByEmpresa(Empresa empresa);
    
}
