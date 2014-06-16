package be.vdab.services;

import be.vdab.entities.Brouwer;

public interface BrouwerService {
    Brouwer read(long brouwerNr);
    Iterable<Brouwer> findAll();
}
