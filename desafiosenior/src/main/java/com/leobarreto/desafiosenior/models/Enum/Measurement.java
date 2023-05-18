package com.leobarreto.desafiosenior.models.Enum;

public enum Measurement {

    KG(1, "Quilograma"),
    LT(2, "Litro"),
    UN(3, "Unidade");

    private final String desc;

    Measurement(int i, final String desc) {
        this.desc = desc;
    }

    public String getDescription() {
        return this.desc;
    }
}
