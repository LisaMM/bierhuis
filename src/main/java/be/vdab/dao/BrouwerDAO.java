package be.vdab.dao;

import be.vdab.entities.Brouwer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author dev13
 */
public interface BrouwerDAO extends JpaRepository<Brouwer, Long> {
}
