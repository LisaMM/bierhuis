package be.vdab.entities;

import be.vdab.valueobjects.Adres;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

/**
 *
 * @author dev13
 */
@Entity
@Table(name = "brouwers")
public class Brouwer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private long brouwernr;
    @NotNull
    @Size(min = 1, max = 50, message = "{Size.tekst}")
    private String naam;
    @Valid
    @Embedded
    private Adres adres;
    @NumberFormat(style = Style.CURRENCY)
    @NotNull
    private BigDecimal omzet;
    @OneToMany(mappedBy = "brouwer")
    private Set<Bier> bieren;
    
    public Brouwer() {}
    
    public Brouwer(String naam, Adres adres, BigDecimal omzet) {
        this.naam = naam;
        this.adres = adres;
        this.omzet = omzet;
        this.bieren = new LinkedHashSet<>();
    }
    
    public Brouwer(long brouwerNr, String naam, Adres adres, BigDecimal omzet) {
        this(naam, adres, omzet);
        this.brouwernr = brouwerNr;
    }

    /**
     * @return the brouwerNr
     */
    public long getBrouwerNr() {
        return brouwernr;
    }

    /**
     * @param brouwerNr the brouwerNr to set
     */
    public void setBrouwerNr(long brouwerNr) {
        this.brouwernr = brouwerNr;
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
        return String.format("%s:%d", naam, brouwernr);
    }

    /**
     * @return the bieren
     */
    public Set<Bier> getBieren() {
        return Collections.unmodifiableSet(bieren);
    }
    
    public void addBier(Bier bier) {
    	bieren.add(bier);
    	if (bier.getBrouwer() != this) {
    		bier.setBrouwer(this);
    	}
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

	public void removeBier(Bier bier) {
		if (bier.getBrouwer() == this) {
    		bieren.remove(bier);
    		bier.setBrouwer(null);
    	}
	}
}
