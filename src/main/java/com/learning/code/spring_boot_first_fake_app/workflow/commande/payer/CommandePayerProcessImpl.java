package com.learning.code.spring_boot_first_fake_app.workflow.commande.payer;

import com.learning.code.spring_boot_first_fake_app.bean.Commande;
import com.learning.code.spring_boot_first_fake_app.service.facade.CommandeService;

public class CommandePayerProcessImpl implements CommandePayerProcess {
    @Override
    public int run(String ref, double mantant) {
        Commande commande = commandeService.findByRef(ref);
        if (commande == null) {
            return -1;
        } else if (commande.getTotalePaye() + mantant > commande.getTotal()) {
            return -2;
        } else {
            double nvTotalPayer = commande.getTotalePaye() + mantant;
            commande.setTotalePaye(nvTotalPayer);
            commandeService.save(commande);
            return 1;
        }
    }

    public CommandePayerProcessImpl(CommandeService commandeService) {
        this.commandeService = commandeService;
    }
    
    private final CommandeService commandeService;
}
