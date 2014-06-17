/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.web;

import be.vdab.services.BierService;
import be.vdab.valueobjects.Bestelbonlijn;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author dev13
 */
@Controller
@RequestMapping("/bieren")
@SessionAttributes("bestelbonlijnen")
class BierController {
    private final BierService bierService;
    
    @Autowired
    public BierController(BierService bierService) {
        this.bierService = bierService;
    }
    
    @RequestMapping(value="bier", method = RequestMethod.GET, params="bierNr")
    public ModelAndView createForm(@RequestParam long bierNr) {
        ModelAndView mav = new ModelAndView("bieren/bier", "bier", 
            bierService.read(bierNr));
        mav.addObject("bestelbonlijnen", new ArrayList<Bestelbonlijn>());
        mav.addObject("bestelbonlijn", new Bestelbonlijn());
        return mav;
    }
    
    @RequestMapping(value="bier", method = RequestMethod.GET, params="aantal")
    public String toevoegenAanBon(@RequestParam int aantal, 
        @Validated Bestelbonlijn bestelbonlijn, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "bieren/bier";
        } else {
            return "bestellingen/winkelwagen";
        }
    }
}
