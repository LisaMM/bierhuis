/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.valueobjects;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.*;

import be.vdab.entities.*;
/**
 *
 * @author dev13
 */
@Embeddable
public class Bestelbonlijn implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotNull
    @Min(1)
    private int aantal;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "biernr")
    private Bier bier;
    @ManyToOne(fetch = FetchType.LAZY)
    private Bestelbon bestelbon;
    
    public Bestelbonlijn() {}
    
    public Bestelbonlijn(int aantal, Bier bier, Bestelbon bestelbon) {
        this.aantal = aantal;
        this.bier = bier;
        this.bestelbon = bestelbon;
    }

    /**
     * @return the aantal
     */
    public int getAantal() {
        return aantal;
    }

	public Bier getBier() {
		return bier;
	}

	public Bestelbon getBestelbon() {
		return bestelbon;
	}
	
	public void setBier(Bier bier) {
		this.bier = bier;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + aantal;
		result = prime * result
				+ ((bestelbon == null) ? 0 : bestelbon.hashCode());
		result = prime * result + ((bier == null) ? 0 : bier.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bestelbonlijn other = (Bestelbonlijn) obj;
		if (aantal != other.aantal)
			return false;
		if (bestelbon == null) {
			if (other.bestelbon != null)
				return false;
		} else if (!bestelbon.equals(other.bestelbon))
			return false;
		if (bier == null) {
			if (other.bier != null)
				return false;
		} else if (!bier.equals(other.bier))
			return false;
		return true;
	}
}
