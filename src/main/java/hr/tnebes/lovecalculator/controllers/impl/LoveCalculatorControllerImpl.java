package hr.tnebes.lovecalculator.controllers.impl;

import hr.tnebes.lovecalculator.constants.Constants;
import hr.tnebes.lovecalculator.controllers.LoveCalculatorController;
import hr.tnebes.lovecalculator.services.LoveCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static hr.tnebes.lovecalculator.controllers.impl.LoveCalculatorControllerImpl.LOVE_CALCULATOR;

@RestController
@RequestMapping(Constants.API_V1 + LOVE_CALCULATOR)
public class LoveCalculatorControllerImpl implements LoveCalculatorController {

    public static final String LOVE_CALCULATOR = "/love-calculator";
    public static final String GET_LOVE_PERCENT_PATH = "/calculate";

    @Autowired
    private LoveCalculatorService loveCalculatorService;

    @Override
    @GetMapping(path = GET_LOVE_PERCENT_PATH, produces = MediaType.TEXT_PLAIN_VALUE)
    public String getLovePercent(@RequestParam(value = "name1") final String name1, @RequestParam(value = "name2") final String name2) {
        return String.valueOf(loveCalculatorService.getLovePercent(name1, name2));
    }
}
