/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.valueobjects;

import be.vdab.constraints.Postcode;
import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 *
 * @author dev13
 */
public class Adres implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotNull
    @Size(min = 1, max = 50, message = "{Size.tekst}")
    private String straat;
    @NotNull
    @Size(min = 1, max = 50, message = "{Size.tekst}")
    private String huisNr;
    @NotNull
    @Postcode
    private Integer postcode;
    @NotNull
    @Size(min = 1, max = 50, message = "{Size.tekst}")
    private String gemeente;
    
    protected Adres() {}

    public Adres(String straat,String huisNr,Integer postcode,String gemeente) {
        this.straat = straat;
        this.huisNr = huisNr;
        this.postcode = postcode;
        this.gemeente = gemeente;
    }
    // Je maakt zelf getters voor straat, huisNr, postcode en gemeente
    @Override
    public String toString() {
        return String.format("%s %s %d %s", straat, huisNr, postcode, gemeente);
    }

    /**
     * @return the straat
     */
    public String getStraat() {
        return straat;
    }

    /**
     * @return the huisNr
     */
    public String getHuisNr() {
        return huisNr;
    }

    /**
     * @return the postcode
     */
    public Integer getPostcode() {
        return postcode;
    }

    /**
     * @return the gemeente
     */
    public String getGemeente() {
        return gemeente;
    }

    /**
     * @param straat the straat to set
     */
    protected void setStraat(String straat) {
        this.straat = straat;
    }

    /**
     * @param huisNr the huisNr to set
     */
    protected void setHuisNr(String huisNr) {
        this.huisNr = huisNr;
    }

    /**
     * @param postcode the postcode to set
     */
    protected void setPostcode(Integer postcode) {
        this.postcode = postcode;
    }

    /**
     * @param gemeente the gemeente to set
     */
    protected void setGemeente(String gemeente) {
        this.gemeente = gemeente;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Adres other = (Adres) obj;
        if (!Objects.equals(this.straat, other.straat)) {
            return false;
        }
        if (!Objects.equals(this.huisNr, other.huisNr)) {
            return false;
        }
        if (!Objects.equals(this.postcode, other.postcode)) {
            return false;
        }
        return Objects.equals(this.gemeente, other.gemeente);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.straat);
        hash = 19 * hash + Objects.hashCode(this.huisNr);
        hash = 19 * hash + Objects.hashCode(this.postcode);
        hash = 19 * hash + Objects.hashCode(this.gemeente);
        return hash;
    }
}
