/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
