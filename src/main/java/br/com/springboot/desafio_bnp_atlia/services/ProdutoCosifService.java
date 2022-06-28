package br.com.springboot.desafio_bnp_atlia.services;

import br.com.springboot.desafio_bnp_atlia.models.ProdutoCosif;
import br.com.springboot.desafio_bnp_atlia.repositories.ProdutoCosifRepository;
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