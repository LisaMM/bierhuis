package be.vdab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.dao.BrouwerDAO;
import be.vdab.entities.Brouwer;

@Service
@Transactional(readOnly = true)
public class BrouwerServiceImpl implements BrouwerService {
    private final BrouwerDAO brouwerDAO;

    @Autowired
    public BrouwerServiceImpl(BrouwerDAO brouwerDAO) {
        this.brouwerDAO = brouwerDAO;
    }

    @Override
    public Iterable<Brouwer> findAll() {
        return brouwerDAO.findAll(new Sort("naam"));
    }

    @Override
    public Brouwer read(long brouwerNr) {
        return brouwerDAO.findOne(brouwerNr);
    }
}
