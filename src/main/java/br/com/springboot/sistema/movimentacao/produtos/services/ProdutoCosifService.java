package br.com.springboot.sistema.movimentacao.produtos.services

-movimentacao-produtos.services;

import br.com.springboot.sistema-movimentacao-produtos.models.ProdutoCosif;
import br.com.springboot.sistema-movimentacao-produtos.repositories.ProdutoCosifRepository;
import br.com.springboot.sistema.movimentacao.produtos.models.ProdutoCosif;
import br.com.springboot.sistema.movimentacao.produtos.repositories.ProdutoCosifRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoCosifService {

    final ProdutoCosifRepository produtoCosifRepository;

    public ProdutoCosifService(ProdutoCosifRepository produtoCosifRepository) {
        this.produtoCosifRepository = produtoCosifRepository;
    }

    public List<ProdutoCosif> findAll() {
        return produtoCosifRepository.findAll();
    }

}