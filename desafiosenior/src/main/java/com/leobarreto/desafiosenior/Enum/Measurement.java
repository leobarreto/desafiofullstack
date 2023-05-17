package com.leobarreto.desafiosenior.Enum;

public enum Measurement {

    KG("Quilograma"),
    LT("Litro"),
    UN("Unidade");

    private String desc;

    Measurement(final String desc) {
        this.desc = desc;
    }

    public String getDescription() {
        return this.desc;
    }
}
