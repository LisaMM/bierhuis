package be.vdab.services;

import be.vdab.dao.BierDAO;
import be.vdab.entities.Bier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author dev13
 */
@Service
@Transactional(readOnly = true)
public class BierServiceImpl implements BierService {
    private final BierDAO bierDAO;
    
    @Autowired
    public BierServiceImpl(BierDAO bierDAO) {
        this.bierDAO = bierDAO;
    }

    @Override
    public Iterable<Bier> findAll() {
        return bierDAO.findAll(Sort.by("naam"));
    }

    @Override
    public long findAantalBieren() {
        return bierDAO.count();
    }

    @Override
    public Bier read(long bierNr) {
        return bierDAO.getOne(bierNr);
    }

	@Override
	public Iterable<Bier> findByBrouwerNrLike(long brouwerNr) {
		return bierDAO.findByBrouwerBrouwernrLikeOrderByNaamAsc(brouwerNr);
	}
}
