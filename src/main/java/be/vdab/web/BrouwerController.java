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
    
    @RequestMapping(method = RequestMethod.GET, value = "{brouwerNr}")
    public ModelAndView read(@PathVariable long brouwerNr) {
        ModelAndView mav = new ModelAndView("brouwers/brouwer", "brouwer", 
        		brouwerService.read(brouwerNr));
        mav.addObject("bieren", bierService.findByBrouwerNrLike(brouwerNr));
        return mav;
    }
}
