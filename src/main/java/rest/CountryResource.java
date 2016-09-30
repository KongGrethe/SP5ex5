/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import entity.City;
import facade.EntityHandler;
import facade.IEntityHandler;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import jsonconverter.IJSONConverter;
import jsonconverter.JSONConverter;

@Path("country")
public class CountryResource {
    
    private final IEntityHandler eh;
    private final IJSONConverter jsonC = new JSONConverter();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CountryResource
     */
    public CountryResource() {
        eh = new EntityHandler(Persistence.createEntityManagerFactory("persistenceunit"));
    }

    /**
     * Retrieves representation of an instance of rest.CountryResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getXml() {
        return "Hello country";
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllCountries() {
        return jsonC.ListToJson(eh.getAllCountries());
    }
    
    @GET
    @Path("population/{minPopulation}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllCountriesWithPopulationGreaterThan(@PathParam("minPopulation") int minPopulation) {
        return jsonC.ListToJson(eh.getAllCountriesWithPopulationGreaterThan(minPopulation));
    }
    
    @GET
    @Path("city/{countryCode}")
    public String getAllCities(@PathParam("countryCode") String countryCode) {
        return jsonC.ListToJson(eh.getAllCities(countryCode));
    }
    
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addCity(String jsonCity) {
        City city = eh.addCity(jsonC.JsonToCity(jsonCity));
        return jsonC.CityToJson(city); 
    }
    
}
