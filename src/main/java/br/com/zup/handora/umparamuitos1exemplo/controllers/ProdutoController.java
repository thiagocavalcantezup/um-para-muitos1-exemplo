package br.com.zup.handora.umparamuitos1exemplo.controllers;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.handora.umparamuitos1exemplo.models.Produto;
import br.com.zup.handora.umparamuitos1exemplo.models.ProdutoDTO;
import br.com.zup.handora.umparamuitos1exemplo.repositories.ProdutoRepository;

@RestController
@RequestMapping(ProdutoController.BASE_URI)
public class ProdutoController {

    public final static String BASE_URI = "/produtos";

    private final ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Transactional
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid ProdutoDTO produtoDTO,
                                       UriComponentsBuilder uriComponentsBuilder) {
        Produto produto = produtoRepository.save(produtoDTO.toModel());

        URI location = uriComponentsBuilder.path(ProdutoController.BASE_URI + "/{id}")
                                           .buildAndExpand(produto.getId())
                                           .toUri();

        return ResponseEntity.created(location).build();
    }

}
