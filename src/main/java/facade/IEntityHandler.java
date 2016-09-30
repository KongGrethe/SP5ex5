/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.City;
import entity.Country;
import java.util.ArrayList;
import java.util.List;

public interface IEntityHandler {
    
    public List<Country> getAllCountries();
    public List<Country> getAllCountriesWithPopulationGreaterThan(int criteriaValue);
    public ArrayList<City> getAllCities(String countryCode);
    public City addCity(City c);
    
}
