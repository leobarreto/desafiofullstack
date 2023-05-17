package com.leobarreto.desafiosenior.models;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;

import com.leobarreto.desafiosenior.Enum.Measurement;

@Entity
@Table(name = Items.TABLE_NAME)
public class Items {
    public static final String TABLE_NAME = "items";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "name",nullable = false)
    @NotNull
    @NotEmpty
    private String name;

    @Column(name = "unit_measure", nullable = false)
    @NotNull
    @NotEmpty
    private Measurement unitOfMeasure;

    @Column(name = "amount")
    private Float amount;

    @Column(name = "price", nullable = false)
    @NotNull
    @NotEmpty
    private Float price;

    @Column(name = "perishable_item", nullable = false)
    @NotNull
    @NotEmpty
    private Boolean perishableItem;

    @Column(name = "expiration_dt", nullable = false)
    @NotNull
    @NotEmpty
    private LocalTime expirationDT;

    @Column(name = "manufactor_dt", nullable = false)
    @NotNull
    @NotEmpty
    private LocalTime manufactorDT;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Measurement getUnitOfMeasure() {
        return this.unitOfMeasure;
    }

    public void setUnitOfMeasure(Measurement unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public Float getAmount() {
        return this.amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Float getPrice() {
        return this.price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Boolean isPerishableItem() {
        return this.perishableItem;
    }

    public Boolean getPerishableItem() {
        return this.perishableItem;
    }

    public void setPerishableItem(Boolean perishableItem) {
        this.perishableItem = perishableItem;
    }

    public LocalTime getExpirationDT() {
        return this.expirationDT;
    }

    public void setExpirationDT(LocalTime expirationDT) {
        this.expirationDT = expirationDT;
    }

    public LocalTime getManufactorDT() {
        return this.manufactorDT;
    }

    public void setManufactorDT(LocalTime manufactorDT) {
        this.manufactorDT = manufactorDT;
    }

}
