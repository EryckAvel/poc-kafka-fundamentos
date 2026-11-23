package com.eryckavel.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TransferenciaService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    private static final Logger log = LoggerFactory.getLogger(TransferenciaService.class);

    public TransferenciaService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public String transferir(String contaOrigem, Double valor) {
        String mensagem = "Conta " + contaOrigem + " enviou R$ " + valor;
        kafkaTemplate.send("transferencias", contaOrigem, mensagem);
        log.info("Transferencia enviado com sucesso");
        return mensagem;
    }

}
