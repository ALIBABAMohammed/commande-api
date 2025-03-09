package com.learning.code.spring_boot_first_fake_app.service.facade;

import com.learning.code.spring_boot_first_fake_app.bean.Commande;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CommandeService {

    Commande findByRef(String ref);

    @Transactional
    Commande deleteByRef(String ref);

    List<Commande> findByRefAndTotalGreaterThan(String ref, double total);

    @Deprecated
    Commande getById(Long aLong);

    List<Commande> findAll();

    int save(Commande commande);

    Commande update(Commande commande);
}
