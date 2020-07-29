package be.vdab.services;

import be.vdab.entities.Bestelbon;

/**
 *
 * @author dev13
 */
public interface BestelbonService {
    void create(Bestelbon bon);
    Bestelbon read(long bonNr);
    void update(Bestelbon bon);
}
