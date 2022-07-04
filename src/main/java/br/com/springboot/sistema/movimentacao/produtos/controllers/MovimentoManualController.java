package br.com.springboot.sistema.movimentacao.produtos.controllers

-movimentacao-produtos.controllers;

import br.com.springboot.sistema-movimentacao-produtos.models.MovimentoManual;
import br.com.springboot.sistema-movimentacao-produtos.dtos.MovimentoManualDTO;
import br.com.springboot.sistema-movimentacao-produtos.services.MovimentoManualService;
import br.com.springboot.sistema-movimentacao-produtos.services.ProdutoService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins = "*")
public class MovimentoManualController {

    final MovimentoManualService movimentoManualService;
    final ProdutoService produtoService;

    public MovimentoManualController(MovimentoManualService movimentoManualService, ProdutoService produtoService) {
        this.movimentoManualService = movimentoManualService;
        this.produtoService = produtoService;
    }

    @GetMapping(value = "/getMovimentosManuais")
    @ResponseBody
    public ResponseEntity<List<MovimentoManual>> getMovimentosManuais() {

        List<MovimentoManual> listMovimentosManuais = movimentoManualService.findAll();

        listMovimentosManuais.forEach(lm ->
            lm.setDescricaoProduto(produtoService.findByCodigoProduto(lm.getCodigoProduto()).getDescricaoProduto())
        );

        return new ResponseEntity<List<MovimentoManual>>(listMovimentosManuais, HttpStatus.OK);

    }

    @PostMapping(value = "/salvarDados")
    @ResponseBody
    public ResponseEntity<MovimentoManual> salvarDados(@RequestBody MovimentoManualDTO movimentoManualDTO) {

        MovimentoManual movimentoManual = new MovimentoManual();

        BeanUtils.copyProperties(movimentoManualDTO, movimentoManual);

        java.util.Date utilDate = new java.util.Date();
        Timestamp data = new Timestamp(utilDate.getTime());

        movimentoManual.setDataMovimento(data);
        movimentoManual.setCodigoUsuario("TESTE");

        Integer numeroLancamento = movimentoManualService.buscarNumeroLancamento(movimentoManual.getDataMes(), movimentoManual.getDataAno());

        movimentoManual.setNumeroLancamento(numeroLancamento + 1);

        MovimentoManual responseMovimentoManual = movimentoManualService.save(movimentoManual);

        return new ResponseEntity<MovimentoManual>(responseMovimentoManual, HttpStatus.OK);

    }

}
