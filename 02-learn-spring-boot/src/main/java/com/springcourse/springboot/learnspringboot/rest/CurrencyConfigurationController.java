package com.springcourse.springboot.learnspringboot.rest;

import com.springcourse.springboot.learnspringboot.configuration.CurrencyConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConfigurationController {

    public CurrencyConfiguration currencyConfiguration;

    @Autowired
    public CurrencyConfigurationController(CurrencyConfiguration currencyConfiguration) {
        this.currencyConfiguration = currencyConfiguration;
    }

    @GetMapping("/currency-configuration")
    public CurrencyConfiguration getCurrencyConfiguration()
    {
        return currencyConfiguration;
    }
}
