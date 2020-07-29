package be.vdab.services;

import be.vdab.dao.BestelbonDAO;
import be.vdab.entities.Bestelbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author dev13
 */
@Service
@Transactional(readOnly = true)
public class BestelbonServiceImpl implements BestelbonService {
    private final BestelbonDAO bestelbonDAO;
    
    @Autowired
    public BestelbonServiceImpl(BestelbonDAO bestelbonDAO) {
        this.bestelbonDAO = bestelbonDAO;
    }

    @Override
    @Transactional()
    public void create(Bestelbon bon) {
        try {
            bestelbonDAO.save(bon);
        } catch (DataIntegrityViolationException ex) {
            throw ex;
        }
    }

    @Override
    public Bestelbon read(long bonNr) {
        return bestelbonDAO.getOne(bonNr);
    }

    @Override
    @Transactional()
    public void update(Bestelbon bon) {
        bestelbonDAO.save(bon);
    }
}
