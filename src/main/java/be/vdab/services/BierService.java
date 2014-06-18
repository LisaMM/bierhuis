/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
