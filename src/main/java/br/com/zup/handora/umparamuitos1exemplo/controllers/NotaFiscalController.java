package br.com.zup.handora.umparamuitos1exemplo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(NotaFiscalController.BASE_URI)
public class NotaFiscalController {

    public final static String BASE_URI = "/notas-fiscais";

}
