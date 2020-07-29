package be.vdab.services;

import be.vdab.entities.Bier;

/**
 *
 * @author dev13
 */
public interface BierService {
    Bier read(long bierNr);
    Iterable<Bier> findAll();
    long findAantalBieren();
    Iterable<Bier> findByBrouwerNrLike(long brouwerNr);
}
