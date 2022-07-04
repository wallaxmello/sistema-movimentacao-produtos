package br.com.springboot.sistema-movimentacao-produtos.services;

import br.com.springboot.sistema-movimentacao-produtos.models.MovimentoManual;
import br.com.springboot.sistema-movimentacao-produtos.repositories.MovimentoManualRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MovimentoManualService {

    final MovimentoManualRepository movimentoManualRepository;

    public MovimentoManualService(MovimentoManualRepository movimentoManualRepository) {
        this.movimentoManualRepository = movimentoManualRepository;
    }

    public List<MovimentoManual> findAll() {
       return movimentoManualRepository.findAll();
    }

    public Integer buscarNumeroLancamento(Integer mes, Integer ano){
        return movimentoManualRepository.buscarNumeroLancamento(mes, ano);
    }

    @Transactional
    public MovimentoManual save(MovimentoManual movimentoManual){
        return movimentoManualRepository.save(movimentoManual);
    }

}