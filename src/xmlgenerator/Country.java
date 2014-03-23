/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlgenerator;

public class Country {

    String nazov;
    String rozloha;
    String pocetObyvatelov;
    String link;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public String getRozloha() {
        return rozloha;
    }

    public void setRozloha(String rozloha) {
        this.rozloha = rozloha;
    }

    public String getPocetObyvatelov() {
        return pocetObyvatelov;
    }

    public void setPocetObyvatelov(String pocetObyvatelov) {
        this.pocetObyvatelov = pocetObyvatelov;
    }

}
