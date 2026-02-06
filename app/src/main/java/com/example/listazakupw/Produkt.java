package com.example.listazakupw;

public class Produkt {
    private String nazwaProduktu;
    private Boolean czyZakupiono;

    public Produkt(String nazwaProduktu) {
        this.nazwaProduktu = nazwaProduktu;
        czyZakupiono = false;
    }

    @Override
    public String toString() {
        return nazwaProduktu;
    }

    public String getNazwaProduktu() {
        return nazwaProduktu;
    }

    public void setNazwaProduktu(String nazwaProduktu) {
        this.nazwaProduktu = nazwaProduktu;
    }

    public Boolean getCzyZakupiono() {
        return czyZakupiono;
    }

    public void setCzyZakupiono(Boolean czyZakupiono) {
        this.czyZakupiono = czyZakupiono;
    }
}
