package br.com.springboot.sistema-movimentacao-produtos.services;

import br.com.springboot.sistema-movimentacao-produtos.models.Produto;
import br.com.springboot.sistema-movimentacao-produtos.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Produto findByCodigoProduto(String codigoProduto){
        return produtoRepository.findByCodigoProduto(codigoProduto);
    }

}