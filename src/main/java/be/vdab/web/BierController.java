/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.web;

import be.vdab.services.BierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author dev13
 */
@Controller
@RequestMapping("/bieren")
class BierController {
    private final BierService bierService;
    
    @Autowired
    public BierController(BierService bierService) {
        this.bierService = bierService;
    }
    
    @RequestMapping(value="bier", method = RequestMethod.GET, params="bierNr")
    public ModelAndView read(@RequestParam long bierNr) {
        return new ModelAndView("bieren/bier", "bier", 
            bierService.read(bierNr));
    }
    
    @RequestMapping(value="bier", method = RequestMethod.POST)
    public String toevoegenAaanBon() {
        return "redirect:/";
    }
}
