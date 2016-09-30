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
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

public class EntityHandler implements IEntityHandler{
    
    private EntityManagerFactory emf;

    public EntityHandler(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public List<Country> getAllCountries() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Country> result = em.createNamedQuery("Country.findAll", Country.class);
        List<Country> countries = result.getResultList();
        return countries;
    }

    @Override
    public List<Country> getAllCountriesWithPopulationGreaterThan(int minPopulation) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Country> result = em.createNamedQuery("Country.findByPopulation", Country.class);
        List<Country> countries = result.setParameter("Population", minPopulation).getResultList();
        return countries;
    }

    @Override
    public ArrayList<City> getAllCities(String countryCode) {
        EntityManager em = emf.createEntityManager();
        Country country = lookupCountry(countryCode, em);
        return new ArrayList(country.getCityCollection());
    }

    @Override
    public City addCity(City city) {
        EntityManager em = emf.createEntityManager();
        //Get the city collection using private method
        ArrayList<City> cities = new ArrayList(city.getCountryCode().getCityCollection());
        // Add the new entity to the collection
        cities.add(city);
        //Update the country's collection of cities
        city.getCountryCode().setCityCollection(cities);
        //Persist the country to the database
        em.getTransaction().begin();
        em.persist(city.getCountryCode());
        em.getTransaction().commit();
        return city;
    }
    
    private Country lookupCountry(String countryCode, EntityManager man) {
        TypedQuery<Country> result = man.createNamedQuery("Country.findByCode", Country.class);
        return result.setParameter("Code", countryCode).getSingleResult();
    }
    
}
