package br.com.springboot.desafio_bnp_atlia.repositories;

import br.com.springboot.desafio_bnp_atlia.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

    Produto findByCodigoProduto(String codigoProduto);

}
