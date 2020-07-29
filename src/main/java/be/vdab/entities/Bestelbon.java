package be.vdab.entities;

import be.vdab.valueobjects.*;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 *
 * @author dev13
 */
@Entity
@Table(name = "bestelbonnen")
public class Bestelbon implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private long bonNr;
    @NotNull
    @Size(min = 1, max = 50, message = "{Size.tekst}")
    private String naam;
    @Valid
    @Embedded
    private Adres adres;
    @ElementCollection
    @CollectionTable(name = "bestelbonlijnen", 
    	joinColumns = @JoinColumn(name = "bonNr"))
    private final Set<Bestelbonlijn> bestelbonlijnen;
    
    public Bestelbon() {
    	this.bestelbonlijnen = new LinkedHashSet<>();
    }
    
    public Bestelbon(String naam, Adres adres) {
        this.naam = naam;
        this.adres = adres;
        this.bestelbonlijnen = new LinkedHashSet<>();
    }
    
    public Bestelbon(long bonNr, String naam, Adres adres) {
     this(naam, adres);
     this.bonNr = bonNr;
    }

    /**
     * @return the bonNr
     */
    public long getBonNr() {
        return bonNr;
    }

    /**
     * @param bonNr the bonNr to set
     */
    public void setBonNr(long bonNr) {
        this.bonNr = bonNr;
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
     * @return the bestelbonlijnen
     */
    public Set<Bestelbonlijn> getBestelbonlijnen() {
        return bestelbonlijnen;
    }
    
    public void addBestelbonlijn(Bestelbonlijn lijn) {
    	bestelbonlijnen.add(lijn);
    }
    
    public void removeBestelbonlijn(Bestelbonlijn lijn) {
		bestelbonlijnen.remove(lijn);
    }
    
    @Override
    public String toString(){
        return String.format("%s:%d", naam, bonNr);
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Bestelbon other = (Bestelbon) obj;
        return Objects.equals(this.naam, other.naam);
    }
}
