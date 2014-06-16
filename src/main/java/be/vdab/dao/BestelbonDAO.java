/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.dao;

import be.vdab.entities.Bestelbon;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author dev13
 */
public interface BestelbonDAO extends JpaRepository<Bestelbon, Long>{}
