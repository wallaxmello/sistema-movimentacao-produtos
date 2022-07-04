package br.com.springboot.sistema.movimentacao.produtos.repositories;

import br.com.springboot.sistema.movimentacao.produtos.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

    Produto findByCodigoProduto(String codigoProduto);

}
