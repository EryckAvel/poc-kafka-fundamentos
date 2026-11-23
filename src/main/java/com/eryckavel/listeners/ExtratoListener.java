package com.eryckavel.listeners;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ExtratoListener {

    private static final Logger log = LoggerFactory.getLogger(ExtratoListener.class);

    @KafkaListener(topics = "transferencias", groupId = "extrato")
    public void ouvir(ConsumerRecord<String, String> record){
        String mensagem = String.format("[EXTRATO] partição=%s offset=%s chave=%s msg=%s", record.partition(), record.offset(), record.key(), record.value());
        log.info(mensagem);
    }

}
