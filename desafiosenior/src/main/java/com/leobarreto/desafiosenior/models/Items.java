package com.leobarreto.desafiosenior.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.leobarreto.desafiosenior.models.Enum.Measurement;

@Entity
@Table(name = Items.TABLE_NAME)
public class Items {
    public static final String TABLE_NAME = "itens";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "nome_item",nullable = false)
    @NotNull
    @NotEmpty
    private String nomeItem;

    @Column(name = "unidade_medida", nullable = false)
    @NotNull
    private Measurement unidadeMedida;

    @Column(name = "qt_item")
    private Float qtItem;

    @Column(name = "valor_item", nullable = false)
    @NotNull
    private Float valorItem;

    @Column(name = "perecivel")
    private Boolean perecivel;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "dt_validade")
    private LocalDateTime dtValidade;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "dt_fabricacao", nullable = false)
    @NotNull
    private LocalDateTime dtFabricacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public Measurement getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(Measurement unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public Float getQtItem() {
        return qtItem;
    }

    public void setQtItem(Float qtItem) {
        this.qtItem = qtItem;
    }

    public Float getValorItem() {
        return valorItem;
    }

    public void setValorItem(Float valorItem) {
        this.valorItem = valorItem;
    }

    public Boolean getPerecivel() {
        return perecivel;
    }

    public void setPerecivel(Boolean perecivel) {
        this.perecivel = perecivel;
    }

    public LocalDateTime getDtValidade() {
        return dtValidade;
    }

    public void setDtValidade(LocalDateTime dtValidade) {
        this.dtValidade = dtValidade;
    }

    public LocalDateTime getDtFabricacao() {
        return dtFabricacao;
    }

    public void setDtFabricacao(LocalDateTime dtFabricacao) {
        this.dtFabricacao = dtFabricacao;
    }
}
