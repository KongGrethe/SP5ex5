/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsonconverter;

import entity.City;
import entity.Country;
import java.util.List;

public interface IJSONConverter {
    
    public String CityToJson(City c);
    public String ListToJson(List list);
    public City JsonToCity(String json);
    public Country JsonToCountry(String json);
    
}
