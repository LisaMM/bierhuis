/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.web;

import be.vdab.entities.Bestelbon;
import be.vdab.services.BierService;
import be.vdab.valueobjects.Bestelbonlijn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
@SessionAttributes("bestelbonlijnen")
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
		return new ModelAndView("bieren/bier", "bier",
				bierService.read(bierNr));
	}

	@RequestMapping(method = RequestMethod.GET, params = { "biernr", "aantal" })
	public ModelAndView toevoegenAanBon(@Param("aantal") int aantal, 
			@Param("bierNr") long bierNr, BindingResult bindingResult) {
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
		} else {
			mav = new ModelAndView("bieren/bier", "bier",
				bierService.read(bierNr));
		}
		return mav;
	}
}
