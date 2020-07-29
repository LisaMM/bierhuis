package be.vdab.web;

import java.math.BigDecimal;

import be.vdab.entities.Bestelbon;
import be.vdab.services.BierService;
import be.vdab.valueobjects.Bestelbonlijn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
	private final Winkelwagen winkelwagen;

	@Autowired
	public BierController(BierService bierService, Winkelwagen winkelwagen) {
		this.bierService = bierService;
		this.winkelwagen = winkelwagen;
	}

	@RequestMapping(value = "{bierNr}", method = RequestMethod.GET)
	public ModelAndView createForm(@PathVariable long bierNr) {
		ModelAndView mav = new ModelAndView("bieren/bier", "bier",
				bierService.read(bierNr));
		mav.addObject("bestelbonlijn", new Bestelbonlijn());
		return mav;
	}

	@RequestMapping(method = RequestMethod.GET, params = { "bier.bierNr", "aantal" })
	public ModelAndView toevoegenAanBon(@ModelAttribute("aantal") int aantal, 
			@ModelAttribute("bier.bierNr") Long bierNr, BindingResult bindingResult) {
		ModelAndView mav;
		if (!bindingResult.hasErrors() && aantal <= 1) {
			bindingResult.reject("foutAantal", new Object[] { aantal }, "");
		}
		if (!bindingResult.hasErrors()) {
			mav = new ModelAndView("bestellingen/winkelwagen");
			Bestelbon bon = winkelwagen.getBestelbon();
			if (bon == null) {
				bon = new Bestelbon();
				winkelwagen.setBestelbon(bon);
			}
			Bestelbonlijn bestelbonlijn = 
				new Bestelbonlijn(aantal, bierService.read(bierNr), bon);
			bon.addBestelbonlijn(bestelbonlijn);
			mav.addObject("bestelbon", bon);
			Iterable<Bestelbonlijn> lijnen = bon.getBestelbonlijnen();		   	
			mav.addObject("bestelbonlijnen", lijnen);
			BigDecimal totaal = BigDecimal.ZERO;
	    	if (lijnen != null) {
		    	for (Bestelbonlijn lijn : lijnen) {
		    		totaal = totaal.add(lijn.getBier().getPrijs().multiply(new BigDecimal(lijn.getAantal())));
		    	}
	    	}
	    	mav.addObject("totaal", totaal);
		} else {
			mav = new ModelAndView("bieren/bier", "bier",
				bierService.read(bierNr));
			mav.addObject("bestelbonlijn", new Bestelbonlijn());
			mav.addObject("error", "Vul een geheel getal groter dan 1 in");
		}
		return mav;
	}
}
