package com.udemy.fernando.tabby.model;

public class Country {
    private String name;
    private String countryCode;

    public Country(String name, String countryCode) {
        this.name = name;
        this.countryCode = countryCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getFlagURL(String countyCode){
        return "www.geognos.com/api/en/countries/fag/{0}.png".replace("{0}", countyCode);
    }

    @Override
    public String toString() {
        return name;
    }
}
