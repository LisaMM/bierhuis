/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author dev13
 */
@Controller
@RequestMapping("/")
class IndexController {
    @RequestMapping
    public ModelAndView read() {
        return new ModelAndView("index");
    }
}
