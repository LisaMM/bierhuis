/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.services;

import be.vdab.dao.BestelbonDAO;
import be.vdab.entities.Bestelbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;

/**
 *
 * @author dev13
 */
@Service
@Transactional(readOnly = true,isolation = Isolation.READ_COMMITTED)
public class BestelbonServiceImpl implements BestelbonService {
    private final BestelbonDAO bestelbonDAO;
    
    @Autowired
    public BestelbonServiceImpl(BestelbonDAO bestelbonDAO) {
        this.bestelbonDAO = bestelbonDAO;
    }

    @Override
    @Transactional(readOnly = false)
    public void create(Bestelbon bon) {
        try {
            bestelbonDAO.save(bon);
        } catch (DataIntegrityViolationException ex) {
            throw ex;
        }
    }

    @Override
    public Bestelbon read(long bonNr) {
        return bestelbonDAO.findOne(bonNr);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(Bestelbon bon) {
        bestelbonDAO.save(bon);
    }
}
