package com.learning.code.spring_boot_first_fake_app.bean;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//GeneratedValue sa veu dire que on doit generer un Long
    private Long id;
    private String ref;
    private double total;
    private double totalePaye;

    public double getTotalePaye() {
        return totalePaye;
    }

    public void setTotalePaye(double totalePaye) {
        this.totalePaye = totalePaye;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
