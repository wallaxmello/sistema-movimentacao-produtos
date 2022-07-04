package br.com.springboot.sistema-movimentacao-produtos.repositories;

import br.com.springboot.sistema-movimentacao-produtos.models.MovimentoManual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimentoManualRepository extends JpaRepository<MovimentoManual, Long> {

    @Query(value = "SELECT ISNULL(MAX(m.num_lancamento), 0) FROM movimento_manual m WHERE m.dat_mes = ?1 AND m.dat_ano = ?2", nativeQuery = true)
    Integer buscarNumeroLancamento(Integer mes, Integer ano);

}
