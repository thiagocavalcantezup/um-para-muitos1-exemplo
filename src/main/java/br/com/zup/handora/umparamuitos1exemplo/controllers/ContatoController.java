package br.com.zup.handora.umparamuitos1exemplo.controllers;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.handora.umparamuitos1exemplo.models.Contato;
import br.com.zup.handora.umparamuitos1exemplo.models.ContatoDTO;
import br.com.zup.handora.umparamuitos1exemplo.models.ContatoPatchDTO;
import br.com.zup.handora.umparamuitos1exemplo.repositories.ContatoRepository;

@RestController
@RequestMapping(ContatoController.BASE_URI)
public class ContatoController {

    public final static String BASE_URI = "/contatos";

    private final ContatoRepository contatoRepository;

    public ContatoController(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }

    @Transactional
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid ContatoDTO contatoDTO,
                                       UriComponentsBuilder uriComponentsBuilder) {

        Contato contato = contatoRepository.save(contatoDTO.toModel());

        URI location = uriComponentsBuilder.path(BASE_URI + "/{id}")
                                           .buildAndExpand(contato.getId())
                                           .toUri();

        return ResponseEntity.created(location).build();
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Contato contato = contatoRepository.findById(id)
                                           .orElseThrow(
                                               () -> new ResponseStatusException(
                                                   HttpStatus.NOT_FOUND,
                                                   "N??o existe um contato com o id informado."
                                               )
                                           );

        if (contato.isAtivo()) {
            throw new ResponseStatusException(
                HttpStatus.UNPROCESSABLE_ENTITY, "Imposs??vel remover um contato ativo."
            );
        }

        contatoRepository.delete(contato);

        return ResponseEntity.noContent().build();
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id,
                                       @RequestBody @Valid ContatoPatchDTO contatoPatchDTO) {
        Contato contato = contatoRepository.findById(id)
                                           .orElseThrow(
                                               () -> new ResponseStatusException(
                                                   HttpStatus.NOT_FOUND,
                                                   "N??o existe um contato com o id informado."
                                               )
                                           );

        if (!contato.isAtivo()) {
            throw new ResponseStatusException(
                HttpStatus.UNPROCESSABLE_ENTITY, "Imposs??vel atualizar um contato inativo."
            );
        }

        contato.atualizar(contatoPatchDTO.getNome(), contatoPatchDTO.getEmpresa());
        contatoRepository.save(contato);

        return ResponseEntity.noContent().build();
    }

}
