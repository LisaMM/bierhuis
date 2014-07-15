/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.services.BierService;

/**
 *
 * @author dev13
 */
@Controller
@RequestMapping("/")
class IndexController {
	private final BierService bierService;
	
	@Autowired
	public IndexController(BierService bierService) {
		this.bierService = bierService;
	}
	
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView read() {
        return new ModelAndView("index", "aantalBieren", bierService.findAantalBieren());
    }
}
