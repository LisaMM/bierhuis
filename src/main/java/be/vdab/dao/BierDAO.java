package be.vdab.dao;

import be.vdab.entities.Bier;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author dev13
 */
public interface BierDAO extends JpaRepository<Bier, Long> {
    Iterable<Bier> findByBrouwerBrouwernrLikeOrderByNaamAsc(long brouwerNr);
}
