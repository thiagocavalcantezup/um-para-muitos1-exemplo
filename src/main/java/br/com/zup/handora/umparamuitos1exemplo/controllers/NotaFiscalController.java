package br.com.zup.handora.umparamuitos1exemplo.controllers;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.handora.umparamuitos1exemplo.models.NotaFiscal;
import br.com.zup.handora.umparamuitos1exemplo.models.NotaFiscalDTO;
import br.com.zup.handora.umparamuitos1exemplo.repositories.NotaFiscalRepository;

@RestController
@RequestMapping(NotaFiscalController.BASE_URI)
public class NotaFiscalController {

    public final static String BASE_URI = "/notas-fiscais";

    private final NotaFiscalRepository notaFiscalRepository;

    public NotaFiscalController(NotaFiscalRepository notaFiscalRepository) {
        this.notaFiscalRepository = notaFiscalRepository;
    }

    @Transactional
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid NotaFiscalDTO notaFiscalDTO,
                                       UriComponentsBuilder uriComponentsBuilder) {
        NotaFiscal notaFiscal = notaFiscalRepository.save(notaFiscalDTO.toModel());

        URI location = uriComponentsBuilder.path(NotaFiscalController.BASE_URI + "/{id}")
                                           .buildAndExpand(notaFiscal.getId())
                                           .toUri();

        return ResponseEntity.created(location).build();
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        NotaFiscal notaFiscal = notaFiscalRepository.findById(id)
                                                    .orElseThrow(
                                                        () -> new ResponseStatusException(
                                                            HttpStatus.NOT_FOUND,
                                                            "Não existe uma nota fiscal com o id informado."
                                                        )
                                                    );

        notaFiscalRepository.delete(notaFiscal);

        return ResponseEntity.noContent().build();
    }

}
