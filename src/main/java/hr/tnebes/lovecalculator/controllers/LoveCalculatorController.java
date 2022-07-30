package hr.tnebes.lovecalculator.controllers;

import org.springframework.web.bind.annotation.RequestParam;

public interface LoveCalculatorController {

    String getLovePercent(@RequestParam("name1") String name1, @RequestParam("name2") String name2);

}
