package br.com.zup.handora.umparamuitos1exemplo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.handora.umparamuitos1exemplo.repositories.NotaFiscalRepository;

@RestController
@RequestMapping(NotaFiscalController.BASE_URI)
public class NotaFiscalController {

    public final static String BASE_URI = "/notas-fiscais";

    private final NotaFiscalRepository notaFiscalRepository;

    public NotaFiscalController(NotaFiscalRepository notaFiscalRepository) {
        this.notaFiscalRepository = notaFiscalRepository;
    }

}
