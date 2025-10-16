package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist.
     * @param city
     *  This is a candidate city to add
     */
    public void add(City city){
        if(cities.contains(city)){
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     *  Return the sorted list
     */
    public List<City> getCities(){
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * This returns a boolean value whether or not a given city belongs in the list
     * @param city
     *  This is the city we are looking for in the list
     * @return
     *  Return whether or not the city is in the list
     */
    public boolean hasCity(City city){
        return cities.contains(city); // https://www.geeksforgeeks.org/java/collection-contains-method-in-java-with-examples/
    }

    /**
     * This removes a city from the list if it exists
     * @param city
     *  This is the candidate city to remove
     */
    public void remove(City city){
        if (!cities.contains(city)){
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }

    /**
     * This counts the number of cities in the list
     * @return
     *  Return the count of items in the list
     */
    public int count(){
        return cities.size();
    }
}
