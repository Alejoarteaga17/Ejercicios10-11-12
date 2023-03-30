package com.example.act456.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String marca;
    private Integer puertos;
    private Double capBateria;

    public Laptop() {
    }

    public Laptop(Long ID, String marca,  Integer puertos, Double capBateria) {
        this.ID = ID;
        this.marca = marca;
        this.puertos = puertos;
        this.capBateria = capBateria;
    }


    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }


    public Integer getPuertos() {
        return puertos;
    }

    public void setPuertos(Integer puertos) {
        this.puertos = puertos;
    }

    public Double getCapBateria() {
        return capBateria;
    }

    public void setCapBateria(Double capBateria) {
        this.capBateria = capBateria;
    }
}
