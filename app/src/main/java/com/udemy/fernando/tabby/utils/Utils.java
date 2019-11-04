package com.udemy.fernando.tabby.utils;

import com.udemy.fernando.tabby.model.Country;

import java.util.ArrayList;

public class Utils {

    public static ArrayList<Country> getDummyCountries(){
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(new Country("España", "ES"));
        countries.add(new Country("Argentina", "AR"));
        countries.add(new Country("Bolivia", "BO"));
        countries.add(new Country("Chile", "CL"));
        countries.add(new Country("Colombia", "CO"));
        countries.add(new Country("Ecuador", "EC"));
        countries.add(new Country("Mexico", "MX"));
        countries.add(new Country("Perú", "PE"));
        countries.add(new Country("Uruguay", "UY"));
        countries.add(new Country("Venezuela", "VE"));

        return countries;
    }
}
