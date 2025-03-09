package com.learning.code.spring_boot_first_fake_app.service.impl;

import com.learning.code.spring_boot_first_fake_app.bean.Commande;
import com.learning.code.spring_boot_first_fake_app.dao.CommandeDao;
import com.learning.code.spring_boot_first_fake_app.service.facade.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommandeServiceImpl implements CommandeService {
    @Override
    public Commande findByRef(String ref) {
        return commandeDao.findByRef(ref);
    }

    @Override
    @Transactional
    public Commande deleteByRef(String ref) {
        return commandeDao.deleteByRef(ref);
    }

    @Override
    public List<Commande> findByRefAndTotalGreaterThan(String ref, double total) {
        return commandeDao.findByRefAndTotalGreaterThan(ref, total);
    }

    @Override
    @Deprecated
    public Commande getById(Long aLong) {
        return commandeDao.getById(aLong);
    }

    @Override
    public List<Commande> findAll() {
        return commandeDao.findAll();
    }

    @Override
    public int save(Commande commande) {
        if (findByRef(commande.getRef()) != null) {
            return -1;
        } else if (commande.getTotal() < commande.getTotalePaye()) {
            return -2;
        } else {
            commandeDao.save(commande);
            return 1;
        }
    }
    @Override
     public Commande update(Commande commande) {
        return commandeDao.save(commande);
     }

    @Autowired
    private CommandeDao commandeDao;

}
