package br.com.zup.handora.umparamuitos1exemplo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.handora.umparamuitos1exemplo.repositories.ProdutoRepository;

@RestController
@RequestMapping(ProdutoController.BASE_URI)
public class ProdutoController {

    public final static String BASE_URI = "/produtos";

    private final ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

}
