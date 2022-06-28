package br.com.springboot.desafio_bnp_atlia.controllers;

import br.com.springboot.desafio_bnp_atlia.models.Produto;
import br.com.springboot.desafio_bnp_atlia.services.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins = "*")
public class ProdutoController {

    final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping(value = "/getProdutos")
    @ResponseBody
    public ResponseEntity<List<Produto>> getProdutos() {

        List<Produto> listProdutos = produtoService.findAll();

        return new ResponseEntity<List<Produto>>(listProdutos, HttpStatus.OK);

    }

}
