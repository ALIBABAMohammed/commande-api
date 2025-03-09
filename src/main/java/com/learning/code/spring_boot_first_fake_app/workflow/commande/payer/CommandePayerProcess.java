package com.learning.code.spring_boot_first_fake_app.workflow.commande.payer;

import com.learning.code.spring_boot_first_fake_app.bean.Commande;

public interface CommandePayerProcess {

    public int run(String ref, double montant);
}
