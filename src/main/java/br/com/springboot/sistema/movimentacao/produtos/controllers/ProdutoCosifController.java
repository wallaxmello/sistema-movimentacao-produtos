package br.com.springboot.sistema-movimentacao-produtos.controllers;

import br.com.springboot.sistema-movimentacao-produtos.models.ProdutoCosif;
import br.com.springboot.sistema-movimentacao-produtos.services.ProdutoCosifService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins = "*")
public class ProdutoCosifController {

    final ProdutoCosifService produtoCosifService;

    public ProdutoCosifController(ProdutoCosifService produtoCosifService) {
        this.produtoCosifService = produtoCosifService;
    }


    @GetMapping(value = "/getCodigosCosif")
    @ResponseBody
    public ResponseEntity<List<ProdutoCosif>> getCodigosCosif() {

        List<ProdutoCosif> listCodigosCosif = produtoCosifService.findAll();

        return new ResponseEntity<List<ProdutoCosif>>(listCodigosCosif, HttpStatus.OK);

    }

}
