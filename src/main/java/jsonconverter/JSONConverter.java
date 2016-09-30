/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsonconverter;

import com.google.gson.Gson;
import entity.City;
import entity.Country;
import java.util.List;

public class JSONConverter implements IJSONConverter {

    private Gson gson = new com.google.gson.GsonBuilder().setPrettyPrinting().create();

    @Override
    public String ListToJson(List list) {
        return gson.toJson(list);
    }

    @Override
    public City JsonToCity(String json) {
        return gson.fromJson(json, City.class);
    }

    @Override
    public Country JsonToCountry(String json) {
        return gson.fromJson(json, Country.class);
    }

    @Override
    public String CityToJson(City c) {
        return gson.toJson(c);
    }

}
