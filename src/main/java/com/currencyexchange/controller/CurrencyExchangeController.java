package com.currencyexchange.controller;

import com.currencyexchange.Currencies;
import com.currencyexchange.model.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private final RestTemplate restTemplate;

    public CurrencyExchangeController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @GetMapping("/currencies")
    public Currencies[] listCurrencies() {
        return Currencies.values();
    }


    @GetMapping("/current-rates-for-currencies")
    public Map<Currencies, Float> listCurrentRatesForCurrencies() {
        Map<Currencies, Float> listOfRates = new HashMap<Currencies, Float>();

        for (Currencies currency: Currencies.values()) {
            Currency rate = restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/rates/A/" + currency, Currency.class);
            listOfRates.put(currency, Objects.requireNonNull(rate).getRates().get(0).getMid());
        }

        return listOfRates;
    }

    @GetMapping("/current-rate/{currency}")
    public Currency getCurrentRateForCurrency(@PathVariable("currency") String currency) {
        return restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/rates/A/" + currency, Currency.class);
    }

}
