package org.java.lessons.spring_la_mia_pizzeria_crud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "Pizze")
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name can not be null, empty or blank ")
    @Size(max = 50, message = "Il testo per il nome può essere massimo di 50 caratteri")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Name can not be null, empty or blank ")
    @Size(max = 100, message = "Il testo per la descrizione può essere massimo di 100 caratteri")
    @Column(name = "description")
    private String description;

    @NotBlank(message = "Name can not be null, empty or blank ")
    @Column(name = "image")
    private String image;

    @NotNull
    @DecimalMin(value = "0.5", message = "Il costo minimo della pizza non può essere inferiore a 0.50€")
    private BigDecimal price;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s €", this.name, this.description, this.price);
    }

}
