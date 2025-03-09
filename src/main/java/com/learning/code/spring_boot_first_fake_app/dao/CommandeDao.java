package com.learning.code.spring_boot_first_fake_app.dao;

import com.learning.code.spring_boot_first_fake_app.bean.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeDao extends JpaRepository<Commande, Long> {
    Commande findByRef(String ref);

    Commande deleteByRef(String ref);

    List<Commande> findByRefAndTotalGreaterThan(String ref, double total);
}
