
package be.vdab.valueobjects;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.*;

import be.vdab.entities.*;

/**
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

    public Bestelbonlijn() {
    }

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
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (getClass() != obj.getClass()) {
            return false;
        }
        Bestelbonlijn other = (Bestelbonlijn) obj;
        if (aantal != other.aantal) {
            return false;
        } else if (bestelbon == null) {
            if (other.bestelbon != null) {
                return false;
            }
        } else if (!bestelbon.equals(other.bestelbon)) {
            return false;
        }
        if (bier == null) {
            return other.bier == null;
        } else {
            return bier.equals(other.bier);
        }
    }
}
