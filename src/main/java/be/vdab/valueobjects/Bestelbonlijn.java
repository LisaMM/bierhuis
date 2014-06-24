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
    @JoinColumn(name = "bonnr")
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
}
