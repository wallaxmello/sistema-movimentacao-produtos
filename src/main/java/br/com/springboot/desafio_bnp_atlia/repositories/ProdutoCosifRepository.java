package br.com.springboot.desafio_bnp_atlia.repositories;

import br.com.springboot.desafio_bnp_atlia.models.ProdutoCosif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoCosifRepository extends JpaRepository<ProdutoCosif, Long>{

}
