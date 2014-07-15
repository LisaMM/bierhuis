package be.vdab.web;

import java.math.BigDecimal;

import be.vdab.entities.Bestelbon;
import be.vdab.services.BestelbonService;
import be.vdab.valueobjects.Bestelbonlijn;

import javax.servlet.http.HttpSession;
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
    public ModelAndView findAllLijnen() {
    	Bestelbon bestelbon = winkelwagen.getBestelbon();
    	if (bestelbon == null) {
    		bestelbon = new Bestelbon();
    		winkelwagen.setBestelbon(bestelbon);
    	}
    	Iterable<Bestelbonlijn> lijnen = bestelbon.getBestelbonlijnen();		   	
    	BigDecimal totaal = BigDecimal.ZERO;
    	if (lijnen != null) {
	    	for (Bestelbonlijn lijn : lijnen) {
	    		totaal = totaal.add(lijn.getBier().getPrijs().multiply(new BigDecimal(lijn.getAantal())));
	    	}
    	}
        ModelAndView mav = new ModelAndView("bestellingen/winkelwagen", "bestelbonlijnen", lijnen);
        mav.addObject("bestelbon", bestelbon);
        mav.addObject("totaal", totaal);
        return mav;
    }
    
    @RequestMapping(value = "winkelwagen", method = RequestMethod.POST)
    public ModelAndView create(@Valid Bestelbon bestelbon, BindingResult bindingResult,
		HttpSession session) {
    	ModelAndView mav;
        if (! bindingResult.hasErrors() && bestelbon.getBestelbonlijnen() != null) {
            bestelbonService.create(bestelbon);
//            for (Bestelbonlijn lijn : bestelbon.getBestelbonlijnen()) {
//            	bestelbonlijnService.create(lijn);
//            }
            mav = new ModelAndView("bestellingen/bevestiging", "bestelbon", bestelbon);
            mav.addObject("bonNr", bestelbon.getBonNr());
            session.removeAttribute("winkelwagen");
        } else {
        	mav = new ModelAndView("bestellingen/winkelwagen", "bestelbon", bestelbon);
        	Iterable<Bestelbonlijn> lijnen = bestelbon.getBestelbonlijnen();		   	
        	BigDecimal totaal = BigDecimal.ZERO;
        	if (lijnen != null) {
    	    	for (Bestelbonlijn lijn : lijnen) {
    	    		totaal = totaal.add(lijn.getBier().getPrijs().multiply(new BigDecimal(lijn.getAantal())));
    	    	}
        	}
            mav.addObject("bestelbonlijnen", lijnen);
            mav.addObject("totaal", totaal);
        }
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
}
