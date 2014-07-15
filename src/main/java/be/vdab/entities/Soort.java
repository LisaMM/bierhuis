package be.vdab.entities;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "soorten")
public class Soort implements Serializable {
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private long soortNr;
    @NotNull
    @Size(min = 1, max = 50, message = "{Size.tekst}")
    private String naam;
	@OneToMany(mappedBy = "soort")
    private Set<Bier> bieren;
	
	public Soort() {}
	
	public Soort(String naam) {
		this.setNaam(naam);
		this.bieren = new LinkedHashSet<>();
	}
	
	public Soort(long soortNr, String naam) {
		this(naam);
		this.setSoortNr(soortNr);
	}
	
	/**
     * @return the bieren
     */
    public Set<Bier> getBieren() {
        return Collections.unmodifiableSet(bieren);
    }
    
    public void addBier(Bier bier) {
    	bieren.add(bier);
    	if (bier.getSoort() != this) {
    		bier.setSoort(this);
    	}
    }
    
    public void removeBier(Bier bier) {
    	if (bier.getSoort() == this) {
    		bieren.remove(bier);
    		bier.setSoort(null);
    	}
    }

	public long getSoortNr() {
		return soortNr;
	}

	public void setSoortNr(long soortNr) {
		this.soortNr = soortNr;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}
}
