package com.aem.exercise.romannumeral.controller;


import com.aem.exercise.romannumeral.service.RomanNumeralService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "romannumeral")
public class RomanNumeralController {

    private RomanNumeralService romanNumeralService;

    public RomanNumeralController(RomanNumeralService romanNumeralService) {
        this.romanNumeralService = romanNumeralService;
    }

    /**
     * A rest controller method exposing a functionality to
     * convert an integer to roman numeral.
     * <p>
     * This method is exposed using HTTP 'GET' and can be accessed by calling
     * http://{host:port}/romannumeral?query={input}
     *
     * @param input - input value to be converted to roman numeral
     * @return a roman numeral for given input
     */
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE + ";charset=utf-8")
    public ResponseEntity<String> getRomanNumeral(@RequestParam("query") String input) {
        long inputValue = Long.parseLong(input);
        if (inputValue >= 1 && inputValue <= 2200000000l) {
            return ResponseEntity.ok(this.romanNumeralService.convertToRoman(inputValue));
        }
        return ResponseEntity.badRequest().build();
    }


}
