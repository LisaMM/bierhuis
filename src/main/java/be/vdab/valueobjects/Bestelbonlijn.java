/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.valueobjects;

import be.vdab.entities.Bier;
import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 *
 * @author dev13
 */
public class Bestelbonlijn implements Serializable {
    private static final long serialVersionUID = 1L;
    private Bier bier;
    @NotNull
    @Min(1)
    private int aantal;
    
    public Bestelbonlijn() {}
    
    public Bestelbonlijn(Bier bier, int aantal) {
        this.bier = bier;
        this.aantal = aantal;
    }

    /**
     * @return the bier
     */
    public Bier getBier() {
        return bier;
    }

    /**
     * @return the aantal
     */
    public int getAantal() {
        return aantal;
    }
    
    @Override
    public String toString() {
        return String.format("%s:%d", bier, aantal);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.bier);
        hash = 43 * hash + this.aantal;
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
        final Bestelbonlijn other = (Bestelbonlijn) obj;
        if (!Objects.equals(this.bier, other.bier)) {
            return false;
        }
        return this.aantal == other.aantal;
    }
    
    
}
