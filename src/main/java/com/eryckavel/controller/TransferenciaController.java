package com.eryckavel.controller;

import com.eryckavel.service.TransferenciaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/transferencia")
public class TransferenciaController {

    private final TransferenciaService transferenciaService;

    public TransferenciaController(TransferenciaService transferenciaService) {
        this.transferenciaService = transferenciaService;
    }

    @PostMapping()
    public ResponseEntity<String> transferir() {
        long contaOrigem = ThreadLocalRandom.current().nextLong(1, 6);
        String resultado = transferenciaService.transferir(String.valueOf(contaOrigem), 1000.0);
        return ResponseEntity.ok(resultado);
    }

}
