/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.web;

import be.vdab.entities.Bestelbon;
import be.vdab.services.BestelbonService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author dev13
 */
@Controller
@RequestMapping("/bestellingen")
public class BestelbonController {
    private final BestelbonService bestelbonService;
    
    @Autowired
    public BestelbonController(BestelbonService bestelbonService) {
        this.bestelbonService = bestelbonService;
    }
    
    @RequestMapping(value="winkelwagen", method = RequestMethod.GET, 
        params = "bonNr")
    public ModelAndView findAllLijnen(@RequestParam long bonNr) {
        return new ModelAndView("bestellingen/winkelwagen", "bestelbonlijnen", 
            bestelbonService.read(bonNr).getBestelbonlijnen());
    }
    
    @RequestMapping(value = "winkelwagen", method = RequestMethod.GET)
    public ModelAndView createForm() {
        return new ModelAndView("bestellingen/winkelwagen", "bestelbon", 
            new Bestelbon());
    }
    
    @InitBinder("bestelbon")
    public void initBinderBestelbon(DataBinder dataBinder) {
        Bestelbon bestelbon = (Bestelbon) dataBinder.getTarget();
        if (bestelbon.getAdres() == null) {
            bestelbon.setAdres(new AdresForm());
        } else {
            bestelbon.setAdres(new AdresForm(bestelbon.getAdres()));
        }
    }
    
    @RequestMapping(value="bevestiging", method = RequestMethod.GET)
    public ModelAndView bevestiging() {
        return new ModelAndView("bestellingen/bevestiging");
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String create(@Valid Bestelbon bestelbon, 
        BindingResult bindingResult) {
        if (! bindingResult.hasErrors()) {
            bestelbonService.create(bestelbon);
            return "redirect:/";
        }
        return "bestellingen/winkelwagen";
    }
}
