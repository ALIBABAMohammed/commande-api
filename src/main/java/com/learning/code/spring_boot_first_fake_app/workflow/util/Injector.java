package com.learning.code.spring_boot_first_fake_app.workflow.util;

import com.learning.code.spring_boot_first_fake_app.service.facade.CommandeService;
import com.learning.code.spring_boot_first_fake_app.workflow.commande.payer.CommandePayerProcess;
import com.learning.code.spring_boot_first_fake_app.workflow.commande.payer.CommandePayerProcessImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Injector {

    @Bean
    public CommandePayerProcess commandePayerProcess(CommandeService commandeService){
        return new CommandePayerProcessImpl(commandeService);
    }
}
