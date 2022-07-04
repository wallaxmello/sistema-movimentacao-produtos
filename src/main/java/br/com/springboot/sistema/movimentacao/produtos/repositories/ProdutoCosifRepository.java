package br.com.springboot.sistema-movimentacao-produtos.repositories;

import br.com.springboot.sistema-movimentacao-produtos.models.ProdutoCosif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoCosifRepository extends JpaRepository<ProdutoCosif, Long>{

}
