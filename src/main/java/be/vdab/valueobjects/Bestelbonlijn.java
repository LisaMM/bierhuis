/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.valueobjects;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
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
    
    public Bestelbonlijn() {}
    
    public Bestelbonlijn(int aantal) {
        this.aantal = aantal;
    }

    /**
     * @return the aantal
     */
    public int getAantal() {
        return aantal;
    }
}
