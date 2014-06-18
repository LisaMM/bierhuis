/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

/**
 *
 * @author dev13
 */
@Entity
@Table(name = "bieren")
public class Bier implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private long bierNr;
    @NotNull
    @Size(min = 1, max = 50, message = "{Size.tekst}")
    private String naam;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "brouwerNr")
    private Brouwer brouwer;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "soortNr")
    private Soort soort;
    @NumberFormat(style = Style.PERCENT)
    @NotNull
    private BigDecimal alcohol;
    @NumberFormat(style = Style.CURRENCY)
    @NotNull
    private BigDecimal prijs;
    
    public Bier() {}

    public Bier(String naam, Brouwer brouwer, Soort soort,
            BigDecimal alcohol, BigDecimal prijs) {
        this.naam = naam;
        this.brouwer = brouwer;
        this.soort = soort;
        this.alcohol = alcohol;
        this.prijs = prijs;
    }
    
    public Bier(long bierNr, String naam, Brouwer brouwer, Soort soort,
            BigDecimal alcohol, BigDecimal prijs) {
        this(naam, brouwer, soort, alcohol, prijs);
        this.bierNr = bierNr;
    }
    /**
     * @return the bierNr
     */
    public long getBierNr() {
        return bierNr;
    }

    /**
     * @param bierNr the bierNr to set
     */
    public void setBierNr(long bierNr) {
        this.bierNr = bierNr;
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
     * @return the brouwer
     */
    public Brouwer getBrouwer() {
        return brouwer;
    }

    /**
     * @param brouwer the brouwer to set
     */
    public void setBrouwer(Brouwer brouwer) {
    	if (this.brouwer != null && this.brouwer.getBieren().contains(this)) {
    		this.brouwer.removeBier(this);
    	}
        this.brouwer = brouwer;
        if (brouwer != null && ! brouwer.getBieren().contains(this)) {
        	brouwer.addBier(this);
        }
    }

    /**
     * @return the soort
     */
    public Soort getSoort() {
        return soort;
    }

    /**
     * @param soort the soort to set
     */
    public void setSoort(Soort soort) {
    	if (this.soort != null && this.soort.getBieren().contains(this)) {
    		this.soort.removeBier(this);
    	}
        this.soort = soort;
        if (soort != null && ! soort.getBieren().contains(this)) {
        	soort.addBier(this);
        }
    }

    /**
     * @return the alcohol
     */
    public BigDecimal getAlcohol() {
        return alcohol;
    }

    /**
     * @param alcohol the alcohol to set
     */
    public void setAlcohol(BigDecimal alcohol) {
        this.alcohol = alcohol;
    }

    /**
     * @return the prijs
     */
    public BigDecimal getPrijs() {
        return prijs;
    }

    /**
     * @param prijs the prijs to set
     */
    public void setPrijs(BigDecimal prijs) {
        this.prijs = prijs;
    }
    
    @Override
    public String toString(){
        return String.format("%s:%d", bierNr, naam);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.naam);
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
        final Bier other = (Bier) obj;
        return Objects.equals(this.naam, other.naam);
    }
}
