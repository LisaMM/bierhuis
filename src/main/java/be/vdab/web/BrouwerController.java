/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.web;

import be.vdab.services.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author dev13
 */
@Controller
@RequestMapping("/brouwers")
class BrouwerController {
    private final BrouwerService brouwerService;
    private final BierService bierService;
    
    @Autowired
    public BrouwerController(BrouwerService brouwerService,
    		BierService bierService) {
        this.brouwerService = brouwerService;
        this.bierService = bierService;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView findAll() {
        return new ModelAndView("brouwers/brouwers", "brouwers", 
            brouwerService.findAll());
    }
    
    @RequestMapping(method = RequestMethod.GET, params="brouwerNr")
    public ModelAndView read(@RequestParam long brouwerNr) {
        ModelAndView mav = new ModelAndView("brouwers/brouwer", "brouwer", 
        		brouwerService.read(brouwerNr));
        mav.addObject("bieren", bierService.findByBrouwerNrLike(brouwerNr));
        return mav;
    }
}
