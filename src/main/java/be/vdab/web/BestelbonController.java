/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.web;

import java.math.BigDecimal;

import be.vdab.entities.Bestelbon;
import be.vdab.services.BestelbonService;
import be.vdab.valueobjects.Bestelbonlijn;

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
    private final Winkelwagen winkelwagen;
    
    @Autowired
    public BestelbonController(BestelbonService bestelbonService, 
    		Winkelwagen winkelwagen) {
        this.bestelbonService = bestelbonService;
        this.winkelwagen = winkelwagen;
    }
    
    @RequestMapping(value="winkelwagen", method = RequestMethod.GET)
    public ModelAndView findAllLijnen(@Valid Bestelbon bestelbon, BindingResult bindingResult) {
    	Bestelbon bon = winkelwagen.getBestelbon();
    	if (bon == null) {
    		bon = new Bestelbon();
    		winkelwagen.setBestelbon(bon);
    	}
    	Iterable<Bestelbonlijn> lijnen = bon.getBestelbonlijnen();		   	
    	BigDecimal totaal = BigDecimal.ZERO;
    	if (lijnen != null) {
	    	for (Bestelbonlijn lijn : lijnen) {
	    		totaal = totaal.add(lijn.getBier().getPrijs().multiply(new BigDecimal(lijn.getAantal())));
	    	}
    	}
        ModelAndView mav = new ModelAndView("bestellingen/winkelwagen", "bestelbonlijnen", lijnen);
        mav.addObject("totaal", totaal);
        return mav;
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
        return new ModelAndView("bestellingen/bevestiging", 
    		"bonNr", winkelwagen.getBestelbon().getBonNr());
    }
    
    @RequestMapping(value = "winkelwagen", method = RequestMethod.POST)
    public String create(@Valid Bestelbon bestelbon, BindingResult bindingResult) {
        if (! bindingResult.hasErrors() && bestelbon.getBestelbonlijnen() != null) {
            bestelbonService.create(bestelbon);
            return "bestellingen/bevestiging";
        }
        return "bestellingen/winkelwagen";
    }
}
