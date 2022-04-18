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

import br.com.zup.handora.umparamuitos1exemplo.models.Contato;
import br.com.zup.handora.umparamuitos1exemplo.models.Telefone;
import br.com.zup.handora.umparamuitos1exemplo.models.TelefoneDTO;
import br.com.zup.handora.umparamuitos1exemplo.repositories.ContatoRepository;

@RestController
@RequestMapping(ContatoController.BASE_URI + "/{contatoId}" + TelefoneController.BASE_URI)
public class TelefoneController {

    public final static String BASE_URI = "/telefones";

    private final ContatoRepository contatoRepository;

    public TelefoneController(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }

    @Transactional
    @PostMapping
    public ResponseEntity<Void> telefoneCreate(@PathVariable Long contatoId,
                                               @RequestBody @Valid TelefoneDTO telefoneDTO,
                                               UriComponentsBuilder uriComponentsBuilder) {
        Contato contato = contatoRepository.findById(contatoId)
                                           .orElseThrow(
                                               () -> new ResponseStatusException(
                                                   HttpStatus.NOT_FOUND,
                                                   "Não existe um contato com o id informado."
                                               )
                                           );

        Telefone telefone = telefoneDTO.toModel();
        contato.adicionar(telefone);

        contatoRepository.flush(); // Força a geração do ID do telefone no banco de dados

        URI location = uriComponentsBuilder.path(
            BASE_URI + "/{contatoId}" + TelefoneController.BASE_URI + "/{id}"
        ).buildAndExpand(contatoId, telefone.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long contatoId, @PathVariable Long id) {
        Contato contato = contatoRepository.findById(contatoId)
                                           .orElseThrow(
                                               () -> new ResponseStatusException(
                                                   HttpStatus.NOT_FOUND,
                                                   "Não existe um contato com o id informado."
                                               )
                                           );

        contato.remover(new Telefone(id));

        return ResponseEntity.noContent().build();
    }

}
