/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.services;

import be.vdab.dao.BierDAO;
import be.vdab.entities.Bier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author dev13
 */
@Service
public class BierServiceImpl implements BierService {
    private final BierDAO bierDAO;
    
    @Autowired
    public BierServiceImpl(BierDAO bierDAO) {
        this.bierDAO = bierDAO;
    }

    @Override
    public Iterable<Bier> findAll() {
        return bierDAO.findAll(new Sort("naam"));
    }

    @Override
    public long findAantalBieren() {
        return bierDAO.count();
    }

    @Override
    public Bier read(long bierNr) {
        return bierDAO.findOne(bierNr);
    }
}
