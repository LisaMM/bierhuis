/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.entities;

import be.vdab.valueobjects.Adres;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

/**
 *
 * @author dev13
 */
public class Brouwer implements Serializable {
    private static final long serialVersionUID = 1L;
    private long brouwerNr;
    @NotNull
    @Size(min = 1, max = 50, message = "{Size.tekst}")
    private String naam;
    @Valid
    private Adres adres;
    @NumberFormat(style = Style.CURRENCY)
    @NotNull
    private BigDecimal omzet;
    private List<Bier> bieren;
    
    public Brouwer() {}
    
    public Brouwer(String naam, Adres adres, BigDecimal omzet) {
        this.naam = naam;
        this.adres = adres;
        this.omzet = omzet;
        bieren = new ArrayList<>();
    }
    
    public Brouwer(long brouwerNr, String naam, Adres adres, BigDecimal omzet) {
        this(naam, adres, omzet);
        this.brouwerNr = brouwerNr;
    }

    /**
     * @return the brouwerNr
     */
    public long getBrouwerNr() {
        return brouwerNr;
    }

    /**
     * @param brouwerNr the brouwerNr to set
     */
    public void setBrouwerNr(long brouwerNr) {
        this.brouwerNr = brouwerNr;
    }

    /**
     * @return the naam
     */
    public String getNaam() {
        return naam;
    }

    /**
     * @param naam the naam to set
     */
    public void setNaam(String naam) {
        this.naam = naam;
    }

    /**
     * @return the adres
     */
    public Adres getAdres() {
        return adres;
    }

    /**
     * @param adres the adres to set
     */
    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    /**
     * @return the omzet
     */
    public BigDecimal getOmzet() {
        return omzet;
    }

    /**
     * @param omzet the omzet to set
     */
    public void setOmzet(BigDecimal omzet) {
        this.omzet = omzet;
    }
    
    @Override
    public String toString(){
        return String.format("%s:%d", naam, brouwerNr);
    }

    /**
     * @return the bieren
     */
    public List<Bier> getBieren() {
        return bieren;
    }

    /**
     * @param bieren the bieren to set
     */
    public void setBieren(ArrayList<Bier> bieren) {
        this.bieren = bieren;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.naam);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Brouwer other = (Brouwer) obj;
        return Objects.equals(this.naam, other.naam);
    }
}
